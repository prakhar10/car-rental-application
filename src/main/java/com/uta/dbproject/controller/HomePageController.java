package com.uta.dbproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializer;
import com.uta.dbproject.model.Car;
import com.uta.dbproject.model.Customer;
import com.uta.dbproject.model.Rental;
import com.uta.dbproject.services.CarServiceImpl;
import com.uta.dbproject.services.CustomerServiceImpl;
import com.uta.dbproject.services.OwnerService;
import com.uta.dbproject.services.RentalService;
import com.uta.dbproject.utility.DataUploadUtility;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;

@Controller
public class HomePageController {

	@Autowired
	CustomerServiceImpl customerService;
	
	@Autowired
	DataUploadUtility dataUpload;
	
	@Autowired
	CarServiceImpl carService;
	
	@Autowired
	RentalService carRentalService;
	
	@Autowired
	OwnerService ownerService;
	
	private Rental rental1;


	@RequestMapping(value = "/homepage.html", method = RequestMethod.GET)
	public ModelAndView showIndexPage() {
		System.out.println("Inside homepage controller");
		return new ModelAndView("homepage");
	}

	@RequestMapping(value = "/newcustomer.html", method = RequestMethod.GET)
	public ModelAndView getNewCustomerPage() {
		System.out.println("inside new customer controller ");
		return new ModelAndView("newcustomer");
	}

	@RequestMapping(value = "/savecustomer.html", method = RequestMethod.POST)
	public ModelAndView saveNewCustomer(@ModelAttribute("customer") Customer customer, ModelMap model) {
		int result = customerService.saveCustomerInfo(customer);
		if(result == 1) {
			model.addAttribute("submitMessage", "Customer saved successfully.");
		}else {
			model.addAttribute("submitMessage", "Failed to save customer details.");
		}
		return new ModelAndView("newcustomer");
	}

	@RequestMapping(value = "/newcar.html", method = RequestMethod.GET)
	public ModelAndView getNewCarPage() {
		System.out.println("inside new car controller ");
		return new ModelAndView("newcar");
	}

	@RequestMapping(value = "/savecar.html", method = RequestMethod.POST)
	public ModelAndView saveNewCar(@ModelAttribute("car") Car car, ModelMap model) {
		System.out.println("inside save new car controller" + car.toString());
		int result = carService.saveCarInfoService(car);
		if(result == 1) {
			model.addAttribute("submitMessage", "New car saved successfully.");
		}else {
			model.addAttribute("submitMessage", "Failed to save car details.");

		}
		return new ModelAndView("newcar");
	}

	@RequestMapping(value = "/rentcar.html", method = RequestMethod.GET)
	public ModelAndView getRentCarPage(ModelMap model) {
		System.out.println("inside rent a car controller");
		return new ModelAndView("rentcar");
	}
	
	
	@RequestMapping(value = "/getCarDetails.html", method = RequestMethod.POST)
	public ModelAndView getCarDetails(HttpServletRequest request, ModelMap model) {
		
		System.out.println("in ajax call to get car details...");
		
		rental1 = new Rental();
		System.out.println("vals:"+request.getParameter("carModel"));
		
		rental1.setCarModel(request.getParameter("carModel"));
		rental1.setCarType(request.getParameter("carType"));
		rental1.setVehicleId(request.getParameter("vehicleId"));
		rental1.setDailyRate(request.getParameter("dailyRate"));
		rental1.setWeeklyRate(request.getParameter("weeklyRate"));

		return new ModelAndView("rentcar");
	}
	
	
	@RequestMapping(value = "/saverentcar.html", method = RequestMethod.POST)
	public ModelAndView saveRentCarDetails(@ModelAttribute("rentcar") Rental rental,@RequestParam("customerName")String customerName, ModelMap model) {
		
		rental.setCarModel(rental1.getCarModel());
		rental.setCarType(rental1.getCarType());
		rental.setVehicleId(rental1.getVehicleId());
		rental.setDailyRate(rental1.getDailyRate());
		rental.setWeeklyRate(rental1.getWeeklyRate());

		int result = carRentalService.saveCarRental(rental,customerName);
		
		System.out.println(rental.toString());
		return new ModelAndView("rentcar");
	}

	@RequestMapping(value = "/getcustomers.html", method = RequestMethod.GET)
	public @ResponseBody String getCustomers(HttpServletRequest request,ModelMap model) {
		System.out.println("inside get customers controller :"+request.getParameter("customerTypeId"));
		String customerType = request.getParameter("customerTypeId");
		List<String> customerList = customerService.getAllCustomers(customerType);
		JSON json = JSONSerializer.toJSON(customerList);
		return json.toString();
	}
	
	@RequestMapping(value = "/testAjax.html", method = RequestMethod.GET)
	public @ResponseBody String testAjax(HttpServletRequest request, ModelMap model) {
		String carType = request.getParameter("dropdownvalue");
		System.out.println("ajax call success:" + carType);
		List<Map<String,Object>> carList = carService.getAvailableCars(carType);
		JSON json = JSONSerializer.toJSON(carList);
		return json.toString();
	}

	@RequestMapping(value="/updaterental.html",method = RequestMethod.GET)
	public ModelAndView updateRentalRates() {
		System.out.println("inside update rental controller");
		return new ModelAndView("updaterental");
	}

	@RequestMapping(value="/saveupdatedrental.html",method = RequestMethod.POST)
	public ModelAndView saveUpdatedRentalRates(@RequestParam("carType")String carType,@RequestParam("dailyRate")String dailyRate,@RequestParam("weeklyRate")String weeklyRate,ModelMap model) {
		
		System.out.println("cartype:"+carType+",dailyrate:"+dailyRate+",weeklyrate:"+weeklyRate);
		//TODO
		//update the db for specific car type
		int result = carService.updateRentalRate(carType,dailyRate,weeklyRate);
		if(result == 1) {
			model.addAttribute("updatedMessage", "Rental Rate updated Successfully");
		}else {
			model.addAttribute("updatedMessage", "Failed to update Renatal Rate.");
		}
		return new ModelAndView("updaterental");
	}
	

	@RequestMapping(value="/report.html",method = RequestMethod.GET)
	public ModelAndView getReport(ModelMap model) {
		System.out.println("inside report controller");
		
		List<Map<String,Object>> earningList = ownerService.getEarnings();
		model.addAttribute("earningList",earningList);
		
		return new ModelAndView("report");
	}
	
	@RequestMapping(value="/uploaddata.html",method = RequestMethod.GET)
	public ModelAndView uploadData(ModelMap model) {
		System.out.println("inside update rental controller");
		String result = dataUpload.uploadData();
		model.addAttribute("success",result);
		return new ModelAndView("uploaddata");
	}
	
	@RequestMapping(value="/catalog.html", method = RequestMethod.GET)
	public ModelAndView showCatalog(ModelMap model) {
		
		List<Map<String,Object>> getAllCustomers = customerService.fetchAllCustomerList();
		model.addAttribute("customerList",getAllCustomers);
		
		List<Map<String,Object>> allCarsList = carService.getAllCars();
		model.addAttribute("carsList",allCarsList);
		
		List<Map<String,Object>> allOwnersList = ownerService.getAllOwners();
		model.addAttribute("ownerList",allOwnersList);
		
		return new ModelAndView("catalog");
	
	}
	
	@RequestMapping(value="/returncar.html", method = RequestMethod.GET)
	public ModelAndView returnCar() {
		return new ModelAndView("returncar");
	}
	
	
	@RequestMapping(value="/returncar1.html", method = RequestMethod.GET)
	public ModelAndView saveReturnCar(@ModelAttribute("returncar") Rental rental,@RequestParam("customerName")String customerName, ModelMap model) {
		
		String amount = carService.returnCar(rental, customerName);
		model.addAttribute("amount",amount);
		return new ModelAndView("returncar");
	}
	
	
	
}
