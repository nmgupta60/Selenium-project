package usgbc.communityRegistration;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UsgbcDonations {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://test-dynamic-usgbc.pantheonsite.io/donation/online");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement donation = driver.findElement(By.xpath("//select[@id='edit-choose-amount']"));
		
		Select mydonation = new Select(donation);
		mydonation.selectByValue("$100");
		driver.findElement(By.xpath("//input[@id='edit-donor-name']")).sendKeys("Mallik");
		driver.findElement(By.xpath("//input[@id='edit-dedication-to-name']")).sendKeys("Arjun");
		driver.findElement(By.xpath("//input[@id='edit-dedication-to-email']")).sendKeys("mallik@gmail.com");
		driver.findElement(By.xpath("//textarea[@name='dedication_to_message']")).sendKeys("donation");
		driver.findElement(By.xpath("//input[@name='op']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='edit-name-on-card']")).sendKeys("Mallik");
		driver.findElement(By.xpath("//input[@id='edit-card-number']")).sendKeys("371449635392376");
		
		WebElement expmonth = driver.findElement(By.xpath("//select[@name='cardexpiration_month']"));
		Select month = new Select(expmonth);
		month.selectByValue("08");
		
		WebElement expyear = driver.findElement(By.xpath("//select[@name='cardexpiration_year']"));
		Select year = new Select(expyear);
		year.selectByValue("2022");
		
		driver.findElement(By.xpath("//input[@name='security_code']")).sendKeys("9997");
		
		driver.findElement(By.xpath("//input[@name='billing_address[address_line1]']")).sendKeys("518 chestnut st");
		driver.findElement(By.xpath("//input[@name='billing_address[address_line2]']")).sendKeys("west");
		driver.findElement(By.xpath("//input[@name='billing_address[locality]']")).sendKeys("Erie");
		
		WebElement billstate = driver.findElement(By.xpath("//select[@name='billing_address[administrative_area]']"));
		Select billstatename = new Select(billstate);
		billstatename.selectByValue("PA");
		
		driver.findElement(By.xpath("//input[@name='billing_address[postal_code]']")).sendKeys("16507");
		
		driver.findElement(By.xpath("//input[@name='op']")).click();
		
		Thread.sleep(3000);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("./Sceenshot/donation_receipt.png"));
		System.out.println("payment successfully done and screen shot captured");
		
		
		

	}

}
