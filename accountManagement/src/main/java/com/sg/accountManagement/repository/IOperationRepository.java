package com.sg.accountManagement.repository;

import java.util.List;

import com.sg.accountManagement.entity.Operation;

public interface IOperationRepository {


	List<Operation> findAll();
	
	List<Operation> findByIdClient(int id) ;

	void save(Operation operation) ;

	void deleteOperations();
	
	
}
