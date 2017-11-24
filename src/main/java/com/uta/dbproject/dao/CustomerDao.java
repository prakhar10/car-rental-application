package com.uta.dbproject.dao;

import java.util.List;

import com.uta.dbproject.model.Customer;

public interface CustomerDao {

	public int saveCustomerInfo(Customer customer);
	public List<String> getAllCustomers(String customerType);
}
