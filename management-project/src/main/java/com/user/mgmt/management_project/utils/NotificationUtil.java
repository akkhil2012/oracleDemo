package com.user.mgmt.management_project.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class NotificationUtil {
	/*
	@Autowired
    private JavaMailSender javaMailSender;
	
	public void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("akkhil2012@gmail.com");

        msg.setSubject("New Registration Mail");
        msg.setText("Hi User! You have been registered");

        try {
        	javaMailSender.send(msg);
        }catch (Exception e) {
			e.printStackTrace();
			System.out.println("------------- " + javaMailSender);
		}

    }*/

}
