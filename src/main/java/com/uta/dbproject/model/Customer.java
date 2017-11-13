package com.uta.dbproject.model;

public class Customer {

	
	private String name;
	private String address;
	private String age;
	private String licenseNo;
	private String idNumber;
	private String type;
	private String phoneNumber;
	
	public Customer() {}
	
	public Customer(String name, String address, String age, String licenseNo, String idNumber, String type,
			String phoneNumber) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
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

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", age=" + age + ", licenseNo=" + licenseNo
				+ ", idNumber=" + idNumber + ", type=" + type + ", phoneNumber=" + phoneNumber + "]";
	}

}
