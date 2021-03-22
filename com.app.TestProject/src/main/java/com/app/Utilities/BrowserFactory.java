package com.app.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public static WebDriver driver=null;
	public static ConfigReader reader;
	
	
	public static WebDriver getbrowser(String browsername,String appurl) {
		
	    reader=new ConfigReader();	
		
		
	    if(browsername.equals("chrome")) {
	    	System.setProperty(reader.getdriversetup(), reader.getdriverpath());
	    	driver=new ChromeDriver();
	    	
	    }
	    else if(browsername.equals("firefox")) {
	    	System.setProperty("webdriver.gecko.driver", "./app.Drivers/geckodriver.exe");
	    	driver=new FirefoxDriver();
	    	
	    }
	    else if(browsername.equals("edge")) {
	    	System.setProperty("webdriver.edge.driver", "./app.Drivers/msedgedriver.exe");
	    	driver=new ChromeDriver();
	    	
	    }
		
		
	    	driver.get(appurl);
	    	
	    	driver.manage().window().maximize();
		
		
		
		return driver;
		
		
	}
	
	
	
	public void closebrowser() {
		driver.close();
	}
	

}
