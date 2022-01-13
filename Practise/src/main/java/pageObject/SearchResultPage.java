package pageObject;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import uiStore.SearchResultPageUI;
import utilities.Log;

public class SearchResultPage {
	WebDriver driver;
	SearchResultPageUI a =new SearchResultPageUI();
	
	public SearchResultPage(WebDriver driver) {
		Log.info("Search Result page");
		this.driver = driver;
	}

	public void clickOnBrand() {
		driver.findElement(a.Cat).click();
		Log.info("Category selected");
	}

	public void getName(ExtentTest test) {
		String name = driver.findElement(a.Name).getText();
		Log.info("Product name :\n "+name);
		if (name!=null) {
			test.log(LogStatus.PASS, "Product name :"+name);
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
	}

	public void getPrice(ExtentTest test) {
		String price = driver.findElement(a.Price).getText();
		Log.info("Product price :\n "+price);
		if (price!=null) {
			test.log(LogStatus.PASS, "Product price :"+price);
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
	}

	public void openProduct() {
		driver.findElement(a.product1).click();
		Log.info("Product opened in new tab");
	}

}
