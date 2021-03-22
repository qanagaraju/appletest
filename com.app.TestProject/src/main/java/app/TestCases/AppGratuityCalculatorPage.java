package app.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.app.Utilities.ConfigReader;

public class AppGratuityCalculatorPage {
	
	public static WebDriver driver;
	public static ConfigReader reader = new ConfigReader();
	
	
	public AppGratuityCalculatorPage(WebDriver driver) {
		
		this.driver=driver;
		
		
	}
	
	
	public void getsalary(String salary) {
		driver.findElement(By.id(reader.getsalaryelement())).sendKeys(salary);
	}
	
	
	public void getyears(String years) {
		driver.findElement(By.id(reader.getyearselement())).sendKeys(years);
	}
	
	
	public void getsubmit() {
		driver.findElement(By.id(reader.getbuttonelement())).click();
	}
	
	
	
	
	
	

}
