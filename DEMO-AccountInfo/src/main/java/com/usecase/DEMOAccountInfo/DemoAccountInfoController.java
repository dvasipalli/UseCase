package com.usecase.DEMOAccountInfo;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoAccountInfoController {
	
    private static final Logger LOGGER = LogManager.getLogger(DemoAccountInfoController.class);

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/bank/user/dashboard/accountInfo")
	public AccountInfoResponse accountInfo (@RequestBody AccountInfoRequest request) {
		//LOGGER.info(request);
		AccountInfoResponse response = new AccountInfoResponse();
		
		if (isValidUser(request.getUserID(), request.getSessionID(), response) == true) {
			Map<String, String> params = new HashMap<>();
			params.put("userID", request.getUserID());
			try {
				ResponseEntity<Account[]> responseAccounts = restTemplate.getForEntity("http://demo-database/domain/user/dashboard/accountInfo/{userID}",
					Account[].class, params);
				response.setAccounts(responseAccounts.getBody());
			} catch (Exception e) {
				LOGGER.info(e);
				setErrorResponse("ERROR_FETCHING_ACCOUNTS", "Error while trying to fetch accounts from DB, try again!", response);
			}
		}
		
		return response;
	}
	
	@GetMapping(path="/bank/user/rewards/{userID}")
	public AccountInfoResponse getRewards(@PathVariable String userID, @RequestHeader String sessionID) {
		AccountInfoResponse response = new AccountInfoResponse();
		//LOGGER.info(userID);
		//LOGGER.info("******* ---------> " + sessionID);
		
		if (isValidUser(userID, sessionID, response) == true) {
			Map<String, String> params = new HashMap<>();
			params.put("userID", userID);
			
			try {
				ResponseEntity<Reward[]> responseRewards = restTemplate.getForEntity("http://demo-database/domain/user/rewards/{userID}",
						Reward[].class, params);
				response.setRewards(responseRewards.getBody());
			} catch (Exception e) {
				LOGGER.info(e);
				setErrorResponse("ERROR_FETCHING_REWARDS", "Error while trying to fetch reward details from DB, try again!", response);
			}
		}
		return response;
	}

	@PostMapping("/bank/user/dashboard/transactions")
	public AccountInfoResponse transactionInfo (@RequestBody AccountInfoRequest request) {
		AccountInfoResponse response = new AccountInfoResponse();
		
		User user = isValidSession(request.getSessionID(), response);
		
		if(user != null) {
			Map<String, String> params = new HashMap<>();
			params.put("accountNumber", request.getAccountNumber());
			try {
				ResponseEntity<Transaction[]> responseTransactions = restTemplate.getForEntity("http://demo-database/domain/user/dashboard/transactions/{accountNumber}",
					Transaction[].class, params);
				response.setTransactions(responseTransactions.getBody());
			} catch(Exception e) {
				LOGGER.info(e);
				response.setErrorCode("INVALID_ACCOUNT_NUMBER");
				response.setErrorMessage("Unable to fetch transactions for account : " + request.getAccountNumber());
			}
		}
		return response;
	}

	private boolean isValidUser (String userID, String sessionID, AccountInfoResponse response) {
		
		User user = isValidSession(sessionID, response);
		
		if(user != null) {
			if(userID.compareTo(user.getUserID()) == 0) {
				return true;
			} else {
				setErrorResponse("INVALID_USER", "User not found with user id: " + userID, response);
				return false;
			}
		}	
		return false;
	}
	
	private User isValidSession(String sessionID, AccountInfoResponse response) {

		Map<String, String> params = new HashMap<>();
		params.put("sessionID", sessionID);
		
		try {
			String url = "http://demo-database/domain/user/authentication";
			User user = restTemplate.postForEntity(url, params, User.class).getBody();
			if(user.getSessionStatus().compareToIgnoreCase("ACTIVE") == 0) {		// session active
				return user;
			} else {																// session inactive
				setErrorResponse("SESSION_INACTIVE", "The session is inactive, please login again", response);
				return null;
			}
		} catch (Exception e) {
			setErrorResponse("INVALID_SESSION", "Session not found with session id: " + sessionID, response);
			return null;
		}
	}

	private void setErrorResponse(String errorCode, String errorMessage, AccountInfoResponse response) {
		response.setErrorCode(errorCode);
		response.setErrorMessage(errorMessage);
	}
}
