package com.user.mgmt.management_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.mgmt.management_project.model.util.SwaggerConstants;
import com.user.mgmt.management_project.services.User;
import com.user.mgmt.management_project.services.UserRepository;
import com.user.mgmt.management_project.services.UserService;
import com.user.mgmt.management_project.utils.ApprovalInDoneState;
import com.user.mgmt.management_project.utils.NotificationUtil;

	
	@RestController
	public class WorkFlowController {
		
		@Autowired
		private UserRepository  userRepository;
		
		@Autowired
		private UserService userService;
		
		@Autowired
		NotificationUtil notificationUtil;
		
		@PostMapping("/approvalFlow")
		@ResponseStatus(HttpStatus.CREATED)
		public String reviewRegistrationRequest(@RequestBody User user) {
			System.out.println("Sent for approval--------------------");
		    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	System.out.println("Approved-----------------"); 

		 	
		 	/*
		 	 * persist in DB after approval
		 	 */
		 	
		 	userService.addUser(user);
		 	/*
		 	 * Change state for User using State Design Pattern
		 	 */
		 	// Below invokes Notification Service
		 	new ApprovalInDoneState().onApproval(user);
		 	//user.setUserState(new ApprovalInDoneState(user));
		 	
		 	RestTemplate  restTemplate = new RestTemplate();
			System.out.println("Sent for approval to Admin");
		    try {
		     // restTemplate.getForObject(SwaggerConstants.NOTIFICATION_SERVICE_BASE_URL+"/newApprovalNotification", User.class);
		    	HttpEntity<User> request = new HttpEntity<>(user);
		        
		        ResponseEntity<String> result = restTemplate.postForEntity(SwaggerConstants.NOTIFICATION_SERVICE_BASE_URL+"/newApprovalNotification", request, String.class);
		    }catch(Exception e) {
		    	System.out.println(" >>>>>> " + restTemplate);
		    	e.printStackTrace();
		    }
		    System.out.println("Approved for being saved.........");
		 	
			return "WorkFlowInitiated....and Mail sent.....!";
		}
		
		
		
		@RequestMapping("/userRegistrationStatus")
		public String fetchStatus() {
			return "Fetching User status.........!";
		}
		
		
		
		
		
}
