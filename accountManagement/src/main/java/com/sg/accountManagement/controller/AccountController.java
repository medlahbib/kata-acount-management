package com.sg.accountManagement.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.accountManagement.entity.Client;
import com.sg.accountManagement.entity.Operation;
import com.sg.accountManagement.service.IAccountService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*")
public class AccountController {
	@Autowired
	IAccountService accountService;

	
	/**
	 * get All Operation 
	 * 
	 * @return
	 */
	@GetMapping("getAllOperations")
	public ResponseEntity<List<Operation>> getAllOperations() {

		List<Operation> list =  accountService.getAllOperations();

		return new ResponseEntity<List<Operation>>(list, HttpStatus.OK);
	}
	
	/**
	 * get All Operation By Client Id
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("getAllOperationsByClientId")
	public ResponseEntity<List<Operation>> getAllOperationByClientId(HttpServletRequest  request) {

		Principal principal =  request.getUserPrincipal();
		Client c = accountService.getClientByUsername(principal.getName());
		List<Operation> list = null;
		try {
			list = accountService.getAllOperationByClientId((int)c.getId());
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
	public ResponseEntity<Boolean> deposit(@RequestBody Operation operation,HttpServletRequest request) {
		try {
			Principal principal =  request.getUserPrincipal();
			double amount = operation.getAmount();
			String username = principal.getName();
			accountService.deposit(amount,username);
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
	public ResponseEntity<Boolean> withdrawal(@RequestBody Operation operation,HttpServletRequest request) {
		try {
			Principal principal =  request.getUserPrincipal();
			double amount = operation.getAmount();
			String username = principal.getName();
			try {
				accountService.withdrawal(amount,username);
			} catch (Exception e) {
				return new ResponseEntity<Boolean>(false, HttpStatus.EXPECTATION_FAILED);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
