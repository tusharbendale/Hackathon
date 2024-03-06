package TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.newLaunchBikes;


public class BaseClass {
	
	public static WebDriver driver;
	public Properties properties;
	public Logger logger;
	
	
	
	@BeforeClass(groups={"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void  driverSetup(String os,String br) throws MalformedURLException {
		
		logger=LogManager.getLogger();
		properties = new Properties();
		FileReader fileReader;
		try {
			fileReader = new FileReader(".\\src\\test\\resources\\config.properties");
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(properties.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabalities = new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabalities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac")) {
				capabalities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("no matching os .....");
	
			}
			//browser
			if(br.equalsIgnoreCase("chrome")) {
				capabalities.setBrowserName("chrome");
			}
			else if(br.equalsIgnoreCase("edge")) {
				capabalities.setBrowserName("MicrosoftEdge");
			}
			else {
				System.out.println("no matching browser .....");
			}
 
			 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub") , capabalities);
		}
		else if(properties.getProperty("execution_env").equalsIgnoreCase("local")) {
			// launching browser based on condition - locally
			if(br.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				logger.info("Chrome browser opened successfully");
			}
			else if(br.equalsIgnoreCase("edge")){
				driver = new EdgeDriver();
				logger.info("Edge browser opened successfully");
			}
			else {
				System.out.println("no matching browser......");
				logger.info("no matching browser......");
			}
 
		}

//		switch(br.toLowerCase())
//		{
//		
//		case "chrome" : 
//			driver = new ChromeDriver();
//			logger.info(br +" "+ "browser opened successfully");
//			break;
//			
//		case "edge" : 
//			driver = new EdgeDriver(); 
//			logger.info(br + " "+ "browser opened successfully");
//			break;
//			
//		default: 
//			logger.error("No matching browser...." );
//			return;
//		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	public static String takeScreenshot(String filename) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		String trgPath = System.getProperty("user.dir")+"\\Screenshots\\" + filename+"_"+timeStamp+".png";
		File trg =new File(trgPath);
		
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trgPath;
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}

}
