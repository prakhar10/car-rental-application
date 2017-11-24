package com.uta.dbproject.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class CarMapper implements RowMapper<Map<String,Object>>{

	@Override
	public Map<String,Object> mapRow(ResultSet rs, int arg1) throws SQLException {

		Map<String,Object> carMap = new HashMap<String,Object>();
		carMap.put("vehicleId", rs.getInt("vehicleId"));
		carMap.put("carType", rs.getString("carType"));
		carMap.put("model", rs.getString("model"));
		carMap.put("year", rs.getString("year"));
		carMap.put("dailyRate", rs.getInt("dailyRate"));
		carMap.put("weeklyRate", rs.getInt("weeklyRate"));
	
		return carMap;
	}

}
