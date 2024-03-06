package PageObject;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;
import utilities.utilities;

public class usedCars extends BasePage{

	public usedCars(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//a[@href='/used-car']")
	private WebElement usedcars;
	
	@FindBy(xpath = "//span[@onclick=\"goToUrl('/used-car/Chennai')\"]")
	private WebElement chennai;
	
	@FindBy(xpath = "//div[@class=\"gsc_thin_scroll\"]//label")
	public List<WebElement>  popularModel;
	
	
	public void used_Car() {
		Actions action = new Actions(driver);
		action.moveToElement(usedcars).perform();
	}
	
	public void click_chennai() {
		chennai.click();
	}
	
	public void getPopularModelNames() {
		for(WebElement pm:popularModel){
			System.out.println(pm.getText());
			}
		System.out.println("--------------------");	
		for (int i=0;i< popularModel.size();i++) {		
			String result = popularModel.get(i).getText();
			String[] ans = new String[1];
			ans[0] = result;
		    utilities.writeRow(ans, i+1, "output.xlsx", "PopularCar");	
		}			
		
	}

}
