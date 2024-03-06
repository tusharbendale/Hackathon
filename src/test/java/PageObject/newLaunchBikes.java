package PageObject;

import static org.junit.Assert.assertArrayEquals;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.NeedsLocalLogs;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;
import utilities.utilities;

public class newLaunchBikes extends BasePage {
	//static WebDriver driver;
	
		// Constructor - calling parent class constructor
		public newLaunchBikes(WebDriver driver) {
			super(driver);
		}
		
		// WebElements
		@FindBy(xpath="(//a[@href='/newbikes'][1])")
		private WebElement newBike;
		
		@FindBy(xpath="//span[text()='Upcoming Bikes']")
		private WebElement upcomingBikes;
		
		@FindBy(id = "makeId")
		private WebElement manufacturers;
		
		@FindBy(xpath="//span[text()=\"...Read More\"]")
		private WebElement readMore;
		
		@FindBy(xpath="//strong[@class=\"lnk-hvr block of-hid h-height\"]")
		private List <WebElement> bikeModel;
		
		@FindBy(xpath="//div[@class=\"b fnt-15\"]")
		private List <WebElement> bikePrice;
		
		@FindBy(xpath="//div[contains(text(),'Launch')]")//div[@class=\"clr-try fnt-14\"]
		private List <WebElement> bikeLaunchDate;
		
		@FindBy(xpath="//span[text()='View More Bikes ']")
		private WebElement viewMore;
		
		
		//Check home title
		public String homeTitle() {
			String actual = driver.getTitle();
			return actual;
		}
		
		//hover on newBikes header 
		public void hover_newBikes() {
			 Actions action=new Actions(driver);	 
			 action.moveToElement(newBike).build().perform();
			 
		}
		
		//check upcoming bike option is available or not
		public boolean verify_upcomingBikes() {
			boolean actual=upcomingBikes.isDisplayed();
			return actual;
		}
		
		//click on upcoming bikes option
		public void click_upcomingBikes() {
			upcomingBikes.click();
		}
		
		public String upcomingBikePageTitle() {
			String actual = driver.getCurrentUrl();
			return actual;
		}
		
		//
		public void click_manufacturers() {
			manufacturers.click();
			//select manufacturer
			Select select = new Select(manufacturers);
			select.selectByVisibleText("Honda");
		}
		
		public String verify_hondaTitle() {
			String actual = driver.getCurrentUrl();
			return actual;
		}
		
		public void click_viewMore() {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", viewMore);		
		}
		
		public void bikesBelow4Lakhs() {
			// 
			List<String> prList = new ArrayList<>();
			for(WebElement pr : bikePrice) {
				prList.add(pr.getText());
			}
			
			List<String> prices = new ArrayList<>();
			for(String prS : prList) {
				System.out.println(prS);
				String[] temp = prS.split(" ");
				String r = temp[1];
				if(r.contains(",")) {
					r = r.replaceAll(",", "");
				}
				prices.add(r);
			}
			System.out.println(" - " + prices);
			
			String[] data = new String[3];
		    int row = 1;
			
			for (int i = 0; i < prices.size(); i++) {
		        String bikePriceText = bikePrice.get(i).getText();
		        String bikePriceValue = prices.get(i);
		 
		        if (!bikePriceValue.isEmpty()) {
		            double bikePriceDouble = 0;
		            //System.out.println(bikePriceValue);
		 
		            if (bikePriceValue.contains(".")) {
		            	
		                bikePriceDouble = Double.parseDouble(bikePriceValue);
		            } else {
		            	int bikePriceThousand = Integer.parseInt(bikePriceValue);
		            	if(bikePriceThousand < 400000) {
		            		bikePriceDouble = 1.0;
		            	}
		            }
		 
		            if (bikePriceDouble < 4.00) {
		                String bikeName = bikeModel.get(i).getText();
		                System.out.println("Bike Name: " + bikeName);
		                data[0] = bikeName;
		                System.out.println("Price: " + bikePriceText);
		                data[1] = bikePriceText;
		                System.out.println("Expected Launch Date: " + bikeLaunchDate.get(i).getText());                
		                data[2] = bikeLaunchDate.get(i).getText();
		                System.out.println("--------------------");
		                utilities.writeRow(data, row++, "output.xlsx", "Bikes");
		            }
		        }
		    }
			
		}
		
		
}