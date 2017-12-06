package com.uta.dbproject.services;

import java.util.List;
import java.util.Map;

public interface OwnerService {

	
	public List<Map<String, Object>> getAllOwners();
	public List<Map<String,Object>> getEarnings();
}
