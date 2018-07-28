package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {
	
	private static WebDriver webDriver;
	
	
	@BeforeClass
	public static void openWebBrowserForTesting() {
		
		String homeDir = System.getProperty("user.home");
		
		System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
		webDriver = new ChromeDriver();
	}

	@Before
	public void openSurvey() {
		webDriver.get("http://localhost:8080/m3-java-capstone/survey");
	}
	
	@AfterClass
	public static void closeWebBrowser() {
		webDriver.close();
	}
	
	@Test
	public void elements_can_be_found_by_class() {
		WebElement favoriteParkLabel = webDriver.findElement(By.className("label"));
		assertEquals("Vote for your favorite park:", favoriteParkLabel.getText());

	}

	@Test
	public void forms_can_be_edited_and_submitted() {
		
		
		
		WebElement emailField = webDriver.findElement(By.className("label"));
		// The sendKeys(...) method can be used to simulate typing in a field
		emailField.sendKeys("Hankey@css.com");
		// To interact with a <select> element, wrap the WebElement in a Select object
		Select alLevel = new Select(webDriver.findElement(By.className("selectAL")));
		alLevel.selectByVisibleText("Active");

		WebElement nextPage = webDriver.findElement(By.xpath("/surveyResults"));
		WebElement popPark = webDriver.findElement(By.className("labelPopularParks"));
		Assert.assertEquals("Most popular parks:", popPark.getText());

		
}
}
