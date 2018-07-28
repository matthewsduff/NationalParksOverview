package com.techelevator.npgeek.dao;

import java.util.List;


import com.techelevator.npgeek.model.Survey;

public interface SurveyDAO {
	public List<Survey> getAllSurveys();
	public void addSurvey(Survey newSurvey);
	public List<Survey> getTopSurveys();
}
