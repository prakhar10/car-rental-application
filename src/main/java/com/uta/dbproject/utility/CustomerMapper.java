package com.uta.dbproject.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper  implements RowMapper<Map<String,Object>>{

	@Override
	public Map<String,Object> mapRow(ResultSet rs, int arg1) throws SQLException {

		Map<String,Object> customerMap = new HashMap<String,Object>();
		customerMap.put("name", rs.getString("name"));
		customerMap.put("address", rs.getString("address"));
		customerMap.put("phone", rs.getString("phone"));
		customerMap.put("customerType", rs.getString("customerType"));
		
		return customerMap;
	}

}
