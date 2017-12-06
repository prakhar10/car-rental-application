package com.uta.dbproject.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.uta.dbproject.dao.OwnerDao;

public class OwnerServiceImpl implements OwnerService {

	
	@Autowired
	OwnerDao ownerDao;
	
	@Override
	public List<Map<String, Object>> getAllOwners() {
		// TODO Auto-generated method stub
		return ownerDao.getAllOwners();
	}

	@Override
	public List<Map<String, Object>> getEarnings() {
		// TODO Auto-generated method stub
		return ownerDao.getEarnings();
	}

}
