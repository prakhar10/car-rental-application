package com.uta.dbproject.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.management.Query;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Weeks;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.aop.aspectj.AspectJAdviceParameterNameDiscoverer.AmbiguousBindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.uta.dbproject.constants.QueryConstants;
import com.uta.dbproject.model.Rental;

public class RentalDaoImpl implements RentalDao {

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcParameterTemplate;
	
	 
	
	@Override
	public int saveCarRental(Rental rental,String customerName) {
		
		DateTimeFormatter dtf =  DateTimeFormat.forPattern("mm/dd/yyyy");
		DateTime dt = new DateTime(dtf.parseDateTime(rental.getStartDate()));

		int  days, weeks,amountDue, result=0;
		String returnDate;
		if(rental.getRentalType().equals("Daily")) {
			
			days = Integer.parseInt(rental.getNoOfDays());
			weeks = 0;
			amountDue = Integer.parseInt(rental.getNoOfDays()) * Integer.parseInt(rental.getDailyRate());
			returnDate =  dtf.print(dt.plusDays(Integer.parseInt(rental.getNoOfDays())));
		}else {
			weeks = Integer.parseInt(rental.getNoOfWeeks());
			days = 0;
			amountDue = Integer.parseInt(rental.getNoOfWeeks()) * Integer.parseInt(rental.getWeeklyRate());
			returnDate =  dtf.print(dt.plusWeeks(Integer.parseInt(rental.getNoOfDays())));
		}
		
		
		Map<String,String> rentalMap = new HashMap<String,String>();
		rentalMap.put("vehicleId", rental.getVehicleId());
		rentalMap.put("startDate", rental.getStartDate());
		rentalMap.put("returnDate", returnDate);
		rentalMap.put("amountDue", Integer.toString(amountDue));
		rentalMap.put("noOfDays", Integer.toString(days));
		rentalMap.put("noOfWeeks", Integer.toString(weeks));
		
		
		Map<String,String> customerUpdateMap = new HashMap<String,String>();
		customerUpdateMap.put("name", customerName);
		customerUpdateMap.put("startDate", rental.getStartDate());
		customerUpdateMap.put("returnDate", returnDate);
		customerUpdateMap.put("vehicleId", rental.getVehicleId());
		
		try {
			
			result = namedJdbcParameterTemplate.update(QueryConstants.ADD_CAR_RENTAL, rentalMap);
			namedJdbcParameterTemplate.update(QueryConstants.UPDATE_CAR_STATUS, rentalMap);
			namedJdbcParameterTemplate.update(QueryConstants.UPDATE_CUSTOMER_RENTAL_DETAILS, customerUpdateMap);
			
		}catch(Exception ex) {
			System.out.println("Exception while updating car status:"+ex.getMessage());
			
		}
		System.out.println("Car update status:"+result);
		return result;
	}
	
	

}
