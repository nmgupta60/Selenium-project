package ExamRegistration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Edit {
	
	WebDriver driver;
	public Edit(WebDriver driver) {
		this.driver = driver;
	}
	
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
