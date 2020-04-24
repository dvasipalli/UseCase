package com.usecase.DEMODatabase.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	private Date transactionDate;
	private BigDecimal transactionAmount;
	private String transactionCurrency;
	private String transactionStatus;
	private String transactionDescription;
	
	@ManyToOne()
	@JoinColumn(name="accountNumber")
	@JsonIgnore
	private Account account;
	
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
		return "Transaction [id=" + id + ", transactionDate=" + transactionDate + ", transactionAmount="
				+ transactionAmount + ", transactionCurrency=" + transactionCurrency + ", transactionStatus="
				+ transactionStatus + ", transactionDescription=" + transactionDescription + "]";
	}
}
