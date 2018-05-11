package usgbc.communityRegistration;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class CommunityRegistration {
	
	@Test
	public void communityDetails() throws InterruptedException, IOException {
		
		String add1 = "518 chestnut st";
		String add2 = "west";
		String cityname = "Erie";
		String zip = "16507";
		
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://test-dynamic-usgbc.pantheonsite.io/community/registration");
		
		WebElement communityName = driver.findElement(By.xpath("//select[@class='col-md-7 col-xs-12 usgbc-form-input form-select']"));
		
		Select name = new Select(communityName);
		name.selectByVisibleText("USGBC North Carolina");
		
		WebElement streetAddress = driver.findElement(By.xpath("//input[@class='address-line1 form-text required']"));
		streetAddress.sendKeys(add1);
		WebElement streetAddress2 = driver.findElement(By.xpath("//input[@class='address-line2 form-text required']"));
		streetAddress2.sendKeys(add2);
		WebElement city = driver.findElement(By.xpath("//input[@class='locality form-text required']"));
		city.sendKeys(cityname);
		
		WebElement state = driver.findElement(By.xpath("//select[@class='administrative-area form-select required']"));
		Select stateName = new Select(state);
		stateName.selectByValue("PA");
		
		WebElement zipcode = driver.findElement(By.xpath("//input[@class='postal-code form-text required']"));
		zipcode.sendKeys(zip);
		driver.findElement(By.xpath("//div[@id='edit-how-did-you-hear']//div[4]")).click();
		driver.findElement(By.xpath("//input[@class='form-checkbox']")).click();
		driver.findElement(By.xpath("//input[@name='op']")).click();
		
		Thread.sleep(2000);
		
		WebElement email = driver.findElement(By.xpath("//input[@name='existinguser_usernamae']"));
		email.sendKeys("mallik@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@name='existinguser_password']"));
		password.sendKeys("initpass");
		driver.findElement(By.xpath("//input[@name='op']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("Mallik");
		driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("371449635392376");
		
		WebElement expmonth = driver.findElement(By.xpath("//select[@name='cardexpiration_month']"));
		Select month = new Select(expmonth);
		month.selectByValue("08");
		
		WebElement expyear = driver.findElement(By.xpath("//select[@name='cardexpiration_year']"));
		Select year = new Select(expyear);
		year.selectByValue("2022");
		
		driver.findElement(By.xpath("//input[@name='security_code']")).sendKeys("9997");
		
		driver.findElement(By.xpath("//input[@name='billing_address[address_line1]']")).sendKeys(add1);
		driver.findElement(By.xpath("//input[@name='billing_address[address_line2]']")).sendKeys(add2);
		driver.findElement(By.xpath("//input[@name='billing_address[locality]']")).sendKeys(cityname);
		
		WebElement billstate = driver.findElement(By.xpath("//select[@name='billing_address[administrative_area]']"));
		Select billstatename = new Select(billstate);
		billstatename.selectByValue("PA");
		
		driver.findElement(By.xpath("//input[@name='billing_address[postal_code]']")).sendKeys(zip);
		
		driver.findElement(By.xpath("//input[@name='op']")).click();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("./Sceenshot/receipt.png"));
		System.out.println("payment successfully done and screen shot captured");
		
		
		
	}

}
