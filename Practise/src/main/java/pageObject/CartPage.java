package pageObject;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import uiStore.CartPageUI;
import utilities.Log;



public class CartPage {
	WebDriver driver;
	CartPageUI a =new CartPageUI();

	public CartPage(WebDriver driver) {
		Log.info("CartPage opened");
		this.driver=driver;
	}

	
	public void openCart() {
		driver.findElement(a.cart).click();
		Log.info("Cart button clicked");
	}
	
	public  void validateCart(ExtentTest test) {
		String actual=driver.findElement(a.cart_item).getText();
		if (actual.contains("Allen Solly")) {
			test.log(LogStatus.PASS, "Product added to cart");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
	}

}
