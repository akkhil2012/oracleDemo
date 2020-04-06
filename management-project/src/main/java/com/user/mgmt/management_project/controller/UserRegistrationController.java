package com.user.mgmt.management_project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
//netstat -aon | findstr 8080
//taskkill /F /PID
import org.springframework.web.client.RestTemplate;

import com.user.mgmt.management_project.model.util.SwaggerConstants;
import com.user.mgmt.management_project.services.IUserService;
import com.user.mgmt.management_project.services.User;
import com.user.mgmt.management_project.services.UserService;
import com.user.mgmt.management_project.utils.ServiceType;
	
	@RestController
	public class UserRegistrationController {
		
		Map<Long,User> users = new HashMap<>();
		
		@Autowired
		IUserService userService;
		
		@Autowired
		WorkFlowController workFlowController;
		
		/*
		 * 
		 * Add User
		 */
		@PostMapping("/newRegistration")
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<User> registerUser(@RequestBody User user) {
			System.out.println("Entered stat registration................... Registration controller");
			/*
			 * get it reviewd from Admin
			 */
			//workFlowController.reviewRegistrationRequest(user);
			RestTemplate  restTemplate = new RestTemplate();
			System.out.println("Sent for approval to Admin");
		     restTemplate.getForObject(SwaggerConstants.WORKFLOW_SERVICE_BASE_URL+"/approvalFlow", User.class);
			System.out.println("Approved for being saved.........");
		    /*
			 * 
			 * lets waiting time be define by Thread sleeep time
			 */
			// Change the state form Approval in progress to Approved state
			
			
			userService.addUser(user);
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
		
		/*
		 * 
		 *  Edit User
		 */
		@PutMapping(value = "/editUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.CREATED)
	    public User editUsers(@PathVariable(value = "id") long id,
                @RequestBody User user) {
			return userService.editUsers(id,user);
		}
		
		/*
		 * 
		 * Delete User
		 * 
		 */
		
		@PutMapping(value = "/deleteUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
	    public void deleteUser(@PathVariable(value = "id") long id) {
			userService.deleteUser(id);
		}
		
		/*
		 * 
		 * 
		 * Fetch User
		 */
		/*@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.FOUND)
	    public List<User> fetUsersUser() {
			return userService.fetchUsers();
		}*/
		
		/*
		 * Fetch User By ID
		 */
		@GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
	    public Optional<User> fetchUsersUserByID(@PathVariable("id") final long id) {
			
			return userService.fetchUserById(id);
		}
		
		

}
