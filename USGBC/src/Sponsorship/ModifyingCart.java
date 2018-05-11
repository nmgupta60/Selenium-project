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

public class ModifyingCart {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		String email = "mallik@gmail.com";
		String password = "initpass";
		String value = "2";
		String value1 = "1";
		
		System.setProperty("webdriver.chrome.driver","./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://test-dynamic-usgbc.pantheonsite.io/store");
		
		WebElement appleprice = driver.findElement(By.xpath("//div[contains(text(),'$30.00')]"));
		String greenappleprice = appleprice.getText();
		System.out.println("Green Apple Price - "+ greenappleprice);
		WebElement option = driver.findElement(By.xpath("//div[contains(text(),'Green Apple Lapel Pins')]"));
		System.out.println("Selected option - "+option.getText());
		option.click();

		driver.findElement(By.cssSelector("#edit-submit-31")).click();
		System.out.println("Proceeding to cart to validate the item and amount selected");
		Thread.sleep(3000);
		driver.findElement(By.id("edit-items-0-qty")).sendKeys(Keys.chord(Keys.CONTROL,"a"),value);
		System.out.println("Cart value changed to - "+value);
		driver.findElement(By.xpath("//div[@class='form-actions js-form-wrapper form-wrapper']/input[2]")).click();
		WebElement Total = driver.findElement(By.className("uc-price"));
		String cartamount = Total.getText();
		System.out.println("updated cart amount is - "+cartamount);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
		System.out.println("navigating to shipping details");
		
		driver.findElement(By.cssSelector("#edit-attention-to")).sendKeys("Gupta");
		driver.findElement(By.cssSelector("#edit-company")).sendKeys("promantus");
		
		WebElement add =driver.findElement(By.cssSelector("#edit-address-address-line1"));
		add.sendKeys("725 chestnut st");
		//System.out.println(add.getAttribute("value"));
		driver.findElement(By.cssSelector("#edit-address-address-line2")).sendKeys("west");
		driver.findElement(By.cssSelector("#edit-address-locality")).sendKeys("erie");
		
		WebElement state = driver.findElement(By.cssSelector("#edit-address-administrative-area"));
		Select statename = new Select(state);
		statename.selectByValue("PA");
		
		driver.findElement(By.cssSelector("#edit-address-postal-code")).sendKeys("16507");
		WebElement delivery = driver.findElement(By.xpath("//select[@name='ServiceType']"));
		Select deliverytype = new Select(delivery);
		deliverytype.selectByValue("GROUND_HOME_DELIVERY");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='edit-how-did-you-hear']//div[4]")).click();
		
		driver.findElement(By.xpath("//input[@id='edit-submit']")).click();
		
		System.out.println("Entered all shipping details and moving to payment page");
		
		driver.findElement(By.cssSelector("#edit-existinguser-usernamae")).sendKeys(email);
		driver.findElement(By.cssSelector("#edit-existinguser-password")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#edit-submit")).click();
		System.out.println("Credentials entered and navigating to payment page");
		Thread.sleep(2000);
		
		System.out.println("Modifying the cart from payment page");
		driver.findElement(By.xpath("//div[@class='sidebar sidebar_payment']/div[1]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='edit']")).click();
		
		driver.findElement(By.id("edit-items-0-qty")).sendKeys(Keys.chord(Keys.CONTROL,"a"),value1);
		System.out.println("Cart value changed to - "+value1);
		driver.findElement(By.xpath("//div[@class='form-actions js-form-wrapper form-wrapper']/input[2]")).click();
		WebElement Total2 = driver.findElement(By.className("uc-price"));
//		String cartamount = Total.getText();
		System.out.println("updated cart amount is - "+Total2.getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
		System.out.println("navigating to payment details");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='edit-submit']")).click();
		
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
		
		driver.findElement(By.xpath("//input[@name='billing_address[postal_code]']")).sendKeys("16507");
		
		driver.findElement(By.xpath("//input[@name='op']")).click();
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("./Sceenshot/modifyingcartreceipt2.png"));
		System.out.println("payment successfully done and screen shot captured");
	
		

	}

}
