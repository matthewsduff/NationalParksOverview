package com.techelevator;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.dao.JDBCParkDAO;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;

public class JDBCParkDAOIntegrationTest extends DAOIntegrationTest{

	private JDBCParkDAO parkDAO;

	
	@Before
	public void setup() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		parkDAO = new JDBCParkDAO(dataSource);
	}
	
	@Test
	public void getAllHomePageParksTEST() {
		List<Park> parks = new LinkedList<>();
		parks = parkDAO.getAllHomePageParks();
		Assert.assertNotNull("The NPS has been defunded. go vote next time.", parks);
		Assert.assertEquals("method didn't display all parks.",11,parks.size());
		
	}
	
	@Test
	public void getParkWeatherTEST() {
		List<Weather> carlWeathers = new LinkedList<>();
		carlWeathers = parkDAO.getParkWeather();
		Assert.assertNotNull("The NPS has been defunded. go vote next time.", carlWeathers);
		Assert.assertEquals("method didn't display all of Carl Weathers' Filmography.",55,carlWeathers.size());
	}
	
	
	
}
