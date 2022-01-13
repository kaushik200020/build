package utilities;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public ExtentTest startTest(String testname) {
		extent = new ExtentReports("C:\\Users\\kaush\\Downloads\\Practise\\extentreport\\extentreport.html", true);
		extent.loadConfig(new File("C:\\Users\\kaush\\Downloads\\Practise\\src\\main\\resources\\extent-config.xml"));
		test = extent.startTest(testname);
		test.log(LogStatus.PASS, "Test case "+testname+" started ");
		return test;
	}
	public void endTest() {
		extent.endTest(test);
		extent.flush();
		extent.close();
	}

}
