package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	
	private static WebDriver webDriver;
	
	
	@BeforeClass
	public static void openWebBrowserForTesting() {
		
		String homeDir = System.getProperty("user.home");
		
		System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
		webDriver = new ChromeDriver();
	}

	@Before
	public void openHomePage() {
		webDriver.get("http://localhost:8080/m3-java-capstone/");
	}
	
	@AfterClass
	public static void closeWebBrowser() {
		webDriver.close();
	}
	
	@Test
	public void elements_can_be_found_by_class() {
		WebElement savingsH2 = webDriver.findElement(By.className("panel"));
		//WebElement loansH2 = webDriver.findElement(By.id("loans"));
		assertEquals("Start Saving", savingsH2.getText());
		assertEquals("Open Checking", checkingH2.getText());
		assertEquals("Loans", loansH2.getText());
	}

}
