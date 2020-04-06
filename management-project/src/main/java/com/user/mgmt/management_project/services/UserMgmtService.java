package com.user.mgmt.management_project.services;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.user.mgmt.management_project.controller")
@EnableSwagger2
public class UserMgmtService {
	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/managementService");
		System.setProperty("spring.config.name", "web-server");
		SpringApplication.run(UserMgmtService.class, args);
	}
	
	

}
