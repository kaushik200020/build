package uiStore;

import org.openqa.selenium.By;

public class CartPageUI {
	public By cart = By.xpath("//*[@id=\"nav-cart-count\"]");
	public By cart_item = By.xpath("//span[@class='a-truncate-cut']");
}
