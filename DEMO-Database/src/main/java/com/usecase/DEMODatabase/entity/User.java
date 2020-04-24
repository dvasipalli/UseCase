package com.usecase.DEMODatabase.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

enum SessionStatus {
	ACTIVE,
	INACTIVE
}

enum CustomerType {
	TIER1,
	TIER2,
	TIERELITE,
	TIERGOLD
} 

@Entity
public class User {
	
	@Id
	private String userID;
	private String password;
	private String customerName;
	
	@Temporal(TemporalType.DATE)
	private Date lastLoginDate;
	
	private String customerType;
	private String customerSessionID;
	private String sessionStatus;
	
	@OneToMany()
	@JoinColumn(name="userID")
	@JsonIgnore
	private List<Account> accounts;
	
	@OneToMany()
	@JoinColumn(name="userID")
	@JsonIgnore
	private List<Reward> rewards;
	
	public List<Reward> getRewards() {
		return rewards;
	}

	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getUserID() {
		return userID;
	}

	public String getPassword() {
		return password;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public void setCustomerSessionID(String customerSessionID) {
		this.customerSessionID = customerSessionID;
	}

	public void setSessionStatus(String sessionStatus) {
		this.sessionStatus = sessionStatus;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public String getCustomerType() {
		return customerType;
	}

	public String getCustomerSessionID() {
		return customerSessionID;
	}

	public String getSessionStatus() {
		return sessionStatus;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", password=" + password + ", customerName=" + customerName
				+ ", lastLoginDate=" + lastLoginDate + ", customerType=" + customerType + ", customerSessionID="
				+ customerSessionID + ", sessionStatus=" + sessionStatus + "]";
	}
	
}
