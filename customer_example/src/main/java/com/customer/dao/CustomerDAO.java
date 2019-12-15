package com.customer.dao;

import java.util.List;

import com.customer.model.Customer;




public interface CustomerDAO {
	
	public void createCustomer(Customer customer);
	public List<Customer> getAllCustomer();
	public void deleteRow(int id);

}
