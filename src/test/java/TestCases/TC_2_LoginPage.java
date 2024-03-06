package TestCases;

import org.testng.annotations.Test;

import PageObject.login;
import PageObject.newLaunchBikes;
import TestBase.BaseClass;

public class TC_2_LoginPage extends BaseClass{
	
	login login ;
	
	@Test(priority = 1,groups={"sanity","master"})
	public void loginPage() {
		logger.info("*********** Verify login Page - started ***********");
		login = new login(driver);
		login.click_loginsignUp();
		logger.info("Successfully clicked on login/Signup Button");
		login.click_google();
		logger.info("Successfully clicked on google");
		logger.info("*********** Verify login Page - finished ***********");
	}
	
	@Test(priority = 2,groups={"sanity","regression","master"})
	public void redirectToLoginPage() {
		logger.info("*********** Redirect To Login Page - started ***********");
		login = new login(driver);
		login.switchToLoginPage();
		logger.info("Successfully switched on login Page");
		logger.info("*********** Redirect To Login Page - finished ***********");
	}
	
	@Test(priority = 3,groups={"sanity","regression","master"})
	public void loginDetails() {
		logger.info("*********** Redirect To Login Page - started ***********");
		login = new login(driver);
		login.loginDetails();
		logger.info("Successfully Details entered");
		login.click_next();
		logger.info("*********** Redirect To Login Page - finished ***********");
	}
	
	@Test(priority = 4,groups={"regression","master"})
	public void errorMsg() {
		logger.info("*********** ErrorMsg - started ***********");
		login = new login(driver);
		login.captureError();
		logger.info("Successfully captured error message");
		logger.info("*********** ErrorMsg - finished ***********");
	}

}
