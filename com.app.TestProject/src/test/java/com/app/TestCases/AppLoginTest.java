package com.app.TestCases;


import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.Utilities.BrowserFactory;
import com.app.Utilities.CaptureScreenshot;
import com.app.Utilities.ConfigReader;
import com.app.Utilities.ExcelProvider;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import app.TestCases.AppLoginPage;



public class AppLoginTest extends ExcelProvider  {
   
	public static WebDriver driver;
	public static BrowserFactory browser;
	public static ConfigReader config;
	public static AppLoginPage apploginpage;
	public static CaptureScreenshot screen;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static AppLoginTest excel;
	
		
	
	@BeforeSuite
	public void setupsuite() {
		
		browser=new BrowserFactory();
		config=new ConfigReader();
		screen=new CaptureScreenshot();
		 extent = new ExtentReports("./TestReports/report.html", true);
		 excel = new AppLoginTest();
		
		
	}
	
	
	@BeforeTest
	public void launchbrowser() {
		
		driver = BrowserFactory.getbrowser(config.getbrowsername(), config.getbrowserurl());
	}
	
	
	
	
    @Test(priority=1)
    public void verifyinvalidlogin() throws Exception
    {
    	
    	apploginpage=new AppLoginPage(driver);
    	test = extent.startTest("login test");
    	
    	apploginpage.verifyusername(config.getinvalidusername());
    	test.log(LogStatus.INFO, "Invalid User Name");
    	test.addScreenCapture(screen.capturescreen(driver,"Invalid UserName"));
    	
    	
    	
    	apploginpage.verifypassword(config.getpassword());
    	test.addScreenCapture(screen.capturescreen(driver,"Invalid Password"));
    	
    	
    	apploginpage.clickloginbutton();
    	test.addScreenCapture(screen.capturescreen(driver,"Login Button"));
    	
    	
    	
     
    }
    
    
    @Test(priority=2)
    public void verifyvalidlogin() throws Exception
    {
    	
    	XSSFSheet sheet = excel.wb.getSheetAt(0);
    	int rowcount = sheet.getLastRowNum();
    	
    	for(int i=0;i<rowcount;i++) {
    	
    	apploginpage=new AppLoginPage(driver);
    	
    	apploginpage.verifyusername(excel.getsheetname(0, i, 0));
    	apploginpage.verifypassword(excel.getsheetname(0, i, 1));
    	apploginpage.clickloginbutton();
    	
    	try {
    		apploginpage.clicksignout();
    		
    		
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	
    	}
     
    }
    
    
    
    @AfterTest
    public void closebrowser() {
    	browser.closebrowser();
    	extent.flush();
    }
 
    
    
}
