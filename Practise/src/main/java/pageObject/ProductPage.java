package pageObject;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import uiStore.ProductPageUI;
import utilities.Log;

public class ProductPage {
	WebDriver driver;
	ProductPageUI a =new ProductPageUI();
	

	public ProductPage(WebDriver driver) {
		Log.info("ProductPage opened");
		this.driver = driver;
	}

	
	public void switchtoTab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Log.info("Switched to new tab");
	}

	public void ValidateProductPage(ExtentTest test) {
		String expect = "Car";
		String actual = driver.getTitle();
		System.out.println(driver.getTitle());
		if (actual.contains(expect)) {
			test.log(LogStatus.PASS, "car found");
			System.out.println("done");
		} 
	}

	public void SelectSize() throws InterruptedException {
		Select s = new Select(driver.findElement(a.dropdown));
		s.selectByIndex(2);
		Thread.sleep(2000);
		Log.info("Size selected");
	}

	public void addToCart() {
		driver.findElement(a.add).click();
		Log.info("Product added to cart");
	}

		}


	

