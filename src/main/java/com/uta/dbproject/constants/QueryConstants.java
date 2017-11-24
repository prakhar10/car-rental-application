package com.uta.dbproject.constants;

public class QueryConstants {

	public static String SAVE_CUSTOMER_INFO="Insert into Customer values(null,:name,:address,:phone,:customerTypeId,:vehicleId,:startDate,:returnDate,:licenseNo)";
	public static String SAVE_CAR_INFO="Insert into Car values(:vehicleId,:ownerId,:carTypeId,:model,:year,:status)";
	public static String CHECK_OWNER_PRESENT="Select ownerId from owner where name = :ownerName";
	public static String SAVE_OWNER_INFO ="Insert into owner values(null,:name,:ownerTypeId)";
	public static String GET_ALL_CUSTOMERS="Select name from Customer where customerTypeId = :customerTypeId";
	public static String GET_AVAILABLE_CARS = "Select * from Car c, Car_Type ct where c.status = :status and c.carTypeId = :carTypeId and c.carTypeId = ct.carTypeId";
}
