package com.uta.dbproject.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.uta.dbproject.constants.QueryConstants;
import com.uta.dbproject.model.Car;
import com.uta.dbproject.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	@Autowired
	private CarDaoImpl carDao;
	
	public int saveCustomerInfo(Customer customer) {

		int customerType;
		int result = 0;
		
		if(customer.getType().equals("individual")) {
			customerType = 1;
		}else {
			customerType = 2;
		}
		
		Map<String,String> customerMap = new HashMap<String,String>();
		customerMap.put("name", customer.getName());
		customerMap.put("address", customer.getAddress());
		customerMap.put("phone", customer.getPhoneNumber());
		customerMap.put("customerTypeId", Integer.toString(customerType));
		customerMap.put("vehicleId", customer.getVehicleId());
		customerMap.put("startDate", customer.getStartDate());
		customerMap.put("returnDate", customer.getReturnDate());
		customerMap.put("licenseNo", customer.getLicenseNo());
		
		try
		{
			result = namedJdbcTemplate.update(QueryConstants.SAVE_CUSTOMER_INFO, customerMap);
			
		}catch(Exception ex) {
			System.out.println("Exception:"+ex.getMessage());
		}
		return result;
	}


	@Override
	public List<String> getAllCustomers(String customerType) {
		
		int customerTypeId = 0;
		if(customerType.equalsIgnoreCase("Individual")) {
			customerTypeId = 1;
		}else
		{
			customerTypeId = 2;
		}
	
		Map<String,String> customerTypeMap = new HashMap<String,String>();
		customerTypeMap.put("customerTypeId",Integer.toString(customerTypeId));
		
		List<String> customerList = new ArrayList<String>();
		try {
			customerList = namedJdbcTemplate.queryForList(QueryConstants.GET_ALL_CUSTOMERS,customerTypeMap, String.class);
			
		}catch(Exception e) {
			System.out.println("Exception while fetching all customers :"+e.getMessage());
		}
		
		return customerList;
	}
}
