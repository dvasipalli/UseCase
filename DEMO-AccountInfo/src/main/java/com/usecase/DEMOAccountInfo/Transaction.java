package com.usecase.DEMOAccountInfo;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
	
	private Date transactionDate;
	private BigDecimal transactionAmount;
	private String transactionCurrency;
	private String transactionStatus;
	private String transactionDescription;
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionCurrency() {
		return transactionCurrency;
	}
	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	
	@Override
	public String toString() {
		return "Transaction [transactionDate=" + transactionDate + ", transactionAmount="
				+ transactionAmount + ", transactionCurrency=" + transactionCurrency + ", transactionStatus="
				+ transactionStatus + ", transactionDescription=" + transactionDescription + "]";
	}
}
