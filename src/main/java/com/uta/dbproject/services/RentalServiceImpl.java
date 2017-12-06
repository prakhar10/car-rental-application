package com.uta.dbproject.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.uta.dbproject.dao.RentalDao;
import com.uta.dbproject.model.Rental;

public class RentalServiceImpl implements RentalService {

	@Autowired
	private RentalDao carRentalDao;
	
	@Override
	public int saveCarRental(Rental rental,String customerName) {
		return carRentalDao.saveCarRental(rental, customerName);
	}

}
