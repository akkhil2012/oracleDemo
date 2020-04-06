package com.user.mgmt.management_project.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


@Service
@ComponentScan("com.user.*")
@RequestMapping("/userProcessor")
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository  userRepository;
	
	/*
	 * 
	 * to fetch Users
	 */
	@GetMapping("/users")
    public Optional<User> fetchUserById(long id) {
		return userRepository.findById(id);
        /*List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(e -> users.add(e));
        System.out.println("Users count " + users.size());
        return users;*/
    }
	
	/*
	 * To edit in service layer
	 */
	public User editUsers(long id,User user) {
		if(userRepository.findById(id).isPresent()) {
			User existingUser = userRepository.findById(id).get();
			existingUser.setEmail(user.getEmail());
			existingUser.setFirstName(user.getFirstName());
			User updateUser = userRepository.save(existingUser);
			
			return User.createUserWithAllParameters(updateUser);
			/*return new User(updateUser.getId(),updateUser.getFirstName(),updateUser.getUserID(),updateUser.getLastName(),
					updateUser.getEmail());*/
			/*
			 * instead of the multi paramter constructor : call Factory Mathod By Name
			 */
		}else
			return null;
		
	}
	
	
	
	/*
	 * Delete User from Service
	 */
	public void deleteUser(long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
		
	}
	
	
    @PostMapping("/adduser")
    public User addUser(@Valid User user) {
    	System.out.println("Before   calling the repository save");
    	HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
      
        try {
        	
        userRepository.save(user);
        }catch(Exception e) {
        	System.out.println("------ error while saving-------------");
        	e.printStackTrace();
        }
        System.out.println("After saving the User...");
        Iterable<User> it = userRepository.findAll();

        List users = new ArrayList<User>();
        it.forEach(e -> users.add(e));

        return user;
    }


 
 


}
