package stepDefinations;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObject.newLaunchBikes;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinations.hooks;

public class upcomingbikes {
	WebDriver driver;
	Logger logger;
	Properties properties;
	newLaunchBikes nl = new newLaunchBikes(driver);
	
	
	@Given("Verifing HomePage title")
	public void verifing_home_page_title() {
		driver = hooks.getDriver();
		logger = hooks.getLogger();
		properties = hooks.getP();
		logger.info("*********verifing Home Title started***********");
		nl = new newLaunchBikes(driver);
		String actual = nl.homeTitle();
		logger.info("got the page title");
		String expected = properties.getProperty("HomePageTitle");
		Assert.assertEquals(actual, expected);
		logger.info("***********verified Home Title finished***********");
	}

	@Given("Hover on new bikes")
	public void hover_on_new_bikes() {
		logger.info("***********Hover On Upcoming Bikes started***********");
		nl = new newLaunchBikes(driver);
		nl.hover_newBikes();
		logger.info("***********Hover On Upcoming Bikes finished***********");
	}

	@Given("verifing upcoming bikes option")
	public void verifing_upcoming_bikes_option() {
		logger.info("***********verifing Upcoming Bike Option - started***********");
		nl = new newLaunchBikes(driver);
		boolean actual = nl.verify_upcomingBikes();
		logger.info("Storing boolean value in actual");
		assertEquals(actual, true);
		logger.info("Verified upcoming bikes options");
		
		logger.info("***********verified Upcoming Bike Option - finished***********");
	
	}

	@When("User clicked on upcoming bike option")
	public void user_clicked_on_upcoming_bike_option() {
		logger.info("***********Click On Upcoming Bikes - started***********");
		nl = new newLaunchBikes(driver);
		nl.click_upcomingBikes();
		logger.info("***********Click On Upcoming Bikes - finished***********");
	}

	@Then("Verify clicked or not on upcoming bike")
	public void verify_clicked_or_not_on_upcoming_bike() {
		nl = new newLaunchBikes(driver);
		logger.info("***********verifing Upcoming Bike Page Title - started***********");
		String actual = nl.upcomingBikePageTitle();
		String expected = properties.getProperty("UpcomingBikePageUrl");
		Assert.assertEquals(actual, expected);
		logger.info("Verified upcoming page title");
		logger.info("***********verified Upcoming Bike Page Title - finished***********");
	}

	@When("click on manufacturer and select honda from dropdown and click on view more")
	public void click_on_manufacturer_and_select_honda_from_dropdown_and_click_on_view_more() {
		logger.info("***********click On Manufacturers - started***********");
		nl = new newLaunchBikes(driver);
		nl.click_manufacturers();
		logger.info("click On Manufacturers");
		logger.info("click On View MOre - Statred");
		nl.click_viewMore();
		logger.info("clicked On View MOre");
		logger.info("*********** click On View MOre - finished ***********");
	}

	@Then("verify honda is selected or not")
	public void verify_honda_is_selected_or_not() {
		logger.info("***********verify Honda Selected - started***********");
		nl = new newLaunchBikes(driver);
		String actual = nl.verify_hondaTitle();
		String expected = properties.getProperty("HondaTitle");
		Assert.assertEquals(actual, expected);
		logger.info("successfully selected honda dropdown");
		logger.info("***********verify Honda Selected - finished***********");
	}
	
	@And("get all Bike details for selected manufacturer")
	public void get_all_Bike_details_for_selected_manufacturer() {
		logger.info("***********Bikes Below 4 Lakhs - started***********");
		nl = new newLaunchBikes(driver);
		nl.bikesBelow4Lakhs();
		logger.info("***********Bikes Below 4 Lakhs - finished***********");
	}


}
