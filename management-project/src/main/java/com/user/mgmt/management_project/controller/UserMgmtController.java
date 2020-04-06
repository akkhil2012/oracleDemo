package com.user.mgmt.management_project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.user.mgmt.management_project.model.util.SwaggerConstants;
import com.user.mgmt.management_project.services.User;
import com.user.mgmt.management_project.utils.Response;
import com.user.mgmt.management_project.utils.ServiceType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;



@RestController
@ComponentScan("com.user.*")
@Api(value = "UserManagement Resource", description = "UserManagement")
public class UserMgmtController {
	
	Map<Long,User> users = new HashMap<>();
	private final AtomicLong counter = new AtomicLong();
	private static final String template = "RequestCompleted!";
	
	@Autowired
	UserController userController;
	
	/*
	 * Call Microservies based on request Parameter
	 * Works as API gateWay
	 */
	@GetMapping("/SwaggerConstants.APPLICATION")
	public Response greeting(@RequestParam(value = "serviceType", defaultValue = "service") ServiceType serviceType) {
		RestTemplate  restTemplate = new RestTemplate();
		if(serviceType==ServiceType.REGISTRATION)
			 restTemplate.getForObject(SwaggerConstants.REGISTRATION_SERVICE_BASE_URL+"/newRegistration", User.class);
		else if(serviceType==ServiceType.WORKFLOW) {
			 restTemplate.getForObject(SwaggerConstants.WORKFLOW_SERVICE_BASE_URL+"/approvalFlow", User.class);
		}
		 return new Response(counter.incrementAndGet(), template);
	}
	
	/*
	//UserController userController = new UserController();
	//@RequestMapping("/userRegistration")
	@Value("Akkhil")
	private String message;
	
	
	@RequestMapping(value = "/addNewUser", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addEmployee", "emp", new User(003,"",""));
	}
	
	@ApiOperation(value = "Returns Hello World")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 100, message = "100 is the message"),
                    @ApiResponse(code = 200, message = "Successful Hello World")
            }
    )
	
//	@ApiOperation(value = "Returns Hello World") 
	@RequestMapping(path = "/userRegistration", method = RequestMethod.POST,headers = "Accept=application/json")
    	public String index() throws JSONException {
		
		System.out.println("Before calling controller");
		//return userController.registerUser();
		//System.out.println("After calling controller");
	//	return "Greetings from Spring Boot!";
		
		 * 
		 * Navigate to a Page that will fill in details and send POST call to another microserrvice: UserregistrationService
		 
		HttpHeaders headers = new HttpHeaders();
		JSONObject personJsonObject = new JSONObject();
	    personJsonObject.put("id", 1);
	    personJsonObject.put("name", "John");
		HttpEntity<String> request = 
			      new HttpEntity<String>(personJsonObject.toString(), headers);
		RestTemplate  restTemplate = new RestTemplate();
		
		//System.out.println("Before calling the Registration Service");
		//model.addAttribute("message",message); 
		//return "RegistrationForm";
		//return new ModelAndView("RegistrationForm");
		System.out.println("Before  calling the Registration Service@@@@@@@@@@@@");
		try {
		//restTemplate.postForObject("http://localhost:1111/registrationService/newRegistration", request, String.class);
		restTemplate.getForObject("http://localhost:1111/registrationService/users", User.class);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ e.getMessage());
		}
		System.out.println("After  calling the Registration Service@@@@@@@@@@@@");
		return "User added";
	}
	
	
	@GetMapping("/getUsers")
	public List<User> getAllUsers(){
		User user = new User();
		user.setFirstName("Akkhil");
		users.put(1l, user);
		return new ArrayList<User>(users.values());
	}
	
	
	@RequestMapping("/userRegistration/{userID}")
	public void registerUser() throws JSONException {
		
		HttpHeaders headers = new HttpHeaders();
		JSONObject personJsonObject = new JSONObject();
	    personJsonObject.put("id", 1);
	    personJsonObject.put("name", "John");
		HttpEntity<String> request = 
			      new HttpEntity<String>(personJsonObject.toString(), headers);
		RestTemplate  restTemplate = new RestTemplate();
		

		System.out.println("Before calling the Registration Service");
		restTemplate.postForObject("http://localhost:1111/registrationService/newRegistration", request, String.class);
		System.out.println("After  calling the Registration Service");
		return;
		
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/")
	public String indexDefault() {
		return "Greetings from Spring Boot! : Home Page";
	}
	
	
	
	
	
	
	    @Autowired
	    private EmployeeDAO employeeDao;
	     
	    @GetMapping(path="/", produces = "application/json")
	    public Employees getEmployees() 
	    {
	        return employeeDao.getAllEmployees();
	    }

*/}
