package com.example.point_career.global.auth.config;


import com.example.point_career.global.auth.jwt.JwtAuthenticationFilter;
import com.example.point_career.global.auth.jwt.JwtExceptionFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final JwtExceptionFilter jwtExceptionFilter;
	private final JwtAuthenticationFilter jwtAuthenticationFilter;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.csrf((csrfConfig) -> csrfConfig.disable())
				.httpBasic(httpBasic -> httpBasic.disable())
				.cors(cors -> cors.disable())
				.sessionManagement(
						sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				)
				.formLogin(formLogin -> formLogin.disable())
				.logout(logout -> logout.disable())
				.headers(headers -> headers
						.frameOptions(frameOptions -> frameOptions.disable())
				)
				.authorizeHttpRequests((authorizeRequests) -> authorizeRequests
						.requestMatchers("/api/v1/auth/**").permitAll()
						.requestMatchers("/","/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html", "/swagger-resources/**")
						.permitAll()
						.anyRequest().authenticated()
				)
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(jwtExceptionFilter, JwtAuthenticationFilter.class);
		return http.build();
	}
}
