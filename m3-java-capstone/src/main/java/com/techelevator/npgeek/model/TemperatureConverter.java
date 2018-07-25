package com.techelevator.npgeek.model;

public class TemperatureConverter {
	
	private int celcius;
	private int fahrenheit;
	
	
	
	public int getCelcius() {
		return celcius;
	}
	public void setCelcius(int celcius) {
		this.celcius = celcius;
	}
	public int getFahrenheit() {
		return fahrenheit;
	}
	public void setFahrenheit(int fahrenheit) {
		this.fahrenheit = fahrenheit;
	}
	
	public int convertToCelcius(int fahrenheit) {
		
		double convertedTemp = (fahrenheit - 32) / 1.8;
		
		
		return (int)convertedTemp;
	}
	public int convertToFahrenheit(int celcius) {
		
		double convertedTemp = (celcius * 1.8) + 32;
		
		return (int)convertedTemp;
	}
	
}