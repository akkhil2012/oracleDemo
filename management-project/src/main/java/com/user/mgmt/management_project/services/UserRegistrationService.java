package com.user.mgmt.management_project.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

	
	@SpringBootApplication
	@EnableSwagger2
	@ComponentScan("com.user.mgmt.management_project.controller")
	@EnableJpaRepositories
	public class UserRegistrationService {
		public static void main(String[] args) {
			System.setProperty("server.servlet.context-path", "/registrationService");
			System.setProperty("spring.config.name", "registration-server");
			SpringApplication.run(UserMgmtService.class, args);
		}
		
		

	}


