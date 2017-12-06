package com.uta.dbproject.dao;

import java.util.List;
import java.util.Map;

import com.uta.dbproject.model.Car;
import com.uta.dbproject.model.Rental;

public interface CarDao {

	public int saveCarInfo(Car car);
	public List<Map<String,Object>> getAvailableCars(String carType);
	public int updateRentalRate(String carType,String dailyRate,String weeklyRate);
	public List<Map<String,Object>> getAllCars();
	public String returnCar(Rental rental, String customerName);

}
