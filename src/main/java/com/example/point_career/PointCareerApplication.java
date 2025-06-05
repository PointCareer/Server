package com.example.point_career;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PointCareerApplication {
	public static void main(String[] args) {
		SpringApplication.run(PointCareerApplication.class, args);
	}

}
