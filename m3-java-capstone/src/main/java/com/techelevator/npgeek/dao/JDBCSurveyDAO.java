package com.techelevator.npgeek.dao;

import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Survey;

@Component
public class JDBCSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCSurveyDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<Survey> getAllSurveys() {
		LinkedList<Survey> survey = new LinkedList<>();
		String sqlStatement = "SELECT parkname FROM park JOIN survey_result sr ON park.parkcode = sr.parkcode GROUP BY park.parkname ORDER BY park.parkname limit 3;";

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
		jdbcTemplate.update(sqlInsertNewSurvey, newSurvey.getParkCode(), newSurvey.getEmailAddress(),
				newSurvey.getState(), newSurvey.getActivityLevel());
	}

	private Survey mapRowToSurvey(SqlRowSet results) {

		Survey theSurvey = new Survey();
		theSurvey.setSurveyId(results.getInt("surveyid"));
		theSurvey.setParkCode(results.getString("parkcode").toLowerCase());
		theSurvey.setEmailAddress(results.getString("emailaddress"));
		theSurvey.setState(results.getString("state"));
		theSurvey.setActivityLevel(results.getString("activitylevel"));

		return theSurvey;
	}

}
