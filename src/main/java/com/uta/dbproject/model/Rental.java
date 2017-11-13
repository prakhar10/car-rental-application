package com.uta.dbproject.model;

public class Rental {

	private String startDate;
	private String endDate;
	private String carType;
	private String carModel;
	private String vehicleId;
	
	public Rental() {}
	
	public Rental(String startDate, String endDate, String carType, String carModel, String vehicleId) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.carType = carType;
		this.carModel = carModel;
		this.vehicleId = vehicleId;
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

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	@Override
	public String toString() {
		return "Rental [startDate=" + startDate + ", endDate=" + endDate + ", carType=" + carType + ", carModel="
				+ carModel + ", vehicleId=" + vehicleId + "]";
	}

}
