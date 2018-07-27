package com.techelevator.npgeek.model;

public class Weather {
	
	private String parkCode;
	private int fiveDayForecastValue;
	private int low;
	private int high;
	private String imageName;
	private String forecast;
	
	public Weather() {
		
	}
	
	public String getEquipment(String forecast) {
		String result ="hi";
		
		if(this.forecast.equals("snow")) {
			result = "better pack some snow shoes";
		}
		if(this.forecast.equals("rain")) {
			result = "better pack rain gear and your waterproof shoes";
		}
		if(this.forecast.equals("thunderstorms")) {
			result = "better seek shelter and avoid hiking on exposed ridges";
		}
		if(this.forecast.equals("sunny")) {
			result = "better bring some high SPF sunscreen";
			
		}
		if(this.forecast.equals("partly cloudy")) {
			result = "better enjoy this partly coudly weather, while it lasts";
		}
		if(this.forecast.equals("ash")) {
			result = "better bring the armies of the Last Alliance of elves of men, hope, good/great pair of walking shoes, and second breaksfast";
			
		}
		
		return result;
	}
	
	public String getTemperatureWarnings (int low, int high) {
		String results = "hi";
		
		if(this.low < 20) {
			results = "be aware of exteme cold and frigid conditions";
		}
		if(this.low > 75) {
			results = "be aware of extreme heat, be sure to bring an extra gallon of water";
		}
		if(this.high - this.low > 20) {
			results = "be sure to wear breathable layers";
		}
		
		return results;
	}
	
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
	
	
}
