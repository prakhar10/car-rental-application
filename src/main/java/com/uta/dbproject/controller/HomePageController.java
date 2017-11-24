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

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;

@Controller
public class HomePageController {

	@Autowired
	CustomerServiceImpl customerService;
	
	@Autowired
	CarServiceImpl carService;

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
	
	@RequestMapping(value = "/saverentcar.html", method = RequestMethod.POST)
	public ModelAndView saveRentCarDetails(@ModelAttribute("rentcar") Rental rental, ModelMap mode) {
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
		// TODO
		// fetch data from database for cars which are avaible for rent
		List<Map<String,Object>> carList = carService.getAvailableCars(carType);

		JSON json = JSONSerializer.toJSON(carList);
		System.out.println("JSon : "+json.toString());
		
		return json.toString();
	}

	@RequestMapping(value="/updaterental.html",method = RequestMethod.GET)
	public ModelAndView updateRentalRates() {
		System.out.println("inside update rental controller");
		return new ModelAndView("updaterental");
	}

	@RequestMapping(value="/saveupdatedrental.html",method = RequestMethod.GET)
	public ModelAndView saveUpdatedRentalRates(@RequestParam("carType")String carType,@RequestParam("dailyRate")String dailyRate,@RequestParam("weeklyRate")String weeklyRate,ModelMap model) {
		//TODO
		//update the db for specific car type
		
		model.addAttribute("updatedMessage", "Rental updated Successfully");
		return new ModelAndView("updaterental");
	}
	

	@RequestMapping(value="/report.html",method = RequestMethod.GET)
	public ModelAndView getReport() {
		System.out.println("inside report controller");
		return new ModelAndView("report");
	}
	
	@RequestMapping(value="/uploaddata.html",method = RequestMethod.GET)
	public ModelAndView uploadData() {
		System.out.println("inside update rental controller");
		return new ModelAndView("uploaddata");
	}
	
	
}
