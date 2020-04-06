package com.user.mgmt.management_project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.user.mgmt.management_project.services.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.mail.*;  
import javax.mail.internet.*;

import java.util.Properties;

import javax.activation.*; 
import com.user.mgmt.management_project.model.util.SwaggerConstants;
	
	@RestController
	@Api(SwaggerConstants.NOTIFICATION_API)
	@ApiOperation(value = SwaggerConstants.CATEGORY_CREATE_INFO_MSG, notes = SwaggerConstants.CATEGORY_CREATE_INFO_MSG_NOTE)
	public class NotificationController {

		@RequestMapping(value = "/newApprovalNotification", method = RequestMethod.POST)
		@ResponseStatus(HttpStatus.OK)
		public String index(@RequestBody User user) {
			System.out.println("Entered the NotificationService@@@@@@@");
			  String to = "akkhil2012@gmail.com";//change accordingly  
		      String from = "akkhil2012@gmail.com";
		      String host = "localhost";//or IP address  
		  
		     //Get the session object  
		      Properties properties = System.getProperties();  
		      properties.setProperty("mail.smtp.host", "127.0.0.1");  
		      Session session = Session.getDefaultInstance(properties);  
		  
		     //compose the message  
		      try{  
		         MimeMessage message = new MimeMessage(session);  
		         message.setFrom(new InternetAddress(from));  
		         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		         message.setSubject("Ping................");  
		         message.setText("Hello, this is example of sending email  ");  
		  
		         // Send message  
		         try {
		         Transport.send(message);  
		         }catch(Exception e) {
		        	 e.printStackTrace();
		        	 System.out.println("------------- " + e.getMessage());
		         }
		         System.out.println("message sent successfully....");  
		  
		      }catch (MessagingException mex) {
		    	  mex.printStackTrace();
		    }  
		     
			return "SendingNotification.........!";
		}

}
