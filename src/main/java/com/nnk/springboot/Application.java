package com.nnk.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The Application of poseidon using thymleaf and spring security.
 * REST API with Spring Boot.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
