package com.jwt.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class JwtValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtValidationApplication.class, args);
	}

}
