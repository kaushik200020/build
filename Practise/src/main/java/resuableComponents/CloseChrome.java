package resuableComponents;

import org.openqa.selenium.WebDriver;

public class CloseChrome {
	public static void close(WebDriver driver) {
		driver.switchTo().defaultContent();
		//driver.close();
		//driver.quit();
	}

}
