package com.usecase.DEMODatabase;

public class UserSession {
	private String userID;
	private String sessionID;
	private String accountNumber;
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "UserSession [userID=" + userID + ", sessionID=" + sessionID + ", accountNumber=" + accountNumber + "]";
	}
}
