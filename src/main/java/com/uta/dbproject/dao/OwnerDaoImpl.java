package com.uta.dbproject.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.uta.dbproject.constants.QueryConstants;
import com.uta.dbproject.model.Owner;
import com.uta.dbproject.utility.CustomerMapper;
import com.uta.dbproject.utility.OwnerEarningsMapper;
import com.uta.dbproject.utility.OwnerMapper;

public class OwnerDaoImpl implements OwnerDao {

	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Map<String, Object>> getAllOwners() {
	List<Map<String,Object>> allOwnersList = new ArrayList<Map<String,Object>>();
		
		try {
			allOwnersList = namedParameterJdbcTemplate.query(QueryConstants.GET_ALL_OWNERS, new HashMap<String,Object>(), new OwnerMapper());
		}catch (Exception e) {
			System.out.println("Exception while fetching all owners:"+e.getMessage());
			e.printStackTrace();
		}
		
		return allOwnersList;
	}

	@Override
	public List<Map<String, Object>> getEarnings() {

		List<Map<String,Object>> getOwnersEarning = new ArrayList<Map<String,Object>>();
		
		try {
			getOwnersEarning = namedParameterJdbcTemplate.query(QueryConstants.GET_OWNER_EARNING, new HashMap<String,Object>(), new OwnerEarningsMapper());
		}catch (Exception e) {
			System.out.println("Exception while fetching all owners:"+e.getMessage());
			e.printStackTrace();
		}
		return getOwnersEarning;
	}
}
