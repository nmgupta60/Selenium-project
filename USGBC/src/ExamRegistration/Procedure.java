package ExamRegistration;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import BrowserFactory.Browsers;
import Utility.Assert;
import Utility.ExcelDataConfig;
import Utility.ScreenShot;


public class Procedure {
	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
//		String attn = ExcelDataConfig.getdata(0, 1, 2);
//		System.out.println(attn);
		System.setProperty("webdriver.chrome.driver","./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://test-dynamic-usgbc.pantheonsite.io/register-exams/exam");
		
		//Browsers.Browsers("chrome","http://test-dynamic-usgbc.pantheonsite.io/register-exams/exam");
//		Browsers bro = new Browsers(driver);
//		bro.Browser("chrome", "http://test-dynamic-usgbc.pantheonsite.io/register-exams/exam");

		Exam_Page obj = new Exam_Page(driver);
		obj.detials();
		
		Login_Page logobj = new Login_Page(driver);
		logobj.loginDetials();
		
		obj.detials();
		
		CandidateDetails canobj = new CandidateDetails(driver);
		canobj.contactInfo();
		canobj.personalInfo();
	
		ScreenShot picobj = new ScreenShot(driver);
		picobj.captureScreen("paymentpage");
		
		obj.editExamDetails();	
			
		Payment_Page payobj = new Payment_Page(driver);
		payobj.cardInfo();
		payobj.billingInfo();
	
		picobj.captureScreen("afterpayment");
	
		Assert verifyobj = new Assert(driver);
		verifyobj.verifyPayment();
	}
	

}
