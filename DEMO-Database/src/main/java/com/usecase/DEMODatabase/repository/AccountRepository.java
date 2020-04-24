package com.usecase.DEMODatabase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usecase.DEMODatabase.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	List<Account> findByUserUserID(String userID);
}
