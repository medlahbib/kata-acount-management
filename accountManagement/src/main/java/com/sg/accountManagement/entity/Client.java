package com.sg.accountManagement.entity;

import java.util.List;

public class Client {

	private int id;
	private double balance;
	private List<Operation> operationsList;
	
	public Client(int id, double balance, List<Operation> operationsList) {
		super();
		this.id = id;
		this.balance = balance;
		this.operationsList = operationsList;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the operationsList
	 */
	public List<Operation> getOperationsList() {
		return operationsList;
	}

	/**
	 * @param operationsList the operationsList to set
	 */
	public void setOperationsList(List<Operation> operationsList) {
		this.operationsList = operationsList;
	}
	
	
	
}
