package Sponsorship;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Sponsor {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		String Amount = "100";
		String Amount1 = "50";
		String startdate = "26-09-2018";
		String enddate = "09-09-2022";
		String email = "mallik@gmail.com";
		String password = "initpass";
		
		System.setProperty("webdriver.chrome.driver","./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://test-dynamic-usgbc.pantheonsite.io/sponsorship/content");
		
		WebElement sponsorshipCommunityName = driver.findElement(By.cssSelector("#edit-community-name"));
		Select scname = new Select(sponsorshipCommunityName);
		scname.selectByValue("3");
		String selected = sponsorshipCommunityName.getAttribute("value");
		System.out.println("Sponsorship Community Name selected - "+ selected);
		
		WebElement type = driver.findElement(By.xpath("//label[contains(text(),'Booth/Exhibit')]"));
		type.click();
		System.out.println("Sponsoship Type selected - "+type.getText());
		
		WebElement amountDetails = driver.findElement(By.cssSelector("#edit-amount"));
		amountDetails.sendKeys(Amount);
		System.out.println("Sponsorship Amount given - "+Amount);
		
		driver.findElement(By.cssSelector("#edit-start-date")).sendKeys(startdate);
		System.out.println("Start Date selected - "+startdate);
		driver.findElement(By.cssSelector("#edit-end-date")).sendKeys(enddate);
		System.out.println("End Date Selected - "+enddate);
		
		WebElement add =driver.findElement(By.cssSelector("#edit-address-address-line1"));
		add.sendKeys("725 chestnut st");
		System.out.println(add.getAttribute("value"));
		driver.findElement(By.cssSelector("#edit-address-address-line2")).sendKeys("west");
		driver.findElement(By.cssSelector("#edit-address-locality")).sendKeys("erie");
		
		WebElement state = driver.findElement(By.cssSelector("#edit-address-administrative-area"));
		Select statename = new Select(state);
		statename.selectByValue("PA");
		
		driver.findElement(By.cssSelector("#edit-address-postal-code")).sendKeys("16507");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#edit-submit")).click();
		System.out.println("Entered all sponsorship details and moving to payment page");
		
		driver.findElement(By.cssSelector("#edit-existinguser-usernamae")).sendKeys(email);
		driver.findElement(By.cssSelector("#edit-existinguser-password")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#edit-submit")).click();
		System.out.println("Credentials entered and navigating to payment page");
		Thread.sleep(2000);
		System.out.println("Modifying the sponsorship details");
		driver.findElement(By.xpath("//div[@class='sidebar sidebar_payment']/div[1]/a")).click();
		
		WebElement amount1Details = driver.findElement(By.cssSelector("#edit-amount"));
		amount1Details.sendKeys(Keys.chord(Keys.CONTROL,"a"),Amount1);
		System.out.println("Sponsorship Amount Changed to - "+Amount1);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='op']")).click();
		//driver.findElement(By.cssSelector("#edit-submit")).click();
		System.out.println("Modified sponsorship details and moving to payment page");
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
		
		driver.findElement(By.xpath("//input[@name='billing_address[address_line1]']")).sendKeys("725 chestnut st");
		driver.findElement(By.xpath("//input[@name='billing_address[address_line2]']")).sendKeys("west");
		driver.findElement(By.xpath("//input[@name='billing_address[locality]']")).sendKeys("erie");
		
		WebElement billstate = driver.findElement(By.xpath("//select[@name='billing_address[administrative_area]']"));
		Select billstatename = new Select(billstate);
		billstatename.selectByValue("PA");
		
		driver.findElement(By.xpath("//input[@name='billing_address[postal_code]']")).sendKeys("16505");
		
		driver.findElement(By.xpath("//input[@name='op']")).click();
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("./Sceenshot/Sponsorreceipt1.png"));
		System.out.println("payment successfully done and screen shot captured");
		

	}

}
