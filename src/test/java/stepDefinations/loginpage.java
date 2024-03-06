package stepDefinations;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import PageObject.login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginpage{
	WebDriver driver;
	login L;
	Properties properties;
	
	
	@Given("Click on Login\\/Signup button and click on google")
	public void click_on_login_signup_button_and_click_on_google() {
		driver = hooks.getDriver();
		properties = hooks.getP();
		driver.get(properties.getProperty("url"));
		L = new login(driver);
		L.click_loginsignUp();
		L.click_google();
	}

	@Given("Redirecting to login page")
	public void redirecting_to_login_page() {
		L = new login(driver);
		L.switchToLoginPage();
	}

	@When("Enter login details")
	public void enter_login_details() {
		L = new login(driver);
		L.loginDetails();
		L.click_next();
	}

	@Then("capture error message")
	public void capture_error_message() {
		L = new login(driver);
		L.captureError();
	}



}

