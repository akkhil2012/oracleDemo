package com.user.mgmt.management_project.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationService {
	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/notificationService");
		System.setProperty("spring.config.name", "notification-server");
		SpringApplication.run(NotificationService.class, args);
	}
	

}
