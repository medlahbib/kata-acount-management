package com.sg.accountManagement.entity;

import java.util.Date;

import com.sg.accountManagement.utils.OperationTypeEnum;

public class Operation {
	private OperationTypeEnum typeOfOperation;
	private Date date;
	private double amount;
	private double balance;
	private String username;
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @param typeOfOperation
	 * @param date
	 * @param amount
	 * @param balance
	 * @param username
	 */
	public Operation(OperationTypeEnum typeOfOperation, Date date,
			double amount, double balance, String username) {
		super();
		this.typeOfOperation = typeOfOperation;
		this.date = date;
		this.amount = amount;
		this.balance = balance;
		this.username = username;
	}


	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public OperationTypeEnum getTypeOfOperation() {
		return typeOfOperation;
	}
	public void setTypeOfOperation(OperationTypeEnum typeOfOperation) {
		this.typeOfOperation = typeOfOperation;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
}
