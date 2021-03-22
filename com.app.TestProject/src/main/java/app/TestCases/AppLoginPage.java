package app.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.app.Utilities.CaptureScreenshot;
import com.app.Utilities.ConfigReader;

public class AppLoginPage  {
	
	public static WebDriver driver;
	public static ConfigReader applogin = new ConfigReader();
	public static CaptureScreenshot screen = new CaptureScreenshot();
	WebElement loginbutton,signout,username,password;
	
	
	public AppLoginPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	public void verifyusername(String un) throws IOException {
		
		username = driver.findElement(By.name(applogin.getunelement()));
		username.sendKeys(un);
		//screen.capturescreen(driver, username, "username");
		
	}
	
	
	public void verifypassword(String pw) throws Exception {
		password = driver.findElement(By.name(applogin.getpwelement()));
		password.sendKeys(pw);
		//screen.capturescreen(driver, password, "password");
	}
	
	
	public void clickloginbutton() {
		 loginbutton = driver.findElement(By.name(applogin.getbuttonelement()));
		if(loginbutton.isEnabled()) {
			loginbutton.click();
			
		}
		
	}
	
	
	
		public void clicksignout() {
			
			signout = driver.findElement(By.xpath("//*[@id=\"user_bar\"]/ul/li[1]/a"));
		
			if(signout.isEnabled()) {
				signout.click();
				System.out.println("Login success");
			}
			else
			{
				System.out.println("Login fail");
				String errormessage = driver.findElement(By.id("right_col_top_err")).getText();
				System.out.println(errormessage);
			}
		
		
		
	}
	
	

}
