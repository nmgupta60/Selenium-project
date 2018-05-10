package com.DynamicUSGBC;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public static WebDriver driver;
	public static XlsReader data;
	public Properties prop;
	public static String BaseUrl = "http://test-dynamic-usgbc.pantheonsite.io/";
	public String MembershipUrl = "http://test-dynamic-usgbc.pantheonsite.io/membership/contact";

	@BeforeClass
	public void setup(String browserName, String environment) {

		System.out.println("This is Before Class");

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
			System.out.println("I am Mallikarjunr");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
	}
}
