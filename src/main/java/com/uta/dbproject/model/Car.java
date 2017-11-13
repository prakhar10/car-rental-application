package com.uta.dbproject.model;

public class Car {

	private String vehicleId;
	private String model;
	private String year;
	private String ownedBy;
	private String type;
	private String dailyRate;
	private String weeklyRate;
	
	public Car() {}
	
	public Car(String vehicleId, String model, String year, String ownedBy, String type, String dailyRate,
			String weeklyRate) {
		super();
		this.vehicleId = vehicleId;
		this.model = model;
		this.year = year;
		this.ownedBy = ownedBy;
		this.type = type;
		this.dailyRate = dailyRate;
		this.weeklyRate = weeklyRate;
	}
	
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getOwnedBy() {
		return ownedBy;
	}
	public void setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDailyRate() {
		return dailyRate;
	}
	public void setDailyRate(String dailyRate) {
		this.dailyRate = dailyRate;
	}
	public String getWeeklyRate() {
		return weeklyRate;
	}
	public void setWeeklyRate(String weeklyRate) {
		this.weeklyRate = weeklyRate;
	}
	@Override
	public String toString() {
		return "Car [vehicleId=" + vehicleId + ", model=" + model + ", year=" + year + ", ownedBy=" + ownedBy
				+ ", type=" + type + ", dailyRate=" + dailyRate + ", weeklyRate=" + weeklyRate + "]";
	}
	
}
