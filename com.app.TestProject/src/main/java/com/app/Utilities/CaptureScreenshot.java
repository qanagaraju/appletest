package com.app.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CaptureScreenshot {
	
	
	public static WebDriver driver;
	
	
	
	public  String capturescreen(WebDriver driver,String screename) throws IOException {
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File file = element.getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		File dest = new File("./TestReports/"+screename+dateName+".png");
		
		String destpath = dest.getAbsolutePath();
		FileUtils.copyFile(file, dest);
		return destpath;
		
		
	}
	
	

}
