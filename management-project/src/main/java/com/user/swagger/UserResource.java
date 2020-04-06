package com.user.swagger;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.user.mgmt.management_project.services.User;

@RestController
public class UserResource {
	
	Map<Long,User> users = new HashMap<>();
	
	public User getUser(@PathVariable long id) {
		return users.get(id);
	}
	

	
}
