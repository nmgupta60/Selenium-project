package BrowserFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Browsers {
	
	WebDriver driver;
	public Browsers(WebDriver driver) {
		this.driver = driver;
	}
//	static WebDriver driver;
//	
//	public static WebDriver Browsers(String browserName, String url) {
//		
//		
//		
//		return driver;
//	}
	public void Browser(String browserName,String url) {
		
		if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","./lib/geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","./lib/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("IE")) {
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);
		
		driver.get(url);
	}

}
