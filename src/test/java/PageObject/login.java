package PageObject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login extends BasePage{

			public login(WebDriver driver) {
				super(driver);
				// TODO Auto-generated constructor stub
			}
			
			@FindBy(xpath="//img[@alt='Avatar']")
			private WebElement login_signUp;
			
			@FindBy(xpath="//span[text()='Google']")
			private WebElement google;
			
			@FindBy(xpath="//input[@id='identifierId']")
			private WebElement email;
			
			@FindBy(xpath="//span[text()='Next']")
			private WebElement next;
			
			@FindBy(xpath="//div[text()='Enter a valid email or phone number']")
			private WebElement errorMsg;
			
				
			
			
			public  void click_loginsignUp() {
				login_signUp.click();
			}
					
			public void click_google() {
				google.click();
			}
						
			public void switchToLoginPage() {
				 Set <String> windowHandle= driver.getWindowHandles();
				 //System.out.println(windowHandle);
				 Iterator <String> iterator = windowHandle.iterator();
				 
				 String parenrtWindow = (String) iterator.next();
				 String childWindow =(String) iterator.next();
				 
				 driver.switchTo().window(childWindow);
			}
						
			public void loginDetails() {
				email.sendKeys("abc@abc");
			}
						
			public void click_next() {
				next.click();
			}
					
			public void captureError() {
				System.out.println(errorMsg.getText());
				System.out.println("--------------------");
				
			}

}
