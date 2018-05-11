package Utility;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Assert {
	
	 WebDriver driver;
	public Assert(WebDriver driver) {
		this.driver = driver;
	}
	
	public  void verifyPayment() {
		Assert assertion = new Assert(driver);
//		System.out.print("Test 1 Started");
		WebElement price = driver.findElement(By.xpath("//table//tr[6]/td"));
		String value = price.getText();
		System.out.println(value);
		String givenValue = "$550";
		assertEquals(givenValue, value,"count doesnt match");
		System.out.println("Test 1 Completes");
		
	}
	public  void verifymembershpPayment() {
		Assert assertion = new Assert(driver);
//		System.out.print("Test 1 Started");
		WebElement price = driver.findElement(By.xpath("//table//tr[6]/td"));
		String value = price.getText();
		System.out.println(value);
		String givenValue = "$600";
		assertEquals(givenValue, value,"count doesnt match");
		System.out.println("Test 1 Completes");
	
	}

}
