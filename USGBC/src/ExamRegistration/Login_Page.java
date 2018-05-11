package ExamRegistration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ExcelDataConfig;

public class Login_Page {
	
	
	WebDriver driver;
	public Login_Page(WebDriver driver)  {
		this.driver= driver;
		
	}
	 
	String userid = ExcelDataConfig.getdata(0, 1, 0);
	String pass = ExcelDataConfig.getdata(0, 1, 1);
	
	public void loginDetials() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='existinguser_usernamae']")).sendKeys(userid);
		driver.findElement(By.xpath("//input[@name='existinguser_password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@name='op']")).click();
	}
	
	
	

}
