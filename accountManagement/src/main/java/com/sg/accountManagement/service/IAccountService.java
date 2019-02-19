package com.sg.accountManagement.service;

import java.util.List;

import com.sg.accountManagement.entity.Client;
import com.sg.accountManagement.entity.Operation;

public interface IAccountService {

	Client getClientByUsername(String username);
	
	List<Operation> getAllOperationByClientId(int id);

	void deposit(double amount,String username);

	void withdrawal(double amount,String username) throws Exception;

	void deleteOperations();

	List<Operation> getAllOperations();

}
