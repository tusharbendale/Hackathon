package stepDefinations;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties; 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import bsh.This;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
	 
	public class hooks {
		static WebDriver driver;
		static Logger logger ;
		static Properties properties ; 
		
		public Logger logging() {
			logger= LogManager.getLogger();
			return logger;
		}
		
		@BeforeAll
	    public static void setup() throws IOException {
			FileReader file=new FileReader(".//src//test//resources//config.properties");
			properties=new Properties();
			properties.load(file);
			
			logger= LogManager.getLogger();

	    	driver = new ChromeDriver();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	driver.get(properties.getProperty("url"));
			driver.manage().window().maximize();
	    	
			//Loading property file
			
		}

	    @AfterAll
	    public static void tearDown() {
	       driver.quit();
	    }

	    @AfterStep
	    public void addScreenshot(Scenario scenario) {
	    
	        	TakesScreenshot ts=(TakesScreenshot) driver;
	        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
	        	scenario.attach(screenshot, "image/png",scenario.getName());

	    }
	    
	     public static WebDriver getDriver() {
			return driver;
		}
	    
	     public static Logger getLogger() {
			return logger;
		}
	     
	      public static Properties getP() {
			return properties;
	    }
	

}
