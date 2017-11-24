package com.uta.dbproject.model;

public class Customer {

	
	private String name;
	private String address;
	private String licenseNo;
	private int idNumber;
	private String type;
	private String phoneNumber;
	private String startDate;
	private String returnDate;
	private String vehicleId;
	
	public Customer() {}
	
	public Customer(String name, String address, String licenseNo, int idNumber, String type,
			String phoneNumber) {
		super();
		this.name = name;
		this.address = address;
		this.licenseNo = licenseNo;
		this.idNumber = idNumber;
		this.type = type;
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", licenseNo=" + licenseNo + ", idNumber=" + idNumber
				+ ", type=" + type + ", phoneNumber=" + phoneNumber + ", startDate=" + startDate + ", returnDate="
				+ returnDate + ", vehicleId=" + vehicleId + "]";
	}

}
