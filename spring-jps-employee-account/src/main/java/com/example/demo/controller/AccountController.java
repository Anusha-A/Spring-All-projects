package com.example.demo.controller;

import java.awt.print.Pageable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.repository.AccountRepsoitory;
import com.example.demo.repository.CustomerRepository;

public class AccountController {
	@Autowired
	private AccountRepsoitory accountRepository;

	@Autowired
	private CustomerRepository customerRepository;
	/*@GetMapping("/customers/{customerId}/accounts")
	public Page<Account> getAllAccountsByCustomerId(@PathVariable(value = "customerId") Integer customerId, Pageable pageable) {
		return accountRepository.findByCustomerId(customerId, pageable);
	}*/
	


	@PostMapping("/customers/{customerId}/accounts")
	public Account createAccount(@PathVariable(value = "customerId") Integer customerId, @Valid @RequestBody Account account) {
		return customerRepository.findById(customerId).map(customer -> {
			account.setCustomer(customer);
			return accountRepository.save(account);
		}).orElseThrow(() -> new ResourceNotFoundException("CustomerId " + customerId + " not found"));
	}

	@PutMapping("/customers/{customerId}/accounts/{accountId}")
	public Account updateAccount(@PathVariable(value = "postId") Integer customerId,
			@PathVariable(value = "accountId") Long accountId, @Valid @RequestBody Account accountRequest) {
		if (!customerRepository.existsById(customerId)) {
			throw new ResourceNotFoundException("CustomerId " + customerId + " not found");
		}

		return accountRepository.findById(accountId).map(account -> {
			account.setAccountNumber(accountRequest.getAccountNumber());
			account.setAccoutType(accountRequest.getAccoutType());
			account.setActive(accountRequest.isActive());
			return accountRepository.save(account);
		}).orElseThrow(() -> new ResourceNotFoundException("accountId " + accountId + "not found"));
	}

	/*@DeleteMapping("/customers/{customerId}/accounts/{accountId}")
	public ResponseEntity<?> deleteAccount(@PathVariable(value = "customerId") Integer customerId,
			@PathVariable(value = "accountId") Long accountId) {
		return accountRepository.findByIdAndCustomerId(accountId, customerId).map(account -> {
			accountRepository.delete(account);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException(
				"Comment not found with id " + accountId + " and customerId " + customerId));
	}*/

}
