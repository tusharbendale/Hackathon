package TestCases;

import static org.testng.Assert.assertEquals;

import org.bouncycastle.jcajce.provider.symmetric.DSTU7624.AlgParamGen128;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.newLaunchBikes;
import TestBase.BaseClass;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

	public class TC_1_UpcomingBikes extends BaseClass{
	
			//private WebDriver driver;
			newLaunchBikes nl;
			
			
			//Check home title
			@Test (priority=1,groups={"sanity","master"}) 
			public void verifyHomeTitle() {
				logger.info("*********verifing Home Title started***********");
				nl = new newLaunchBikes(driver);
				String actual = nl.homeTitle();
				logger.info("got the page title");
				String expected = properties.getProperty("HomePageTitle");
				Assert.assertEquals(actual, expected);
				logger.info("***********verified Home Title finished***********");
			}
			
			//hover on newBikes header 
			@Test (priority=2,groups={"sanity","master"})
			public void hoverOnNewBikes() {
				logger.info("***********Hover On Upcoming Bikes started***********");
				nl = new newLaunchBikes(driver);
				nl.hover_newBikes();
				logger.info("***********Hover On Upcoming Bikes finished***********");
			}
			
			//check upcoming bike option is available or not
			@Test (priority=3,groups={"sanity","master"})
			public void verifyUpcomingBikeOption() {
				logger.info("***********verifing Upcoming Bike Option - started***********");
				nl = new newLaunchBikes(driver);
				boolean actual = nl.verify_upcomingBikes();
				logger.info("Storing boolean value in actual");
				assertEquals(actual, true);
				logger.info("Verified upcoming bikes options");
				
				logger.info("***********verified Upcoming Bike Option - finished***********");
			}
			
			@Test (priority=4,groups={"sanity","regression","master"})
			public void ClickOnUpcomingBikes() {
				logger.info("***********Click On Upcoming Bikes - started***********");
				nl = new newLaunchBikes(driver);
				takeScreenshot("homePage");
				nl.click_upcomingBikes();
				logger.info("***********Click On Upcoming Bikes - finished***********");
			}
			
			@Test (priority=5,groups={"sanity","regression","master"})
			public void verifyUpcomingBikePageTitle() {
				nl = new newLaunchBikes(driver);
				logger.info("***********verifing Upcoming Bike Page Title - started***********");
				String actual = nl.upcomingBikePageTitle();
				String expected = properties.getProperty("UpcomingBikePageUrl");
				Assert.assertEquals(actual, expected);
				logger.info("Verified upcoming page title");
				logger.info("***********verified Upcoming Bike Page Title - finished***********");
			}
			
			@Test (priority=6,groups={"sanity","regression","master"})
			public void clickOnManufacturers() {
				logger.info("***********click On Manufacturers - started***********");
				nl = new newLaunchBikes(driver);
				nl.click_manufacturers();
				logger.info("click On Manufacturers");
				logger.info("click On View MOre - Statred");
				nl.click_viewMore();
				logger.info("clicked On View MOre");
				logger.info("*********** click On View MOre - finished ***********");
			}
			
			@Test (priority=7,groups={"sanity","regression","master"})
			public void verifyHondaSelected() {
				logger.info("***********verify Honda Selected - started***********");
				nl = new newLaunchBikes(driver);
				String actual = nl.verify_hondaTitle();
				String expected = properties.getProperty("HondaTitle");
				Assert.assertEquals(actual, expected);
				logger.info("successfully selected honda dropdown");
				logger.info("***********verify Honda Selected - finished***********");
				
			}
			
			@Test (priority = 8,groups={"regression","master"})
			public void bikesBelow4Lakhs() {
				logger.info("***********Bikes Below 4 Lakhs - started***********");
				nl = new newLaunchBikes(driver);
				nl.bikesBelow4Lakhs();
				logger.info("***********Bikes Below 4 Lakhs - finished***********");
			}
	
	

	}
