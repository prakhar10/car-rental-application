package com.uta.dbproject.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.uta.dbproject.dao.CarDaoImpl;
import com.uta.dbproject.model.Car;
import com.uta.dbproject.model.Rental;			

public class CarServiceImpl implements CarService {

	@Autowired
	CarDaoImpl carDao;
	
	public int saveCarInfoService(Car car) {
		System.out.println("start saveCarInfoService");
		int result = carDao.saveCarInfo(car);
		System.out.println("end saveCarInfoService");
		return result;
	}

	@Override
	public List<Map<String,Object>> getAvailableCars(String carType) {
		return carDao.getAvailableCars(carType);
	}

	@Override
	public int updateRentalRate(String carType,String dailyRate,String weeklyRate) {
		return carDao.updateRentalRate(carType,dailyRate,weeklyRate);
	}

	@Override
	public List<Map<String, Object>> getAllCars() {
		// TODO Auto-generated method stub
		return carDao.getAllCars();
	}

	@Override
	public String returnCar(Rental rental, String customerName) {
		// TODO Auto-generated method stub
		return carDao.returnCar(rental, customerName);
	}

}
