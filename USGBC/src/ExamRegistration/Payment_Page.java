package ExamRegistration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.ExcelDataConfig;

public class Payment_Page {
	
	WebDriver driver;
	public Payment_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void cardInfo() throws InterruptedException {
		String cardname = ExcelDataConfig.getdata(0, 1, 13);
		String cardno = ExcelDataConfig.getdata(0, 1, 14);
		String cvv = ExcelDataConfig.getdata(0, 1, 15);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys(cardname);
		driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys(cardno);
		
		WebElement expmonth = driver.findElement(By.xpath("//select[@name='cardexpiration_month']"));
		Select month = new Select(expmonth);
		month.selectByValue("08");
		
		WebElement expyear = driver.findElement(By.xpath("//select[@name='cardexpiration_year']"));
		Select year = new Select(expyear);
		year.selectByValue("2022");
		
		driver.findElement(By.xpath("//input[@name='security_code']")).sendKeys(cvv);		
	}
	
	public void billingInfo() throws InterruptedException {
		String street1 = ExcelDataConfig.getdata(0, 1, 4);
		String street2 = ExcelDataConfig.getdata(0, 1, 5);
		String city = ExcelDataConfig.getdata(0, 1, 6);
		String zip = ExcelDataConfig.getdata(0, 1, 7);
		driver.findElement(By.xpath("//input[@id='edit-billing-address-address-line1']")).sendKeys(street1);
		driver.findElement(By.xpath("//input[@id='edit-billing-address-address-line2']")).sendKeys(street2);
		driver.findElement(By.xpath("//input[@id='edit-billing-address-locality']")).sendKeys(city);
		WebElement state = driver.findElement(By.xpath("//select[@id='edit-billing-address-administrative-area']"));
		Select statename = new Select(state);
		statename.selectByValue("PA");
		
		driver.findElement(By.xpath("//input[@id='edit-billing-address-postal-code']")).sendKeys(zip);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='op']")).click();
	}

}
