package com.usecase.DEMOLogoff;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoLogoffController {

    private static final Logger LOGGER = LogManager.getLogger(DemoLogoffController.class);

	@Autowired
    private RestTemplate restTemplate;
	
	@DeleteMapping(path="/bank/user/authentication")
	public LogoffResponse logoffSession(@RequestBody LogoffRequest session) {
		
		Map<String, String> params = new HashMap<>();
		params.put("sessionID", session.getSessionID());

	    //LOGGER.info("sessionID ****** ---> " + session.getSessionID());
	    try {
	    	restTemplate.put("http://demo-database/domain/user/deactivateSession", params);
	    	return new LogoffResponse("Logoff Successful");
	    } catch (Exception e) {
	    	LOGGER.info(e);
	    	return new LogoffResponse("Unable to logoff - Invalid Session ID");
	    }
	}
}
