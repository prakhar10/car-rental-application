package com.uta.dbproject.dao;

import com.uta.dbproject.model.Rental;

public interface RentalDao {

	
	public int saveCarRental(Rental rental,String customerName);
}
