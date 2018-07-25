package com.techelevator.npgeek.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.dao.JDBCParkDAO;
import com.techelevator.npgeek.dao.ParkDAO;
import com.techelevator.npgeek.model.Park;





@Controller 
@SessionAttributes("nationalParksSession")
public class npgeekController {
	
	@Autowired
	private ParkDAO parkDAO;

	@RequestMapping(path={"/","/home"}, method=RequestMethod.GET)
	public String displayHome(HttpServletRequest request) {
		
		
		List<Park> park = parkDAO.getAllHomePageParks();
		request.setAttribute("park", park);
		
		return "home";
		
	}
	
	@RequestMapping(path="/home", method=RequestMethod.POST)
	public String processParkSelection(@RequestParam String color,
												 ModelMap model) {
		
		// park selection stuff goes here
		return "redirect:/parkDetail";
	}
	
	
	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String displayParkDetail() {
		
		return "parkDetail";
	}
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String displaySurvey() {
		
		return "survey";
	}
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String displaySurvey(@RequestParam String color,
												ModelMap model) {
		
		return "redirect:/surveyResults";
	}
	@RequestMapping(path="/surveyResults", method=RequestMethod.GET)
	public String displayfavSeason() {
		
		return "surveyResults";
	}
}
