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
import com.uta.dbproject.model.Rental;
import com.uta.dbproject.utility.AllCarsMapper;
import com.uta.dbproject.utility.AmountMapper;
import com.uta.dbproject.utility.CarMapper;
import com.uta.dbproject.utility.CustVehicleMapper;

public class CarDaoImpl implements CarDao {	

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public int saveCarInfo(Car car) {
		
		int result = 0;
		int ownerId = checkOwnerPresent(car);
		int carType = getCarTypeId(car.getType());

		System.out.println("in save owner id :"+ownerId);
		System.out.println("in save car type id :"+carType);
		
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
			System.out.println("owner list size:"+ownerList.size());
			System.out.println("list content:"+ownerList.get(0));
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
		}catch (Exception e) {
			System.out.println("Exception while fetching available cars:"+e.getMessage());
			e.printStackTrace();
		}
		
		return carList;
	}

	@Override
	public int updateRentalRate(String carType,String dailyRate, String weeklyRate) {
		
		int result=0;
		Map<String,String> rentalMap = new HashMap<String,String>();
		rentalMap.put("carType", carType);
		rentalMap.put("dailyRate", dailyRate);
		rentalMap.put("weeklyRate", weeklyRate);
		System.out.println("daily:"+dailyRate+", weekly:"+weeklyRate);
		try {
			result = namedJdbcTemplate.update(QueryConstants.UPDATE_RENTAL_RATE, rentalMap);
		}catch(Exception ex) {
			System.out.println("Exception caught while updating rental rate:"+ex.getMessage());
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getAllCars() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> allCarsList = new ArrayList<Map<String,Object>>();
		
		try {
			allCarsList = namedJdbcTemplate.query(QueryConstants.GET_ALL_CAR_DETAILS, new HashMap<String,Object>(), new AllCarsMapper());
		}catch (Exception e) {
			System.out.println("Exception while fetching all cars:"+e.getMessage());
			e.printStackTrace();
		}
		
		return allCarsList;
		
	}

	@Override
	public String returnCar(Rental rental, String customerName) {

		Map<String, String> customerMap = new HashMap<String,String>();
		int result;
		customerMap.put("customerName", customerName);
		List<Map<String,Object>> vehicleIdList = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> amountDue = new ArrayList<Map<String,Object>>();

			try {
				vehicleIdList = namedJdbcTemplate.query(QueryConstants.GET_CUST_VEHICLE_ID, customerMap, new CustVehicleMapper());
				Map<String,String> vehicle = new HashMap<String,String>();
				vehicle.put("vehicleId", (String)vehicleIdList.get(0).get("vehicleId"));
				
				namedJdbcTemplate.update(QueryConstants.UPDATE_AVAILABLE_STATUS, vehicle);
				amountDue = namedJdbcTemplate.query(QueryConstants.GET_AMOUNT, vehicle, new AmountMapper());
			}catch (Exception e) {
				System.out.println("Exception while fetching all cars:"+e.getMessage());
			}
			
		
		return (String)amountDue.get(0).get("amountDue");
	}
}
