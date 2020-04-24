package com.usecase.DEMODatabase.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

enum AccountType {
	CHECKING,
	SAVINGS
}

enum AccountCurrency {
	USD
}

enum AccountStatus {
	ACTIVE,
	INACTIVE
}

@Entity
public class Account {

	@Id
	private Long accountNumber;
	private String accountType;
	
	private int accountBranchCode;
	private BigDecimal accountBalance;
	private String accountCurrency;
	private String accountStatus;

	@ManyToOne()
	@JoinColumn(name="userID")
	@JsonIgnore
	private User user;
	
	@OneToMany()
	@JoinColumn(name="accountNumber")
	@JsonIgnore
	private List<Transaction> transactions;
	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountBranchCode() {
		return accountBranchCode;
	}

	public void setAccountBranchCode(int accountBranchCode) {
		this.accountBranchCode = accountBranchCode;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getAccountCurrency() {
		return accountCurrency;
	}

	public void setAccountCurrency(String accountCurrency) {
		this.accountCurrency = accountCurrency;
	}
	
}
