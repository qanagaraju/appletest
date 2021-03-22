package com.app.TestCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.Utilities.BrowserFactory;
import com.app.Utilities.ConfigReader;

import app.TestCases.AppGratuityCalculatorPage;





public class AppGratuityCalculator  {
 
	public  BrowserFactory browser;
	public  WebDriver driver;
	public  ConfigReader config;
	public AppGratuityCalculatorPage gratuitypage;
	
	@BeforeSuite
	public void setupsuite() {
		
		browser=new BrowserFactory();
		config = new ConfigReader();
		
	}
	
	
	@BeforeTest
	public void launchbrowser() {
		
		driver = BrowserFactory.getbrowser(config.getbrowsername(), config.getgratuityurl());
	}
	
	
	
	
  @Test(description="Verify Gratuity Calculator")
  public void f() {
	  
	  gratuitypage= new AppGratuityCalculatorPage(driver);
	
	  int totalgratuity = 5000*5*15/26;
	  System.out.println(totalgratuity);
	  
	  gratuitypage.getsalary("5000");
	  gratuitypage.getyears("5");
	  gratuitypage.getsubmit();
	  
	  String amount = driver.findElement(By.id("graduity_amt")).getText();
	  System.out.println(amount);
	  
	  int totalamount = Integer.parseInt(amount);
	  System.out.println(totalamount);
	  
	  
	  if(totalgratuity==totalamount) {
		  System.out.println("Total verified");
	  }
	  else
	  {
		  System.out.println("Does not verified");
	  }
	  
	  
	  
  }
  
  
  
  @AfterTest
  public void closeBrowser() {
	  browser.closebrowser();
  }
  
}
