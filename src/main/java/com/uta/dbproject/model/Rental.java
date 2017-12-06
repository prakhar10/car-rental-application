package com.uta.dbproject.model;

public class Rental {

	private String custType;
	private String customerName;
	private String startDate;
	private String returnDate;
	private String carType;
	private String carModel;
	private String vehicleId;
	private String rentalType;
	private String dailyRate;
	private String weeklyRate;
	private String noOfDays;
	private String noOfWeeks;


	public Rental() {}
	

	public Rental(String custType, String customerName, String startDate, String returnDate, String carType,
			String carModel, String vehicleId, String rentalType, String dailyRate, String weeklyRate, String noOfDays, String noOfWeeks) {
		super();
		this.custType = custType;
		this.customerName = customerName;
		this.startDate = startDate;
		this.returnDate = returnDate;
		this.carType = carType;
		this.carModel = carModel;
		this.vehicleId = vehicleId;
		this.rentalType = rentalType;
		this.dailyRate = dailyRate;
		this.weeklyRate = weeklyRate;
		this.noOfDays = noOfDays;
		this.noOfWeeks = noOfWeeks;
	}


	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	
	public String getRentalType() {
		return rentalType;
	}

	public void setRentalType(String rentalType) {
		this.rentalType = rentalType;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getWeeklyRate() {
		return weeklyRate;
	}


	public void setWeeklyRate(String weeklyRate) {
		this.weeklyRate = weeklyRate;
	}


	
	public String getDailyRate() {
		return dailyRate;
	}


	public void setDailyRate(String dailyRate) {
		this.dailyRate = dailyRate;
	}

	public String getNoOfDays() {
		return noOfDays;
	}


	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}


	public String getNoOfWeeks() {
		return noOfWeeks;
	}


	public void setNoOfWeeks(String noOfWeeks) {
		this.noOfWeeks = noOfWeeks;
	}


	@Override
	public String toString() {
		return "Rental [custType=" + custType + ", customerName=" + customerName + ", startDate=" + startDate
				+ ", returnDate=" + returnDate + ", carType=" + carType + ", carModel=" + carModel + ", vehicleId="
				+ vehicleId + ", rentalType=" + rentalType + ", dailyRate=" + dailyRate + ", weeklyRate=" + weeklyRate
				+ ", noOfDays=" + noOfDays + ", noOfWeeks=" + noOfWeeks + "]";
	}
	

}
