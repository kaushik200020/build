package runner;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObject.CartPage;
import pageObject.HomePage;
import pageObject.ProductPage;
import pageObject.SearchResultPage;
import resuableComponents.CloseChrome;
import resuableComponents.OpenChrome;
import utilities.CaptureScreenShot;
import utilities.ExcelSheetReading;
import utilities.ExtentReport;
import utilities.Log;
import utilities.PropertiesFileReading;

public class uiic {
	
	public static ArrayList<String> s_search_string = null;
	public static String url = null;
	public static String path = null;
	public static WebDriver driver = null;
	public static ExtentReport extent = new ExtentReport();
	public static PropertiesFileReading prop = new PropertiesFileReading();
	public static ExtentTest test;
	public static CaptureScreenShot scr=new CaptureScreenShot();
	

	@BeforeTest
	public void Before() throws IOException {
		test= extent.startTest(uiic.class.getSimpleName());
		//s_search_string = prop.getItem();
	//	ExcelSheetReading excel=new ExcelSheetReading();
		s_search_string = ExcelSheetReading.getdata();
		url = prop.getUrl();
		path = prop.getDriverPath();
		OpenChrome op = new OpenChrome();
		driver = op.openBrowser(driver, path, url);
		
	    CaptureScreenShot.ss(driver,"C:\\Users\\kaush\\Downloads\\Practise\\ScreenShot");
	}
	
	@Test(priority=1)
	public static void test() throws IOException, InterruptedException {
		try {
			Log log = new Log();
			
			log.config();
			HomePage h = new HomePage(driver);
			h.close(driver);
			h.iconclick(driver);
			h.enterItem(s_search_string.get(0));
			h.clickSearch();
			ProductPage p = new ProductPage(driver);
			SearchResultPage sc = new SearchResultPage(driver);
			sc.openProduct();
		    p.ValidateProductPage(test);
			/*SearchResultPage sc = new SearchResultPage(driver);
			sc.clickOnBrand();
			sc.getName(test);
			sc.getPrice(test);
			sc.openProduct();

			ProductPage p = new ProductPage(driver);
			p.switchtoTab();
			p.ValidateProductPage(test);
			p.SelectSize();
			p.addToCart();
			
			CartPage c = new CartPage(driver);
			c.openCart();
			c.validateCart(test);*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@AfterTest
	public void After() {
		CloseChrome.close(driver);
		test.log(LogStatus.PASS,"browser closed succesfully");
		extent.endTest();
	}
}
