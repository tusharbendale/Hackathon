package PageObject;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Only4test{
	
	static WebDriver driver;
	

	 public static void main(String[] args) {	 
		 driver  = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://www.zigwheels.com/");
		 driver.manage().window().maximize();
		 
//		 Actions action=new Actions(driver);	 
//		 WebElement newBike = driver.findElement(By.xpath("(//a[@href='/newbikes'][1])"));
//		 action.moveToElement(newBike).build().perform();
//		 
//		 driver.findElement(By.xpath("//span[text()='Upcoming Bikes']")).click();
//		 
//		 WebElement manufacture = driver.findElement(By.id("makeId"));
//		 manufacture.click();
//		 
//		 Select select = new Select(manufacture);
//		 select.selectByVisibleText("Honda");
//		 
//		 driver.findElement(By.xpath("//span[text()=\"...Read More\"]")).click();
//		 
//		 WebElement upcomingBike = driver.findElement(By.xpath("//h2[text()=\"Upcoming Honda Bikes Price List in India in 2024-2025\"]"));
//		 System.out.println(upcomingBike.getText());
//		 
//		 List <WebElement> table = driver.findElements(By.xpath("//table/tbody/tr"));
//		 
//		 for(WebElement tb: table) {
//			 System.out.println(tb.getText());
//		 }
		 
		 
		 
		 driver.findElement(By.xpath("//img[@alt='Avatar']")).click();
		
		 driver.findElement(By.xpath("//span[text()='Google']")).click();
		 
		
		 
		 Set <String> windowHandle= driver.getWindowHandles();
		 System.out.println(windowHandle);
		 Iterator <String> iterator = windowHandle.iterator();
		 
		 String parenrtWindow = (String) iterator.next();
		 String childWindow =(String) iterator.next();
		 
		 driver.switchTo().window(childWindow);
		 
		 
		 
		 driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("abc@abc");
		 
		 driver.findElement(By.xpath("//span[text()='Next']")).click();
		 
		
		 String errorMsg = driver.findElement(By.xpath("//div[text()='Enter a valid email or phone number']")).getText();
		 System.out.println(errorMsg);
		 
		 
		 driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys();
				 
		 
		 
		 driver.quit();
		 
		 
	 }
}
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 /*
		 
			public void TC_03_extractHondaBikes() throws InterruptedException {
				Select select =  new Select(driver.findElement(By.id("makeId")));
				select.selectByVisibleText("Honda");

			//	WebElement flag = driver.findElement(By.xpath("//div[normalize-space()='Do you own a Car or a Bike?']"));
				//WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(15));
				WebElement loadMore = driver.findElement(By.xpath("//span[@class='zw-cmn-loadMore']"));
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView();", loadMore);
				Thread.sleep(10);
				//ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='zw-cmn-loadMore']")
				loadMore.click();

				//Map<ArrayList<WebElement>,ArrayList<WebElement>> m = new LinkedHashMap<>();
				List<WebElement> bikeNames = driver.findElements(By.xpath("//strong[@class='lnk-hvr block of-hid h-height']"));
				List<WebElement> bikePrices = driver.findElements(By.xpath("//div[contains(@title,'Ex-Showroom')]"));

				List<String> bikeNamesUnder4lac = new ArrayList<String>();
				for(WebElement e : bikeNames) {
					System.out.println(e.getText());
				}
				for(WebElement e : bikePrices) {
					System.out.println(e.getText());
				}

				System.out.println(bikeNames.size());

			//new code

		String regex = "Rs\\. (\\d+(?:,\\d{3})*(?:\\.\\d{2})?)(?: Lakh)?";
				for(int i=0 ; i<bikePrices.size();i++) {
				//	System.out.println(bikePrices.get(i).getText().replaceAll(regex, "$1").trim().replace(",", ""));
					String bikePrice = bikePrices.get(i).getText().replaceAll(regex, "$1").trim().replace(",", "");

					if (!bikePrice.isEmpty()) { 
				        double bikePriceD = 0;
				        int bikePriceI = 0;
					if(bikePrice.contains(".")) {
						 bikePriceD = Double.parseDouble(bikePrice);
						 System.out.println(bikePriceD);
					}
					else {
						 bikePriceI = Integer.parseInt(bikePrice);
						 System.out.println(bikePriceI);
					}
					if(bikePriceD<4.00) {
						bikeNamesUnder4lac.add(bikeNames.get(i).getText());
						//System.out.println(bikeNamesUnder4lac.get(i)+"---"+bikePrices.get(i).getText());
					}
					}

				}
				for(String e : bikeNamesUnder4lac) {

					System.out.println(e);

				}


				}
	
	 }
	

*/
