package com.usecase.DEMOAccountInfo;

import java.util.Date;

public class Reward {

	private Long rewardsAccountId;
	private int rewardsBalance;
	private String rewardsType;
	private String rewardsRedeemStatus;
	private Date rewardsExpiry;
	
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
