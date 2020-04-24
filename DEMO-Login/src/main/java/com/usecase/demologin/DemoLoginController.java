package com.usecase.demologin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/*import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;*/

@RestController
public class DemoLoginController {
	
	@Autowired
    private RestTemplate restTemplate;
	
	/*
	 * @Autowired private EurekaClient discoveryClient;
	 */
	
	@PostMapping("/bank/user/authentication")
	public AuthenticationResponse loginAuthentication(@RequestBody AuthenticationRequest request) {
		
		AuthenticationResponse response = new AuthenticationResponse();
		/*
		 * InstanceInfo instance =
		 * discoveryClient.getNextServerFromEureka("demo-database", false);
		 * System.out.println(instance.toString());
		 * System.out.println(instance.getHomePageUrl());
		 */
			        
		Map<String, String> params = new HashMap<>();
		params.put("userID", request.getUserID());
		
		try {
			User user = restTemplate.getForEntity("http://demo-database/domain/user/authentication/{userID}", 
					User.class, params).getBody();
			
			if(request.getPassword().compareTo(user.getPassword()) == 0) {			// Correct password
				if(user.getSessionStatus().compareToIgnoreCase("ACTIVE") == 0) {	// Already Logged in
					response.setLoginStatus("User already logged in");
					response.setSessionID(user.getCustomerSessionID());
					response.setLastLoginDate(new SimpleDateFormat("M/d/y").format(user.getLastLoginDate()));
				} else {															// Login Now
					String sessionID = UUID.randomUUID().toString();

			        Map<String, String> updateParams = new HashMap<>();
			        updateParams.put("userID", user.getUserID());
			        updateParams.put("sessionID", sessionID);

			        restTemplate.put("http://demo-database/domain/user/updateLoginDetails", updateParams);
					response.setLoginStatus("Login Successful");
					response.setSessionID(sessionID);
					response.setLastLoginDate(new SimpleDateFormat("M/d/y").format(new Date()));
				}
				response.setCustomerName(user.getCustomerName());
				response.setCustomerType(user.getCustomerType());
			} else {																// Incorrect password
				response.setLoginStatus("Invalid password");;
			}
		} catch(RestClientException e) {
			System.out.println("***** -------> " + e + " <------ *****");
			response.setLoginStatus("Unable to login, Please try again!");
		} catch(NullPointerException e) {
			System.out.println("***** -------> " + e + " <------ *****");
			response.setLoginStatus("Invalid UserID");
		} catch(Exception e) {
			System.out.println("***** -------> " + e + " <------ *****");
			response.setLoginStatus("Something went wrong!");
		}
		return response;
	}
}