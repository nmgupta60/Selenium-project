package MembersipDetailsVerify;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import MembersipDetailsVerify.Exam_Page;
import MembersipDetailsVerify.CandidateDetails;
import MembersipDetailsVerify.Login_Page;
import Utility.ConfigReader;
import Utility.ScreenShot;

public class Membership {

ConfigReader config;
WebDriver driver;

	
	@BeforeTest
	public void setUp() {
		config = new ConfigReader();
		System.setProperty("webdriver.chrome.driver",config.getChromepath());
		System.out.println("=========setup ready=======");
	}
	@Test
	public void testChrome() throws Exception {
		System.out.println("===========test Started=========");
		ExtentReports logger = ExtentReports.get(Membership.class);
		logger.init("C:\\Users\\ARJUN\\Desktop\\Testing\\ExtentReports\\FieldsVerifyReport.html", true);
		logger.startTest("Verify Page Title");
		
		driver = new ChromeDriver();
		logger.log(LogStatus.INFO,"Browser is UP and running");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(config.getURL1());
		logger.log(LogStatus.INFO, "Application1 is up and runnning");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
		Login_Page logobj = new Login_Page(driver);
		logobj.loginDetials();
		
		CandidateDetails canobj = new CandidateDetails(driver);
		canobj.contactInfo();
		logger.log(LogStatus.INFO, "Details Entered and taking a screenshot");
		Thread.sleep(2000);
		ScreenShot picobj = new ScreenShot(driver);
		picobj.captureScreen("detailsEnteredMembershipURL");
		Thread.sleep(2000);
		logger.attachScreenshot("C:\\Users\\ARJUN\\eclipse-workspace\\USGBC\\Sceenshot\\detailsEnteredMembershipURL.png");
		canobj.contactInfoStoring();
		
		driver.findElement(By.xpath("//input[@id='edit-terms']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='edit-submit']")).click();
		logger.log(LogStatus.INFO,"Clicked on Continue and moving to open a new Tab");
		
			Robot r = new Robot();
				r.keyPress(KeyEvent.VK_CONTROL); 
				r.keyPress(KeyEvent.VK_T);
				r.keyRelease(KeyEvent.VK_CONTROL); 
				r.keyRelease(KeyEvent.VK_T);
			
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			System.out.println(driver.getWindowHandles()); 
			System.out.println(driver.getWindowHandle().length());
		driver.switchTo().window(tabs.get(1));
			

		driver.get(config.getURL2());
		
		logger.log(LogStatus.INFO, "Application2 is up and runnning");
		
		Exam_Page obj = new Exam_Page(driver);
		obj.detials();
		
		canobj.contactInfo();
		logger.log(LogStatus.INFO, "Details Entered and taking a screenshot");
		Thread.sleep(2000);
		picobj.captureScreen("detailsEnteredexamURL");
		Thread.sleep(2000);
		logger.attachScreenshot("C:\\Users\\ARJUN\\eclipse-workspace\\USGBC\\Sceenshot\\detailsEnteredMembershipURL.png");
		
		canobj.contactInfoStoring();
		canobj.personalInfo();
		
		driver.switchTo().window(tabs.get(0));
		logger.log(LogStatus.INFO,"Moved back to membership URL");
		
		driver.findElement(By.xpath("//div[@class='col-xs-3 bs-wizard-step complete']//a")).click();
		logger.log(LogStatus.INFO,"Verifying the data entered in contact page is still there or not");
		
		canobj.verifyFields();
		
		driver.switchTo().window(tabs.get(1));
		logger.log(LogStatus.INFO,"Moved back to exam URL");
		
		driver.findElement(By.xpath("//div[@class='col-xs-3 bs-wizard-step complete'][2]//a")).click();
		logger.log(LogStatus.INFO,"Verifying the data entered in contact page is still there or not");
		
		canobj.verifyFields();
		logger.log(LogStatus.PASS, "Details are verified");
		logger.endTest();
	}
	
}
