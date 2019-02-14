package com.sg.accountManagement.entity;

import java.util.Date;

public class Statement {
	private Date date;
	private double amount;
	private double balance;
	
	
	public Statement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Statement(Date date, double amount, double balance) {
		super();
		this.date = date;
		this.amount = amount;
		this.balance = balance;
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
	
	
}
