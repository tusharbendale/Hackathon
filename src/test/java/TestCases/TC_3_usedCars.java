package TestCases;

import org.testng.annotations.Test;

import PageObject.newLaunchBikes;
import PageObject.usedCars;
import TestBase.BaseClass;

public class TC_3_usedCars extends BaseClass{
	usedCars uc;

	@Test(priority = 1,groups={"sanity","master"})
	public void usedCars() {
		logger.info("*********** Used cars - started ***********");
		uc = new usedCars(driver);
		uc.used_Car();
		logger.info("Successfully hover on used cars");
		uc.click_chennai();
		logger.info("Successfully clicked on chennai");
		logger.info("*********** Used cars - finished ***********");
	}
	
	@Test(priority = 2,groups={"sanity","regression","master"})
	public void popularModel() {
		logger.info("*********** Get popular car model - started ***********");
		uc = new usedCars(driver);
		uc.getPopularModelNames();
		logger.info("Successfully get popular car model name");
		logger.info("*********** Get popular car model - finished ***********");
		
	}
}
