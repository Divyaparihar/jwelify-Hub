package com.jwelifyhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.jwelifyhub")
@EnableJpaRepositories(basePackages = "com.jwelifyhub.repository")
public class JwelifyHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwelifyHubApplication.class, args);
	}

}
