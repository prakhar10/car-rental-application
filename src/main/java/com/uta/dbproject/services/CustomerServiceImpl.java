package com.uta.dbproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uta.dbproject.dao.CustomerDaoImpl;
import com.uta.dbproject.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDaoImpl customerDao;
	
	public int saveCustomerInfo(Customer customer) {
		int result = customerDao.saveCustomerInfo(customer);
		return result;
	}

	@Override
	public List<String> getAllCustomers(String customerType) {
		return customerDao.getAllCustomers(customerType);
	}

}
