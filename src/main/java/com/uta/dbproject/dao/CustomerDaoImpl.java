package com.uta.dbproject.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.uta.dbproject.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	
	public void saveCustomerInfo(Customer customer) {

		String query = "Insert into user values(:name)";
		Map<String,String> customerMap = new HashMap<String,String>();
		customerMap.put("name", customer.getName());
		
		try
		{
			namedJdbcTemplate.update(query, customerMap);
			
		}catch(Exception ex) {
			System.out.println("Exception:"+ex.getMessage());
		}
	}

}
