package com.sg.accountManagement.entity;

import java.util.Date;

import com.sg.accountManagement.utils.OperationTypeEnum;

public class Operation {
	private OperationTypeEnum typeOfOperation;
	private Date date;
	private double amount;
	private double balance;
	private int idClient;
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Operation(OperationTypeEnum typeOfOperation, Date date,
			double amount, double balance, int idClient) {
		super();
		this.typeOfOperation = typeOfOperation;
		this.date = date;
		this.amount = amount;
		this.balance = balance;
		this.idClient = idClient;
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
	/**
	 * @return the idClient
	 */
	public int getIdClient() {
		return idClient;
	}
	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	
}
