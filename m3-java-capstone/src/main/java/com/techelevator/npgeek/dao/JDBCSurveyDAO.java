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
		String sqlInsertNewSurvey = "INSERT INTO survey_result(parkcode,emailaddress,state,activitylevel) "
				+ "VALUES (?,?,?,?);";
		jdbcTemplate.update(sqlInsertNewSurvey, newSurvey.getParkCode(), newSurvey.getEmailAddress(), newSurvey.getState(), newSurvey.getActivityLevel());
	}
	
	
	
	private Integer getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('surveyid')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Integer id = null;
		if(results.next()) {
			id = results.getInt(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next forum post id from sequence");
		}
		return id;
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
