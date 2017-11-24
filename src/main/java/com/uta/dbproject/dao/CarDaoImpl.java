package com.uta.dbproject.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.uta.dbproject.constants.Constants;
import com.uta.dbproject.constants.QueryConstants;
import com.uta.dbproject.model.Car;
import com.uta.dbproject.utility.CarMapper;

public class CarDaoImpl implements CarDao {	

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public int saveCarInfo(Car car) {
		
		int result = 0;
		int ownerId = checkOwnerPresent(car);
		int carType = getCarTypeId(car.getType());

		if(carType != 0 && ownerId != 0) {
			
			Map<String,String> carMap = new HashMap<String,String>();
			carMap.put("vehicleId", car.getVehicleId());
			carMap.put("ownerId", Integer.toString(ownerId));
			carMap.put("carTypeId", Integer.toString(carType));
			carMap.put("model", car.getModel());
			carMap.put("year", car.getYear());
			carMap.put("status", Constants.AVAILABLE);
			
			try {
				
				result = namedJdbcTemplate.update(QueryConstants.SAVE_CAR_INFO, carMap);
				
			}catch(Exception e) {
				System.out.println("Exception:"+e.getMessage());
			}
		}
		return result;
	}

	public int checkOwnerPresent(Car car) {
		
		int ownerId=0;
		List<Integer> ownerList = new ArrayList<Integer>();
		Map<String,String> ownerMap = new HashMap<String,String>();
		ownerMap.put("ownerName", car.getOwnerName());
		
		try {
			ownerList = namedJdbcTemplate.queryForList(QueryConstants.CHECK_OWNER_PRESENT, ownerMap,Integer.class);
			ownerId = ownerList.get(0);
		}catch (Exception e) {
			System.out.println("Exception while fetching old owner:"+e.getMessage());
			e.printStackTrace();
		}
		
		if(ownerId == 0) {
			int ownerTypeId = getOwnerType(car);
			Map<String,String> newOwnerMap = new HashMap<String,String>();
			newOwnerMap.put("name", car.getOwnerName());
			newOwnerMap.put("ownerTypeId", Integer.toString(ownerTypeId));
			
			try {
				
				namedJdbcTemplate.update(QueryConstants.SAVE_OWNER_INFO, newOwnerMap);
				ownerList = namedJdbcTemplate.queryForList(QueryConstants.CHECK_OWNER_PRESENT, ownerMap,Integer.class);
				ownerId = ownerList.get(0);
			}catch(Exception e) {
				System.out.println("Exception while new owner:"+e.getMessage());
			}
		}
		
		return ownerId;
	}
	
	
	public int getOwnerType(Car car) {
		int ownerType = 0;
		switch(car.getOwnedBy()) {
		case "Individual":
			ownerType = 1;
			break;
			
		case "Company":
			ownerType = 2;
			break;
			
		case "Bank":
			ownerType = 3;
			break;
		}
		
		return ownerType;
	}
	
	
	public int getCarTypeId(String carType) {
		int carTypeId = 0;
		switch(carType) {
		
		case "Compact":
			carTypeId = 1;
			break;
		
		case "Medium":
			carTypeId = 2;
			break;
			
		case "Large":
			carTypeId = 3;
			break;
			
		case "SUV":
			carTypeId = 4;
			break;
			
		case "Truck":
			carTypeId = 5;
			break;
			
		case "Van":
			carTypeId = 6;
			break;
		}
		
		return carTypeId;
	}

	@Override
	public List<Map<String,Object>> getAvailableCars(String carType) {
		
		List<Map<String,Object>> carList = new ArrayList<Map<String,Object>>();
		
		int carTypeId = getCarTypeId(carType);
		
		Map<String,String> carMap = new HashMap<String,String>();
		carMap.put("carTypeId", Integer.toString(carTypeId));
		carMap.put("status", Constants.AVAILABLE);
		try {
			carList = namedJdbcTemplate.query(QueryConstants.GET_AVAILABLE_CARS, carMap, new CarMapper());
			System.out.println("List size: "+carList.size());
			System.out.println("value:"+carList.get(0).get("vehicleId"));
		}catch (Exception e) {
			System.out.println("Exception while fetching available cars:"+e.getMessage());
			e.printStackTrace();
		}
		
		return carList;
	}
}
