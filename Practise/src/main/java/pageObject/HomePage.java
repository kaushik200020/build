package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import uiStore.HomePageUI;
import utilities.Log;



public class HomePage {
	WebDriver driver;
	HomePageUI a=new HomePageUI();
	
	
	public HomePage(WebDriver driver) {
		Log.info("HomePage opened");
		this.driver=driver;
	}
	public void close(WebDriver driver) {
		driver.findElement(a.close).click();
		Log.info("faqs closed");
		
	}
	public void iconclick(WebDriver driver) {
	driver.findElement(a.searchicon).click();
	Log.info("search icon clicked");
	}
	public  void enterItem(String string) {
		driver.findElement(a.searchbox).sendKeys(string);
		Log.info("Entered item name in search box");
	}
	
	public void hover(WebDriver driver) {
		Actions a1=new Actions(driver);
		a1.moveToElement(driver.findElement(a.aboutus)).build().perform();
		a1.moveToElement(driver.findElement(a.corporte)).click().build().perform();
		
		
	}
	public void clickSearch() {
		driver.findElement(a.searchButton).click();
		Log.info("Search button clicked");
	}


}
