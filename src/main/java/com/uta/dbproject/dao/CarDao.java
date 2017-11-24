package com.uta.dbproject.dao;

import java.util.List;
import java.util.Map;

import com.uta.dbproject.model.Car;

public interface CarDao {

	public int saveCarInfo(Car car);
	public List<Map<String,Object>> getAvailableCars(String carType);
}
