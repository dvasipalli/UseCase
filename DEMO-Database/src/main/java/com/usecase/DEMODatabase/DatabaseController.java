package com.usecase.DEMODatabase;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.DEMODatabase.entity.User;
import com.usecase.DEMODatabase.entity.Account;
import com.usecase.DEMODatabase.entity.Reward;
import com.usecase.DEMODatabase.entity.Transaction;
import com.usecase.DEMODatabase.repository.UserRepository;
import com.usecase.DEMODatabase.repository.AccountRepository;
import com.usecase.DEMODatabase.repository.RewardRepository;
import com.usecase.DEMODatabase.repository.TransactionRepository;

@RestController
public class DatabaseController {

    private static final Logger LOGGER = LogManager.getLogger(DatabaseController.class);
    
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private RewardRepository rewardRepository;
	
	@GetMapping(path="/domain/user/authentication/{userID}")
	public User authentication(@PathVariable String userID) {
		return userRepository.findByUserID(userID);
	}
	
	@PostMapping(path="/domain/user/authentication")
	public User authenticationBySessionID(@RequestBody UserSession session) {
		//LOGGER.info(session);
		return userRepository.findByCustomerSessionID(session.getSessionID());
	}
	
	@PutMapping(path="/domain/user/updateLoginDetails")
	public void activateSession(@RequestBody UserSession session) {
		User user = userRepository.findByUserID(session.getUserID());
		user.setLastLoginDate(new Date());
		user.setCustomerSessionID(session.getSessionID());
		user.setSessionStatus("ACTIVE");
		//LOGGER.info(user);
		userRepository.save(user);
		return;
	}
	
	@PutMapping(path="/domain/user/deactivateSession")
	public void deactivateSession(@RequestBody UserSession session) {
		
		User user = userRepository.findByCustomerSessionID(session.getSessionID());
		user.setSessionStatus("INACTIVE");
		userRepository.save(user);
		return;
	}
	
	@GetMapping(path="/domain/user/dashboard/accountInfo/{userID}")
	public List<Account> accountInfo(@PathVariable String userID) {
		return accountRepository.findByUserUserID(userID);
	}
	
	@GetMapping(path="/domain/user/dashboard/transactions/{accountNumber}")
	public List<Transaction> transactionInfo(@PathVariable Long accountNumber) {		
		//LOGGER.info("***** ------> account number " + accountNumber);
		return transactionRepository.findByAccountAccountNumber(accountNumber);
	}
	
	@GetMapping(path="/domain/user/rewards/{userID}")
	public List<Reward> getRewards(@PathVariable String userID) {
		return rewardRepository.findByUserUserID(userID);
	}
}
