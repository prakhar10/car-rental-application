package com.uta.dbproject.services;

import java.util.List;

import com.uta.dbproject.model.Customer;

public interface CustomerService {

	public int saveCustomerInfo(Customer customer);
	public List<String> getAllCustomers(String customerType);
}
