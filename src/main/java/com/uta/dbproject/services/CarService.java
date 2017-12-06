package com.uta.dbproject.services;

import java.util.List;
import java.util.Map;

import com.uta.dbproject.model.Car;
import com.uta.dbproject.model.Rental;

public interface CarService {
	
	public int saveCarInfoService(Car car);
	public List<Map<String,Object>> getAvailableCars(String carType);
	public int updateRentalRate(String carType,String dailyRate,String weeklyRate);
	public List<Map<String,Object>> getAllCars();
	public String returnCar(Rental rental,String customerName);
}
