package com.example.point_career.global.common.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
public class WebConfig {

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();

		//config.addAllowedOrigin("http://10.0.2.2:*");
		//config.addAllowedOriginPattern("*"); // 모든 도메인 허용 (보안상 주의)
		config.setAllowedOriginPatterns(List.of("http://10.0.2.2:*"));
		config.addAllowedMethod("*");        // GET, POST, PUT, DELETE 등 모두 허용
		config.addAllowedHeader("*");        // 모든 헤더 허용
		config.setAllowCredentials(true);    // 쿠키 허용 (필요한 경우)

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);

		return source;
	}
}
