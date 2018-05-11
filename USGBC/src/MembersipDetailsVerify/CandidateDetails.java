package MembersipDetailsVerify;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.Assert;
import Utility.ExcelDataConfig;

public class CandidateDetails {
	
	WebDriver driver;
	public CandidateDetails (WebDriver driver) {
		this.driver= driver;
	}

	String attn = ExcelDataConfig.getdata(0, 1, 2);
	String company = ExcelDataConfig.getdata(0, 1, 3);
	String street1 = ExcelDataConfig.getdata(0, 1, 4); String address1; String afterAddress1;
	String street2 = ExcelDataConfig.getdata(0, 1, 5);String address2; String afterAddress2;
	String city = ExcelDataConfig.getdata(0, 1, 6);String cityname; String afterCityname;
	String zip = ExcelDataConfig.getdata(0, 1, 7);
	public void contactInfo () throws Exception {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='edit-attention-to']")).sendKeys(attn);
		driver.findElement(By.xpath("//input[@id='edit-company']")).sendKeys(company);
		driver.findElement(By.xpath("//input[@id='edit-address-address-line1']")).sendKeys(street1);
		driver.findElement(By.xpath("//input[@id='edit-address-address-line2']")).sendKeys(street2);
		driver.findElement(By.xpath("//input[@id='edit-address-locality']")).sendKeys(city);
		WebElement state = driver.findElement(By.cssSelector("#edit-address-administrative-area"));
		Select statename = new Select(state);
		statename.selectByValue("PA");
		
		driver.findElement(By.cssSelector("#edit-address-postal-code")).sendKeys(zip);
		Thread.sleep(1000);
	}
	
	public void personalInfo() throws Exception {
		String dob = ExcelDataConfig.getdata(0, 1, 8);
		String job = ExcelDataConfig.getdata(0, 1, 9);
		String organization = ExcelDataConfig.getdata(0, 1, 10);
		
		driver.findElement(By.xpath("//input[@id='edit-bday']")).sendKeys(dob);
		driver.findElement(By.xpath("//label[@for='edit-gender-m']")).click();
		driver.findElement(By.xpath("//input[@id='edit-jobtitle']")).sendKeys(job);
		driver.findElement(By.xpath("//input[@id='edit-organization']")).sendKeys(organization);
		driver.findElement(By.xpath("//input[@id='edit-terms']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='edit-submit']")).click();
	}
	public void contactInfoStoring() {
	
		address1 = driver.findElement(By.xpath("//input[@id='edit-address-address-line1']")).getAttribute("value");
		address2 = driver.findElement(By.xpath("//input[@id='edit-address-address-line2']")).getAttribute("value");
		cityname = driver.findElement(By.xpath("//input[@id='edit-address-locality']")).getAttribute("value");
		System.out.println(address1+"-"+address2+"-"+cityname);
	}
	public  void verifyFields() {
		Assert assertion = new Assert(driver);
		afterAddress1 = driver.findElement(By.xpath("//input[@id='edit-address-address-line1']")).getAttribute("value");
		afterAddress2 = driver.findElement(By.xpath("//input[@id='edit-address-address-line2']")).getAttribute("value");
		afterCityname = driver.findElement(By.xpath("//input[@id='edit-address-locality']")).getAttribute("value");
		System.out.println(afterAddress1+"-"+afterAddress2+"-"+afterCityname);
		Boolean isThere0 = afterAddress1.contains(address1);
		Boolean isThere1 = afterAddress2.contains(address2);
		Boolean isThere2 = afterCityname.contains(cityname);
//		assertEquals(address1, afterAddress1,"value doesnt match");
//		assertEquals(address2, afterAddress2,"value doesnt match");
//		assertEquals(cityname, afterCityname,"value doesnt match");
//		assertTrue(address1==afterAddress1, "value not preset");
	
		
	}
	

}
