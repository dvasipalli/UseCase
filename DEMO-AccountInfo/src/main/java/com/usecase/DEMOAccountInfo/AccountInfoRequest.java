package com.usecase.DEMOAccountInfo;

public class AccountInfoRequest {

	private String sessionID;
	private String userID;
	private String accountNumber;
	
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Override
	public String toString() {
		return "AccountInfoRequest [sessionID=" + sessionID + ", userID=" + userID + ", accountNumber=" + accountNumber
				+ "]";
	}
}
