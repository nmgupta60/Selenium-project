package com.DynamicUSGBC;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import com.DynamicUSGBC.XlsReader;

public class BaseClass {

	public static WebDriver driver;
	public static XlsReader data;
	public Properties prop;
	public static String BaseUrl = "http://test-dynamic-usgbc.pantheonsite.io/";
	public String MembershipUrl = "http://test-dynamic-usgbc.pantheonsite.io/membership/contact";

	@BeforeClass
	public void setup(String browserName) {

		System.out.println("This is Before Class");
		data= new XlsReader(System.getProperty("C:\\Users\\ARJUN\\git\\Selenium-project\\USGBC\\TestData\\Input.xls"));

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equals("Firefox")) {
			System.out.println("I am Firefox");
		}

		else if (browserName.equals("Internet Explorer")) {
			System.out.println("I am Internet Explorer");
		}

		else if (browserName.equals("Mallikarjun")) {
			System.out.println("I am Mallikarjun");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(MembershipUrl);
		System.out.println(driver.getTitle());
		
	}
}
