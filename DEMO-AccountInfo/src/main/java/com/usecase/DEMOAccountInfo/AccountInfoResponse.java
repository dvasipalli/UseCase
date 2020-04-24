package com.usecase.DEMOAccountInfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class AccountInfoResponse {

	@JsonInclude(Include.NON_ABSENT)
	private String errorCode;
	
	@JsonInclude(Include.NON_ABSENT)
	private String errorMessage;
	
	@JsonInclude(Include.NON_ABSENT)
	private Account[] accounts;
	
	@JsonInclude(Include.NON_ABSENT)
	private Transaction[] transactions;
	
	@JsonInclude(Include.NON_ABSENT)
	private Reward[] rewards;

	public Reward[] getRewards() {
		return rewards;
	}

	public void setRewards(Reward[] rewards) {
		this.rewards = rewards;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public Transaction[] getTransactions() {
		return transactions;
	}

	public void setTransactions(Transaction[] transactions) {
		this.transactions = transactions;
	}
}
