package com.uta.dbproject.services;

import java.util.List;
import java.util.Map;

import com.uta.dbproject.model.Customer;

public interface CustomerService {

	public int saveCustomerInfo(Customer customer);
	public List<String> getAllCustomers(String customerType);
	public List<Map<String,Object>> fetchAllCustomerList();
}
