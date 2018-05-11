package Membership;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OrganizationDetails {
	WebDriver driver;
	public OrganizationDetails(WebDriver driver) {
		this.driver = driver;
	}
	
	public void membershipLevel(String orgname, String website, String email) throws InterruptedException {
		WebElement membershipTerm = driver.findElement(By.xpath("//select[@id='edit-membership-term']"));
		Select term = new Select(membershipTerm);
		term.selectByVisibleText("2 years");;
		System.out.println("Membership Term Selected - "+ membershipTerm.getAttribute("value"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'$1,500/year')]")).click();
		driver.findElement(By.xpath("//input[@id='edit-org-name']")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@id='edit-website']")).sendKeys(website);
		driver.findElement(By.xpath("//input[@id='edit-email']")).sendKeys(email);
		
		WebElement category = driver.findElement(By.xpath("//select[@id='edit-industry-category']"));
		Select ctgry = new Select(category);
		ctgry.selectByValue("21");
		Thread.sleep(2000);
		WebElement subcategory = driver.findElement(By.xpath("//select[@id='edit-industry-sub-category']"));
		Select sub = new Select(subcategory);
		sub.selectByValue("31");
		Thread.sleep(2000);
		WebElement revenue = driver.findElement(By.xpath("//select[@id='edit-revenue-scale']"));
		Select range = new Select(revenue);
		range.selectByValue("Less than $250,000");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='edit-submit']")).click();
		
		
	}
	public void editlevel() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Modifying the cart from payment page");
		driver.findElement(By.xpath("//div[@class='sidebar sidebar_payment']/div[1]/a")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'$300/year')]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='edit-submit']")).click();
	}

}
