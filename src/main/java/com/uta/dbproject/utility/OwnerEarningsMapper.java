package com.uta.dbproject.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class OwnerEarningsMapper implements RowMapper<Map<String, Object>>{

	@Override
	public Map<String, Object> mapRow(ResultSet rs, int arg1) throws SQLException {

		Map<String,Object> ownerEarningMap = new HashMap<String,Object>();
		ownerEarningMap.put("name", rs.getString("name"));
		ownerEarningMap.put("carType", rs.getString("carType"));
		ownerEarningMap.put("model", rs.getString("model"));
		ownerEarningMap.put("Earning", rs.getString("Earning"));
		return ownerEarningMap;
		
	}

}