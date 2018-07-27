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
import com.techelevator.npgeek.dao.SurveyDAO;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Survey;





@Controller 
@SessionAttributes("nationalParksSession")
public class npgeekController {
	
	@Autowired
	private ParkDAO parkDAO;
	@Autowired
	private SurveyDAO surveyDAO;

	@RequestMapping(path={"/","/home"}, method=RequestMethod.GET)
	public String displayHome(HttpServletRequest request) {
		
		
		List<Park> park = parkDAO.getAllHomePageParks();
		request.setAttribute("park", park);
		
		return "home";
		
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String displaySurvey() {
		
		return "survey";
	}
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String displaySurvey(@RequestParam String parkcode,
								@RequestParam String emailaddress,
								@RequestParam String state,
								@RequestParam String activitylevel
												) {
		
		Survey newSurvey = new Survey();
		newSurvey.setParkCode(parkcode);
		newSurvey.setEmailAddress(emailaddress);
		newSurvey.setState(state);
		newSurvey.setActivityLevel(activitylevel);
		
		surveyDAO.addSurvey(newSurvey);
		
		return "redirect:/surveyResults";
	}
	@RequestMapping(path="/surveyResults", method=RequestMethod.GET)
	public String displayfavSeason() {
		
		return "surveyResults";
	}
}
