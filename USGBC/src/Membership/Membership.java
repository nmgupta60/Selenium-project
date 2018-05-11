package Membership;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ExamRegistration.CandidateDetails;
import ExamRegistration.Login_Page;
import ExamRegistration.Payment_Page;
import Utility.Assert;
import Utility.ScreenShot;

public class Membership {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver","./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://test-dynamic-usgbc.pantheonsite.io/membership/contact");

		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
		Login_Page logobj = new Login_Page(driver);
		logobj.loginDetials();
		
		CandidateDetails canobj = new CandidateDetails(driver);
		canobj.contactInfo();
		
		driver.findElement(By.xpath("//input[@id='edit-terms']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='edit-submit']")).click();
		
		OrganizationDetails orgobj = new OrganizationDetails(driver);
		orgobj.membershipLevel("promantus","www.promantus.com","promantus@gmail.com");
		
		orgobj.editlevel();		
		
		Payment_Page payobj = new Payment_Page(driver);
		payobj.cardInfo();
		payobj.billingInfo();
		
		ScreenShot picobj = new ScreenShot(driver);
		picobj.captureScreen("membership_paymentpage");
		
		Assert verifyobj = new Assert(driver);
		verifyobj.verifymembershpPayment();

	}

}
