package com.usecase.DEMODatabase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usecase.DEMODatabase.entity.Reward;

public interface RewardRepository extends JpaRepository<Reward, Long>{
	List<Reward> findByUserUserID(String userID);

}
