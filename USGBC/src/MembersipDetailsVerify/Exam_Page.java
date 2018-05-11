package MembersipDetailsVerify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class Exam_Page {
	
	
	WebDriver driver;
	public Exam_Page(WebDriver driver)  {
		this.driver= driver;
		
	}
	public void detials() throws InterruptedException {
		Thread.sleep(3000);
		WebElement examType = driver.findElement(By.xpath("//select[@name='exam_type']"));
		Select exam = new Select(examType);
		exam.selectByVisibleText("LEED AP BD+C Exam");;
		System.out.println("Sponsorship Community Name selected - "+ examType.getAttribute("value"));
		
		WebElement selectLanguage = driver.findElement(By.xpath("//select[@name='language']"));
		Select language = new Select(selectLanguage);
		language.selectByValue("English");
		System.out.println("Selected Language - "+ selectLanguage.getAttribute("value"));
		
		driver.findElement(By.xpath("//input[@name='accomodation']")).click();
		
		driver.findElement(By.xpath("//input[@name='op']")).click();
		
	}
	
	//method using from payment page
	public void editExamDetails() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Modifying the cart from payment page");
		driver.findElement(By.xpath("//div[@class='sidebar sidebar_payment']/div[1]/a")).click();
		
		Thread.sleep(3000);
		WebElement examType = driver.findElement(By.xpath("//select[@name='exam_type']"));
		Select exam = new Select(examType);
		exam.selectByVisibleText("LEED AP Homes Exam");;
		System.out.println("Sponsorship Community Name selected - "+ examType.getAttribute("value"));
		
		driver.findElement(By.xpath("//input[@name='op']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='edit-terms']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='edit-submit']")).click();
		
	}

}
