package com.usecase.DEMOAccountInfo;


import java.util.Date;

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

public class User {
	
	private String userID;
	private String password;
	private String customerName;
	
	private Date lastLoginDate;
	
	private String customerType;
	private String customerSessionID;
	private String sessionStatus;
	
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
	
}
