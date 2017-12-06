package com.uta.dbproject.services;

import com.uta.dbproject.model.Rental;

public interface RentalService {

	public int saveCarRental(Rental rental,String customerName);
}
