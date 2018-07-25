package com.techelevator.npgeek.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;





@Controller 
@SessionAttributes("nationalParksSession")
public class npgeekController {

	@RequestMapping(path={"/","/home"}, method=RequestMethod.GET)
	public String displayHome() {
		
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
	@RequestMapping(path="/favSummary", method=RequestMethod.GET)
	public String displaySummary() {
		
		return "favSummary";
	}
	@RequestMapping(path="/favSeason", method=RequestMethod.GET)
	public String displayfavSeason() {
		
		return "favSeason";
	}
}