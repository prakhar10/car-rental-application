package com.uta.dbproject.constants;

public class QueryConstants {

	public static String SAVE_CUSTOMER_INFO="Insert into Customer values(null,:name,:address,:phone,:customerTypeId,:vehicleId,:startDate,:returnDate,:licenseNo)";
	public static String SAVE_CAR_INFO="Insert into Car values(:vehicleId,:ownerId,:carTypeId,:model,:year,:status)";
	public static String CHECK_OWNER_PRESENT="Select ownerTypeId from owner where name = :ownerName";
	public static String SAVE_OWNER_INFO ="Insert into owner values(null,:name,:ownerTypeId)";
	public static String GET_ALL_CUSTOMERS="Select name from Customer where customerTypeId = :customerTypeId";
	public static String GET_AVAILABLE_CARS = "Select * from Car c, Car_Type ct where c.status = :status and c.carTypeId = :carTypeId and c.carTypeId = ct.carTypeId";
	public static String UPDATE_RENTAL_RATE= "update car_type set dailyRate = :dailyRate,weeklyRate = :weeklyRate where carType = :carType";
	public static String ADD_CAR_RENTAL = "Insert into rental values(null,:vehicleId,STR_TO_DATE(:startDate,'%m/%d/%Y'),STR_TO_DATE(:returnDate,'%m/%d/%Y'),:amountDue,:noOfDays, :noOfWeeks)";
	public static String UPDATE_CAR_STATUS = "Update car set status = 'Rented' where vehicleId = :vehicleId";
	public static String UPDATE_CUSTOMER_RENTAL_DETAILS = "Update customer set startDate = STR_TO_DATE(:startDate,'%m/%d/%Y'),returnDate = STR_TO_DATE(:returnDate,'%m/%d/%Y'),vehicleId = :vehicleId where name = :name";
	public static String GET_ALL_CUSTOMER_LIST = "Select c.name,c.address,c.phone,ct.customerType from customer c , customer_type ct where c.customerTypeId= ct.customerTypeId";
	public static String GET_ALL_CAR_DETAILS = "Select c.model,c.year,ct.carType,c.vehicleId,ct.dailyRate,ct.weeklyRate,c.status from car c, car_type ct where c.carTypeId = ct.carTypeId";
	public static String GET_ALL_OWNERS = "Select o.name,ot.ownerType from owner o, owner_type ot where o.ownerTypeId=ot.ownerTypeId";
	public static String GET_OWNER_EARNING = "select o.name, ct.carType, c.model, SUM(r.amountDue) as Earning from car c, owner o, car_type ct, rental r where c.carTypeID = ct.carTypeId and c.vehicleId = r.vehicleId group by o.name, c.model, ct.carType";
	public static String GET_CUST_VEHICLE_ID = "Select vehicleId from customer where name= :customerName";
	public static String UPDATE_AVAILABLE_STATUS = "Update car set status = 'Available' where vehicleId = :vehicleId";
	public static String GET_AMOUNT= "Select amountDue from rental where vehicleId = :vehicleId";
	
}
