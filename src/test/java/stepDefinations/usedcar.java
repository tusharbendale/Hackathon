package stepDefinations;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.newLaunchBikes;
import PageObject.usedCars;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class usedcar {
	WebDriver driver;
	Logger logger;
	usedCars uc = new usedCars(driver);
	
	@Given("Hover on used cars")
	public void hover_on_used_cars() {
		logger = hooks.getLogger();
		driver = hooks.getDriver();
		logger.info("*********** Used cars - started ***********");
		uc = new usedCars(driver);
		uc.used_Car();
		logger.info("Successfully hover on used cars");
		logger.info("*********** Used cars - finished ***********");
	}

	@When("click on chennai")
	public void click_on_chennai() {
		uc = new usedCars(driver);
		uc.click_chennai();
		logger.info("Successfully clicked on chennai");
	}

	@When("get popular used car models")
	public void get_popular_used_car_models() {
		logger.info("*********** Get popular car model - started ***********");
		uc = new usedCars(driver);
		uc.getPopularModelNames();
		logger.info("Successfully get popular car model name");
		logger.info("*********** Get popular car model - finished ***********");
	}




}
