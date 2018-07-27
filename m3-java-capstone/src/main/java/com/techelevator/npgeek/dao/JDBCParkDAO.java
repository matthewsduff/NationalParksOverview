  package com.techelevator.npgeek.dao;

import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;


@Component
public class JDBCParkDAO implements ParkDAO {	

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void JDBCParkDao(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

	@Override
	public List<Park> getAllHomePageParks() {
		LinkedList<Park> parks = new LinkedList<>();
		String sqlStatement = "SELECT * \n" + "FROM park\n" + "ORDER BY parkname;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlStatement);

		while (results.next()) {
			parks.add(mapRowToPark(results));
		}

		return parks;
	}
	
	

	@Override
	public List<Weather> getParkWeather() {
		List<Weather> carlWeathers = new LinkedList<>();
		String sqlStatement = "SELECT * FROM weather\n" + 
				"JOIN park ON weather.parkcode = park.parkcode;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlStatement);
		while (results.next()) {
			carlWeathers.add(mapRowToWeather(results));
			
		}

		return carlWeathers;
	}
	 

	private Weather mapRowToWeather(SqlRowSet results) {

		Weather theWeather = new Weather();
		
		theWeather.setParkCode(results.getString("parkcode").toLowerCase());
		theWeather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		theWeather.setLow(results.getInt("low"));
		theWeather.setHigh(results.getInt("high"));
		theWeather.setForecast(results.getString("forecast"));
		
		theWeather.setEquipment(results.getString("forecast"));
		theWeather.setTemperatureWarnings(results.getInt("low"),results.getInt("high"));

		
		return theWeather;
	}
	
	private Park mapRowToPark(SqlRowSet results) {

		Park thePark = new Park();
		
		thePark.setParkCode(results.getString("parkcode").toLowerCase());
		thePark.setParkName(results.getString("parkname"));
		thePark.setState(results.getString("state"));
		thePark.setAcreage(results.getInt("acreage"));
		thePark.setElevationInFeet(results.getInt("elevationinfeet"));
		thePark.setMilesOfTrail(results.getFloat("milesoftrail"));
		thePark.setNumberOfCampsites(results.getInt("numberofcampsites"));
		thePark.setClimate(results.getString("climate"));
		thePark.setYearFounded(results.getInt("yearfounded"));
		thePark.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		thePark.setInspirationalQuote(results.getString("inspirationalquote"));
		thePark.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
		thePark.setParkDescription(results.getString("parkdescription"));
		thePark.setEntryFee(results.getInt("entryfee"));
		thePark.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));

		return thePark;
	}



}
