package controllers;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Service.AirlineServiceInterface;
import entities.Flight;

@Controller
public class AirlineController {
	
	@Autowired
	AirlineServiceInterface airlineService;

	@RequestMapping(value="/viewFlight")
	public String getid(Model model){
		model.addAttribute(new Flight());
		return "findFlight";
		
	}

	@RequestMapping(value = "/viewFlight", method = RequestMethod.POST)
	public ModelAndView findFlights(@RequestParam int flight_id, Date departure_Date) {
		ModelAndView modelAndView = new ModelAndView();
		Flight flight = null;
		try {
			flight = airlineService.findFlight(flight_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flight == null) {
			modelAndView.addObject("message", "No Flight Found");
		}
		modelAndView.addObject("flightInformation", flight);
		return modelAndView;

	}

	@RequestMapping(value = "/updateFlight")
	public String updateFlight(Model model) {
		model.addAttribute(new Flight());
		return "updateFlights";
	}

	@RequestMapping(value = "/updateFlight", method = RequestMethod.POST)
	public ModelAndView updateFlight(@ModelAttribute  Flight flight, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.setViewName("updateflights");
			return modelAndView;
		}
		boolean flag = false;
		try {
			flag = airlineService.updateFlight(flight);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag == true) {
			modelAndView.setViewName("index");
		}
		return modelAndView;

	}	
	
}
