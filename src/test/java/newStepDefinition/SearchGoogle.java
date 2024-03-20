package newStepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import dataProviders.ConfigFileReader;
import managers.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pageObjects.GoogleObjects;

import java.util.concurrent.TimeUnit;

public class SearchGoogle {
WebDriver driver;	
ConfigFileReader filereader = new ConfigFileReader();	
WebDriverManager webDriverManager;
GoogleObjects googlePage;

@Before
public void testSetUp() throws Exception {
	webDriverManager = new WebDriverManager();
	driver = webDriverManager.getDriver();
}

@Given("^I navigate to google$")
public void i_navigate_to_google() throws Throwable {
	driver.manage().window().maximize();    
	driver.get(filereader.getApplicationUrl());
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@When("^I enter a keyword$")
public void i_enter_a_keyword() throws Throwable {
	GoogleObjects object = new GoogleObjects(driver);
	object.fill_Data();
}

@Then("^I click search$")
public void i_click_search() throws Throwable {
	GoogleObjects object = new GoogleObjects(driver);
	object.click_Search();	
}

@After
public void killBrowser(Scenario scenario){
    if (scenario.isFailed()) {
		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
	}
	System.out.println("Successfully updated the Github.");
    driver.quit();
}
}