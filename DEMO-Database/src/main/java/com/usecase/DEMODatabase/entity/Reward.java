package com.usecase.DEMODatabase.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reward {

	@Id
	private Long rewardsAccountId;
	private int rewardsBalance;
	private String rewardsType;
	private String rewardsRedeemStatus;
	private Date rewardsExpiry;
	
	@ManyToOne()
	@JoinColumn(name="userID")
	@JsonIgnore
	private User user;
	
	public Long getRewardsAccountId() {
		return rewardsAccountId;
	}
	public void setRewardsAccountId(Long rewardsAccountId) {
		this.rewardsAccountId = rewardsAccountId;
	}
	public int getRewardsBalance() {
		return rewardsBalance;
	}
	public void setRewardsBalance(int rewardsBalance) {
		this.rewardsBalance = rewardsBalance;
	}
	public String getRewardsType() {
		return rewardsType;
	}
	public void setRewardsType(String rewardsType) {
		this.rewardsType = rewardsType;
	}
	public String getRewardsRedeemStatus() {
		return rewardsRedeemStatus;
	}
	public void setRewardsRedeemStatus(String rewardsRedeemStatus) {
		this.rewardsRedeemStatus = rewardsRedeemStatus;
	}
	public Date getRewardsExpiry() {
		return rewardsExpiry;
	}
	public void setRewardsExpiry(Date rewardsExpiry) {
		this.rewardsExpiry = rewardsExpiry;
	}
	
}
