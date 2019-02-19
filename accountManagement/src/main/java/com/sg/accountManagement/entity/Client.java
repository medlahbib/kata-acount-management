package com.sg.accountManagement.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Client implements UserDetails  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private double balance;
	private List<Operation> operationsList;
	private String username;
	private String password;
	


	/**
	 * @param id
	 * @param balance
	 * @param operationsList
	 * @param username
	 * @param password
	 */
	public Client(int id, double balance, List<Operation> operationsList,
			String username, String password) {
		super();
		this.id = id;
		this.balance = balance;
		this.operationsList = operationsList;
		this.username = username;
		this.password = password;
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

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
