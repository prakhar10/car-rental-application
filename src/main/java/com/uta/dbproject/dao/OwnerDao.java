package com.uta.dbproject.dao;

import java.util.List;
import java.util.Map;

public interface OwnerDao {

	public List<Map<String, Object>> getAllOwners();
	public List<Map<String,Object>> getEarnings();
}
