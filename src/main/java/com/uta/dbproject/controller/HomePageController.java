package com.uta.dbproject.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.gson.Gson;
import com.uta.dbproject.model.Car;
import com.uta.dbproject.model.Customer;
import com.uta.dbproject.model.Rental;
import com.uta.dbproject.services.CustomerServiceImpl;

@Controller	
public class HomePageController {

	@Autowired
	CustomerServiceImpl customerService;
	
	@RequestMapping(value="/homepage.html",method = RequestMethod.GET)
	public ModelAndView showIndexPage() {
		System.out.println("Inside homepage controller");
		return new ModelAndView("homepage");
	}
	
	@RequestMapping(value="/newcustomer.html",method = RequestMethod.GET)
	public ModelAndView getNewCustomerPage() {
		System.out.println("inside new customer controller ");
		return new ModelAndView("newcustomer");
	}
	
	@RequestMapping(value="/savecustomer.html",method = RequestMethod.POST)
	public ModelAndView saveNewCustomer(@ModelAttribute("customer")Customer customer,ModelMap model) {
		System.out.println("inside save new customer controller"+customer.toString());
		model.addAttribute("submitMessage", "Customer saved successfully.");
		return new ModelAndView("newcustomer");
	}

	@RequestMapping(value="/newcar.html",method = RequestMethod.GET)
	public ModelAndView getNewCarPage() {
		System.out.println("inside new car controller ");
		return new ModelAndView("newcar");
	}
	
	@RequestMapping(value="/savecar.html",method = RequestMethod.POST)
	public ModelAndView saveNewCar(@ModelAttribute("car")Car car,ModelMap model) {
		System.out.println("inside save new car controller"+car.toString());
		model.addAttribute("submitMessage", "New car saved successfully.");
		return new ModelAndView("newcar");
	}
	
	@RequestMapping(value="/rentcar.html",method = RequestMethod.GET)
	public ModelAndView getRentCarPage() {
		System.out.println("inside rent a car controller");
		return new ModelAndView("rentcar");
	}
	
	//TODO
	@RequestMapping(value="/saverentcar.html",method = RequestMethod.POST)
	public ModelAndView saveRentCarDetails(@ModelAttribute("rentcar")Rental rental, ModelMap model) {
		System.out.println("save rent car controller");
		List<String> carList = new ArrayList<String>();
		carList.add("Ferrari");
		carList.add("Maruti");
		carList.add("Maserati");
		
		model.addAttribute("carList",carList);
		return new ModelAndView("rentcar");
	}
	
	@RequestMapping(value="/testAjax.html",method=RequestMethod.GET)
	public @ResponseBody List<String> testAjax(HttpServletRequest request) {
		System.out.println("in test ajax method");
		String sample = request.getParameter("dropdownvalue");
		List<String> carList = new ArrayList<String>();
		carList.add("Ferrari");
		carList.add("Maruti");
		carList.add("Maserati");
		Gson gson = new Gson();
		System.out.println("Stirng is:"+gson.toJson(carList));
		return carList;
	}
}
