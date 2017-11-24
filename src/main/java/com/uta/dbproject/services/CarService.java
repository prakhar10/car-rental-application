package com.uta.dbproject.services;

import java.util.List;
import java.util.Map;

import com.uta.dbproject.model.Car;

public interface CarService {
	
	public int saveCarInfoService(Car car);
	public List<Map<String,Object>> getAvailableCars(String carType);
}
