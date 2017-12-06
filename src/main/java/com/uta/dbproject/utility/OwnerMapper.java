package com.uta.dbproject.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class OwnerMapper implements RowMapper<Map<String,Object>>{

	@Override
	public Map<String, Object> mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Map<String,Object> ownerMap = new HashMap<String,Object>();
		ownerMap.put("name", rs.getString("name"));
		ownerMap.put("ownerType", rs.getString("ownerType"));
		
		return ownerMap;
	}
	

}
