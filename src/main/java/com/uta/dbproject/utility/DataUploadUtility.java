package com.uta.dbproject.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.uta.dbproject.model.Car;
import com.uta.dbproject.model.Customer;
import com.uta.dbproject.model.Owner;

public class DataUploadUtility {

	private static String mySQLDriver = "com.mysql.jdbc.Driver";
	
	public String uploadData(){

		String line = "";
		String csvSplitter = ",";
		
		Connection connection = getMySqlConnection();
		if(connection != null) {
			deleteAllData(connection);
			insertOwnerData(line, csvSplitter, connection);
			insertCarData(line, csvSplitter, connection);
			insertCustomerData(line, csvSplitter, connection);
			
		}
		
		return "Data Uploaded Successfully";
	}

	/**
	 * Return list of Owner
	 * 
	 * @param line
	 * @param csvSplitter
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public List<Owner> getOwnerList(String line, String csvSplitter)
			throws NumberFormatException, IOException {


		BufferedReader bufReader = null;
		List<Owner> ownerList = new ArrayList<Owner>();
		try {
			
			Resource resource = new ClassPathResource("Owner.csv");
			File file = resource.getFile();
			bufReader = new BufferedReader(new FileReader(file));
			
			while ((line = bufReader.readLine()) != null) {
				Owner owner = new Owner();
				String[] splitString = line.split(csvSplitter);
				owner.setOwnerName(splitString[0]);
				owner.setOwnerTypeId(Integer.parseInt(splitString[1]));
				ownerList.add(owner);
			}

			System.out.println("list size:"+ownerList.size());
		} catch (FileNotFoundException e) {
			System.out.println("Exception message: "+e.getMessage());
		}

		return ownerList;
	}

	/**
	 * This method inserts country data into db
	 * @param line
	 * @param csvSplitter
	 * @param connection
	 */
	public void insertOwnerData(String line, String csvSplitter, Connection connection) {

		String query = "Insert into Owner(ownerId,name,ownerTypeId) values(null,?,?)";
		try {

			List<Owner> list = getOwnerList(line, csvSplitter);
			PreparedStatement statement = connection.prepareStatement(query);

			for (Owner owner : list) {
				statement.setString(1, owner.getOwnerName());
				statement.setInt(2, owner.getOwnerTypeId());
				statement.addBatch();
			}

			int[] ownerRecords = statement.executeBatch();
			System.out.println("Owner data inserted successfully. Number of records:" + ownerRecords.length);
			statement.close();
			
		} catch (Exception e) {
			System.out.println("Exception message: "+e.getMessage());
		}

	}

	/**
	 * This method returns list of player objects
	 * @param line
	 * @param csvSplitter
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public  List<Car> getCarList(String line, String csvSplitter)
			throws NumberFormatException, IOException {

		BufferedReader bufReader = null;
		List<Car> carList = new ArrayList<Car>();
		try {
			Resource resource = new ClassPathResource("Car.csv");
			File file = resource.getFile();
			bufReader = new BufferedReader(new FileReader(file));
			
			while ((line = bufReader.readLine()) != null) {
				Car car = new Car();
				String[] splitString = line.split(csvSplitter);
				car.setVehicleId(splitString[0]);
				car.setOwnedBy(splitString[1]);
				car.setType(splitString[2]);
				car.setModel(splitString[3]);
				car.setYear(splitString[4]);
				car.setStatus(splitString[5]);
				carList.add(car);

			}

		} catch (FileNotFoundException e) {
			System.out.println("Exception message: "+e.getMessage());
		}

		return carList;
	}

	/**
	 * This method inserts player data into db
	 * @param line
	 * @param csvSplitter
	 * @param connection
	 */
	public  void insertCarData(String line, String csvSplitter, Connection connection) {

		String query = "Insert into Car(vehicleId,ownerId,carTypeId,model,year,status) values(?,?,?,?,?,?)";
		try {

			List<Car> list = getCarList(line, csvSplitter);
			PreparedStatement statement = connection.prepareStatement(query);

			for (Car car : list) {
				statement.setString(1, car.getVehicleId());
				statement.setString(2, car.getOwnedBy());
				statement.setString(3, car.getType());
				statement.setString(4, car.getModel());
				statement.setString(5, car.getYear());
				statement.setString(6, car.getStatus());
				statement.addBatch();
			}

			int[] carRecords = statement.executeBatch();
			System.out.println("Car data inserted successfully. Number of records:" + carRecords.length);
			statement.close();
			
		} catch (Exception e) {
			System.out.println("Exception message: "+e.getMessage());
		}

	}

	/**
	 * This method returns list of match result objects
	 * @param line
	 * @param csvSplitter
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public  List<Customer> getCustomerList(String line, String csvSplitter)
			throws NumberFormatException, IOException {

		BufferedReader bufReader = null;
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			Resource resource = new ClassPathResource("Customer.csv");
			File file = resource.getFile();
			bufReader = new BufferedReader(new FileReader(file));
			
			while ((line = bufReader.readLine()) != null) {
				
				System.out.println("line:"+line);
				Customer customer = new Customer();
				String[] splitString = line.split(csvSplitter);
				customer.setName(splitString[0]);
				customer.setAddress(splitString[1]);
				customer.setPhoneNumber(splitString[2]);
				customer.setType(splitString[3]);
				customer.setLicenseNo(splitString[7]);

				customerList.add(customer);

			}

		} catch (FileNotFoundException e) {
			System.out.println("Exception message: "+e.getMessage());
		}

		return customerList;
	}

	/**
	 * This method inserts match results data into db
	 * @param line
	 * @param csvSplitter
	 * @param connection
	 */
	public  void insertCustomerData(String line, String csvSplitter, Connection connection) {

		String query = "Insert into Customer(customerId,name,address,phone,customerTypeId,vehicleId,startDate,returnDate,licenseNo) values(null,?,?,?,?,null,null,null,?)";
		try {

			List<Customer> list = getCustomerList(line, csvSplitter);
			PreparedStatement statement = connection.prepareStatement(query);

			for (Customer customer : list) {
				statement.setString(1, customer.getName());
				statement.setString(2, customer.getAddress());
				statement.setString(3, customer.getPhoneNumber());
				statement.setInt(4, Integer.parseInt(customer.getType()));
				if(customer.getType().equalsIgnoreCase("1")) {
					statement.setString(5, customer.getLicenseNo());
				}else {
					statement.setString(5,null);

				}

				statement.addBatch();
			}

			int[] customerRecords = statement.executeBatch();
			System.out.println("Customer data inserted successfully. Number of records:" + customerRecords.length);
			statement.close();
			
		} catch (Exception e) {
			System.out.println("Exception message: "+e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * Get connection object
	 * @return Connection
	 */
	public  Connection getMySqlConnection() {

		System.out.println("Testing jdbc connectivity.");

		try {
			Class.forName(mySQLDriver);
		} catch (Exception ex) {
			System.out.println("Driver not found exception."+ex.getMessage());
			return null;
		}

		System.out.println("Driver found.");

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/carrental", "root", "root");
		} catch (Exception ex) {
			System.out.println("Could not connect to MySQL/Oracle."+ex.getMessage());
			return null;
		}
		System.out.println("Connected to DB!");

		return connection;
	}
	
	/**
	 * Delete all records from all tables.
	 * @param connection
	 */
	public  void deleteAllData(Connection connection) {
		
		String deleteOwner = "Delete from Owner";
		String deleteCar = "Delete from Car";
		String deleteCustomer = "Delete from Customer";
		
		System.out.println("Clearing all table data before insertion.");
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.addBatch(deleteCar);
			statement.addBatch(deleteOwner);
			statement.addBatch(deleteCustomer);
			
			int[] deletedRecords = statement.executeBatch();
			
			System.out.println("All records have been deleted. Table Count :"+deletedRecords.length);
			statement.close();
			
		} catch (Exception e) {
			System.out.println("Exception msg :"+e.getMessage());
		}
		
	}

	
}
