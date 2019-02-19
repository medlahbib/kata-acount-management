package com.sg.accountManagement.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sg.accountManagement.entity.Client;
import com.sg.accountManagement.entity.Operation;
import com.sg.accountManagement.service.IAccountService;
import com.sg.accountManagement.utils.OperationTypeEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountControllerTests {

	@Autowired
	IAccountService accountService;
	
	@Before
	/**
	 * Clean all operations
	 */
	public void initTests() {
		accountService.deleteOperations();

	}
	
	@Test
	public void testDeposit() {

		// deposit
		double amount = 200;
		// the client with username = 2 doesn't have any previous operations
		String username = "2";
		Client c = accountService.getClientByUsername(username);
		accountService.deposit(amount,username);
		//select operations
		List<Operation> list = accountService.getAllOperationByClientId((int)c.getId());
		assertTrue(list.size() == 1);
		Operation operation = list.get(0);
		assertTrue(operation.getAmount() == amount);
		assertTrue(operation.getTypeOfOperation().equals(OperationTypeEnum.DEPOSIT));
		

	}
	
	
	
	
	@Test
	public void testWithdrawal() throws Exception {

		// deposit
		double amount = 100;
		// the client with username = 2 doesn't have any previous operations
		String username = "2";
		Client c = accountService.getClientByUsername(username);
		accountService.withdrawal(amount, username);
		//select operations
		List<Operation> list = accountService.getAllOperationByClientId((int)c.getId());
		assertTrue(list.size() == 1);
		Operation operation = list.get(0);
		assertTrue(operation.getAmount() == amount);
		assertTrue(operation.getTypeOfOperation().equals(OperationTypeEnum.WITHDRAWAL));

	}

	
	@Test
	public void testListOperation() throws Exception {
		
		accountService.deposit(5000,"1");
		accountService.withdrawal(500,"1");
		accountService.withdrawal(50,"1");
		List<Operation> testList = accountService.getAllOperationByClientId(1);
		assertEquals(3, testList.size());

	}

}
