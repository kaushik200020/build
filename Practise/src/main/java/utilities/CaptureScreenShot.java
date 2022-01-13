package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class CaptureScreenShot {
	public static String ss(WebDriver webdriver,String fileWithPath) throws IOException{
		TakesScreenshot ts = (TakesScreenshot)webdriver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		Date d= new Date();
		String date = sdf.format(d);
		String ss = System.getProperty("user.dir")+"/ScreenShot/"+"err"+date+"err.jpg";
		File destFile = new File(ss);
		FileUtils.copyFile(srcFile, destFile);
		return ss;
	}

}
