package com.user.mgmt.management_project.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkFlowService {
	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/workFlowService");
		System.setProperty("spring.config.name", "workflow-server");
		SpringApplication.run(UserMgmtService.class, args);
	}
	

}
