package com.sg.accountManagement.service;

import java.util.List;

import com.sg.accountManagement.entity.Operation;

public interface IAccountService {

	List<Operation> getAllOperationByClientId(int id);

	void deposit(double amount,int idClient);

	void withdrawal(double amount,int idClient) throws Exception;

	void deleteOperations();

}
