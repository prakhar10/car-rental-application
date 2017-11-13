package com.uta.dbproject.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.uta.dbproject.dao.CustomerDaoImpl;
import com.uta.dbproject.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDaoImpl customerDao;
	
	public void saveCustomerInfo(String name) {
		System.out.println("start method saveCustomerInfo");
		Customer customer = new Customer();
		customer.setName(name);
		customerDao.saveCustomerInfo(customer);
		System.out.println("end method saveCustomerInfo");
		
	}

}
