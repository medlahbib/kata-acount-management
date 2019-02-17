package com.sg.accountManagement.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.accountManagement.entity.Client;
import com.sg.accountManagement.entity.Operation;
import com.sg.accountManagement.repository.IClientRepository;
import com.sg.accountManagement.repository.IOperationRepository;
import com.sg.accountManagement.utils.OperationTypeEnum;

@Service
public class AccountService implements IAccountService{
	
	//the two classes were declared to simulate the repository functions
	@Autowired
	IClientRepository clientRepository;
	
	@Autowired
	IOperationRepository operationRepository;
	
	/**
	 * get All Operations
	 */
	public List<Operation> getAllOperations() {
		return operationRepository.findAll();
	}
	
	
	/**
	 * get All Operation By ClientId
	 */
	public List<Operation> getAllOperationByClientId(int id) {
		return operationRepository.findByIdClient(id);
	}

	/**
	 * deposit 
	 */
	public void deposit(double amount,int idClient) {
		Client client = clientRepository.findById(idClient);
		client.setBalance(amount+client.getBalance());
		clientRepository.update(client);
		operationRepository.save(new Operation(OperationTypeEnum.DEPOSIT, new Date(), amount, client.getBalance(), idClient));
	}

	/**
	 * withdrawal
	 */
	public void withdrawal(double amount,int idClient) throws Exception {
		Client client = clientRepository.findById(idClient);
		if (client.getBalance()< amount) {
			throw new Exception("Insufisant Balance");
		} else {
			client.setBalance(client.getBalance()-amount);
			clientRepository.update(client);
			operationRepository.save(new Operation(OperationTypeEnum.WITHDRAWAL, new Date(), amount, client.getBalance(), idClient));
		}
	}

	/**
	 * Delete all operations 
	 */
	public void deleteOperations() {
		operationRepository.deleteOperations();
		
	}

	

}
