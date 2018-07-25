package com.techelevator.npgeek.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.model.Park;

public class JDBCParkDAO implements ParkDAO {	

	private JdbcTemplate jdbcTemplate;

	public List<Park> getAllHomePageParks() {
		LinkedList<Park> parks = new LinkedList<>();
		String sqlStatement = "SELECT * \n" + "FROM park\n" + "ORDER BY parkname;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlStatement);

		while (results.next()) {
			parks.add(mapRowToPark(results));
		}

		return parks;
	}
	
	
	 

	private Park mapRowToPark(SqlRowSet results) {

		Park thePark = new Park();
		
		thePark.setParkCode(results.getString("parkcode"));
		thePark.setParkName(results.getString("parkname"));
		thePark.setState(results.getString("state"));
		thePark.setAcreage(results.getInt("acreage"));
		thePark.setElevationInFeet(results.getInt("elevationinfeet"));
		thePark.setMilesOfTrail(results.getFloat("milesoftrails"));
		thePark.setNumberOfCampsites(results.getInt("numberofcampsites"));
		thePark.setClimate(results.getString("climate"));
		thePark.setYearFounded(results.getInt("yearfounded"));
		thePark.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		thePark.setInspirationalQuote(results.getString("inspirationalquote"));
		thePark.setInspirationalQuoteSource(results.getString("inspirational"));
		thePark.setParkDescription(results.getString("parkdescription"));
		thePark.setEntryFee(results.getInt("entryfee"));
		thePark.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));

		return thePark;
	}

}
