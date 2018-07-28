package com.techelevator;

import static org.junit.Assert.assertNotEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.dao.JDBCParkDAO;
import com.techelevator.npgeek.dao.JDBCSurveyDAO;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Survey;

public class JDBCSurveyDAOIntegrationTest extends DAOIntegrationTest{
	
	private JDBCSurveyDAO surveyDAO;
	
	@Before
	public void setup() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		surveyDAO = new JDBCSurveyDAO(dataSource);
	}
	
	@Test
	public void getAllSurveysTEST() {
		List<Survey> surveys = new LinkedList<>();
		surveys = surveyDAO.getAllSurveys();
		Assert.assertNotNull("The NPS has been defunded. go vote next time.", surveys);
		Assert.assertEquals("method didn't display all parks.",13,surveys.size());
		
	}
	
	@Test
	public void getTopSurveyRestultsTEST() {
		
		List<Survey> surveys = new LinkedList<>();
		surveys = surveyDAO.getTopSurveys();
		Assert.assertNotNull("The NPS has been defunded. go vote next time.", surveys);
		Assert.assertEquals("method didn't display three parks.",3,surveys.size());
	}
	
	@Test
	public void getNewSurveyTEST() {	
		Survey theSurvey = newSurvey("MRDR", "ShadowFax@Gandalf.com", "PA", "extremely active");
		surveyDAO.addSurvey(theSurvey);
		
		List<Survey> surveys = new LinkedList<>();
		surveys = surveyDAO.getAllSurveys();
		
		Assert.assertNotNull("The NPS has been defunded. go vote next time.", surveys);
		Assert.assertEquals("method didn't display all parks.",14,surveys.size());
		
	}
	
	private Survey newSurvey(String parkCode, String emailAddress, String state, String activityLevel) {
		Survey theSurvey= new Survey();
		theSurvey.setParkCode(parkCode);
		theSurvey.setEmailAddress(emailAddress);
		theSurvey.setState(state);
		theSurvey.setActivityLevel(activityLevel);
		return theSurvey;
	}
	
}
