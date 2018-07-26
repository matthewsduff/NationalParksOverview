package com.techelevator.npgeek.dao;

import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Survey;

public class JDBCSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void JDBCParkDao(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }
	
	@Override
	public List<Survey> getAllSurveys() {
		LinkedList<Survey> survey = new LinkedList<>();
		String sqlStatement = "SELECT * \n" + "FROM survey_result\n" + "ORDER BY parkname;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlStatement);
		
		while (results.next()) {
			survey.add(mapRowToSurvey(results));
		}
		return survey;
	}
	
	@Override
	public void addSurvey(Survey newSurvey) {
		String sqlInsertNewPark = "INSERT INTO survey_result(name,location,establish_date,area,visitors,description) "
				+ "VALUES (?,?,?,?,?,?) RETURNING park_id;";
		// newPark.setPark_id(getNextParkId());
		Long id = jdbcParkTemplate.queryForObject(sqlInsertNewPark, Long.class, newPark.getPark_name(),
				newPark.getLocation(), newPark.getEstablished_date(), newPark.getArea(), newPark.getAnnual_visitors(),
				newPark.getDescription());
		newPark.setPark_id(id);
		/*
		 * jdbcParkTemplate.update(sqlInsertNewPark, newPark.getPark_id(),
		 * newPark.getPark_name(), newPark.getLocation(), newPark.getEstablished_date(),
		 * newPark.getArea(), newPark.getAnnual_visitors(), newPark.getDescription());
		 */

	}
	
	private Survey mapRowToSurvey(SqlRowSet results) {

		Survey theSurvey = new Survey();
		
		theSurvey.setParkCode(results.getString("parkcode").toLowerCase());
		theSurvey.setEmailAddress(results.getString("emailaddress"));
		theSurvey.setState(results.getString("state"));
		theSurvey.setActivityLevel(results.getString("activitylevel"));
		

		return theSurvey;
	}

}
