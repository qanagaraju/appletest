package com.app.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	
public static Properties prop;
	
	public ConfigReader() {
				
		try {
			File src = new File("./App.MyFiles/AppProperties.properties");
            FileInputStream fis = new  FileInputStream(src);
             prop = new Properties();
            prop.load(fis);
          //  System.out.println("Property class loaded");
        			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	
	
	//Methods creating for gratuity elements
	public String getsalaryelement() {
		return prop.getProperty("salaryelement");
	}
	
	public String getyearselement() {
		return prop.getProperty("yearselement");
	}
	
	public String getsubmitbuttonelement() {
		return prop.getProperty("submitbuttonelement");
	}
	
	public String getamount() {
		return prop.getProperty("amount");
	}
	
	public String getgratuityurl() {
		return prop.getProperty("gratuityurl");
	}
	
	
	
	
	//Methods created for properties
	
	public String getdriversetup() {
		return prop.getProperty("chromedriversetup");
	}
	
	public String getdriverpath() {
		return prop.getProperty("browserpath");
	}
	
	
	
	
	public String getbrowsername() {
		return prop.getProperty("browsername");
	}
	
	public String getbrowserurl() {
		return prop.getProperty("browserurl");
	}
	
	
	
	public String getusername() {
		return prop.getProperty("username");
	}
	
	
	public String getinvalidusername() {
		return prop.getProperty("username1");
	}
	
	public String getpassword() {
		return prop.getProperty("password");
	}
	
	
	public String signoutelement() {
		return prop.getProperty("signout");
	}
	
	
	//Methods created for Repositories
	public String getunelement() {
		return prop.getProperty("appun");
	}
	
	public String getpwelement() {
		return prop.getProperty("apppw");
	}
	
	public String getbuttonelement() {
		return prop.getProperty("appbutton");
	}
	
	
	public String getHomeLinkelement() {
		return prop.getProperty("helplink");
	}
	
	

}
