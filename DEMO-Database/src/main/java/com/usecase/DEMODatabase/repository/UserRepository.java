package com.usecase.DEMODatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usecase.DEMODatabase.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	User findByUserID(String userID);
	User findByCustomerSessionID(String customerSessionID);
}
