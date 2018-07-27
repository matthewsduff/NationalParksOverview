package com.techelevator.npgeek.dao;

import java.util.List;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;

public interface ParkDAO {
	
	public List<Park> getAllHomePageParks();
	
	public List<Weather> getParkWeather();
	
	
}
