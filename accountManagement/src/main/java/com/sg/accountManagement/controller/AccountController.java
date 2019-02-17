package com.sg.accountManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.accountManagement.entity.Operation;
import com.sg.accountManagement.service.IAccountService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*")
public class AccountController {
	@Autowired
	IAccountService accountService;

	/**
	 * get All Operation By Client Id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("getAllOperations/{id}")
	public ResponseEntity<List<Operation>> getAllOperationByClientId(
			@PathVariable int id) {

		List<Operation> list = null;
		try {
			list = accountService.getAllOperationByClientId(id);
		} catch (Exception e) {
			return new ResponseEntity<List<Operation>>(list,
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Operation>>(list, HttpStatus.OK);
	}

	/**
	 *  make a deposit in my account
	 *  
	 * @param operation
	 * @return
	 */
	@PostMapping("/deposit")
	public ResponseEntity<Boolean> deposit(@RequestBody Operation operation) {
		try {
			double amount = operation.getAmount();
			int idClient = operation.getIdClient();
			accountService.deposit(amount,idClient);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	
	/**
	 * make a withdrawal from my account
	 * 
	 * @param operation
	 * @return
	 */
	@PostMapping("/withdrawal")
	public ResponseEntity<Boolean> withdrawal(@RequestBody Operation operation) {
		try {
			double amount = operation.getAmount();
			int idClient = operation.getIdClient();
			try {
				accountService.withdrawal(amount,idClient);
			} catch (Exception e) {
				return new ResponseEntity<Boolean>(false, HttpStatus.EXPECTATION_FAILED);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
