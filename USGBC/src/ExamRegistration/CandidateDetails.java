package ExamRegistration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.ExcelDataConfig;

public class CandidateDetails {
	
	WebDriver driver;
	public CandidateDetails (WebDriver driver) {
		this.driver= driver;
	}

	String attn = ExcelDataConfig.getdata(0, 1, 2);
	String company = ExcelDataConfig.getdata(0, 1, 3);
	String street1 = ExcelDataConfig.getdata(0, 1, 4);
	String street2 = ExcelDataConfig.getdata(0, 1, 5);
	String city = ExcelDataConfig.getdata(0, 1, 6);
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
		Thread.sleep(2000);
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
	

}
