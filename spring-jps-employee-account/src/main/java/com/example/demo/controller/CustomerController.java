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

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
/*
	@GetMapping("/customers")
	public Page<Customer> getAllCustomers(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}*/

	@PostMapping("/customers")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@PutMapping("/customers/{customersId}")
	public Customer updateCustomer(@PathVariable Integer customerId, @Valid @RequestBody Customer customerRequest) {
		return customerRepository.findById(customerId).map(customer -> {
			customer.setFirstName(customerRequest.getFirstName());
			customer.setLastName(customerRequest.getLastName());
			customer.setEmail(customerRequest.getEmail());
			return customerRepository.save(customer);
		}).orElseThrow(() -> new ResourceNotFoundException("CustomerId " + customerId + " not found"));
	}

	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<?> deletePost(@PathVariable Integer customerId) {
		return customerRepository.findById(customerId).map(customer -> {
			customerRepository.delete(customer);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("CustomerId " + customerId + " not found"));
	}

}
