package com.DynamicUSGBC;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class CommonMethods extends BaseClass {
	
public static WebElement findElement(final String objectLocater) throws IOException{
		
		//WaitUntilVisibility(objectLocater);
		//System.out.println(downloadPath);
		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(System.getProperty("./main/resources/ObjectLocator.properties"));
		OR.load(fp);		
		
		String objecttypeandvalues = OR.getProperty(objectLocater);
		System.out.println(objecttypeandvalues);
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0]; 
		System.out.println("obj type: " + objecttype);
		String objectvalue = splits[1];
		System.out.println("obj val: " + objectvalue);
			
		switch(objecttype){
		  
						case "id":
							return driver.findElement(By.id(objectvalue));
							
						case "xpath":
			  
							return driver.findElement(By.xpath(objectvalue));
			  			                
			            case "name":
			  
			            	return driver.findElement(By.name(objectvalue));
			  			               		  
			            case "class":
			  
			            	return driver.findElement(By.className(objectvalue));
			  
			            case "tagname":
			  
			        	    return driver.findElement(By.tagName(objectvalue));
			     
			            case "css":
			  			  
				        	return driver.findElement(By.cssSelector(objectvalue));
				        
			            case "linkText":
				  			  
				        	return driver.findElement(By.linkText(objectvalue));
			            default:
			            	
			            	return null;
		}
		
		}

	public static void setUrl(String URL) {
		
		System.out.println( URL);
		driver.get(URL);
	}


	public static void click(String objectLocater) throws IOException{
		
		
		findElement(objectLocater).click();
		
	}

	public static void sendKeys(String objectLocater,String value) throws IOException{
		findElement(objectLocater).sendKeys(value);
	}
	public static void moveToElement(String objectLocator) throws IOException{
		
		Actions action = new Actions(driver);
		action.moveToElement(findElement( objectLocator)).build().perform();
		
	}
	 public static void selectdropdown(String objectLocator,String value) throws IOException{
	    	
	    	Select se = new Select(findElement(objectLocator));
	    	se.selectByVisibleText(value);
	 }
	 
	public static String getText( String objectLocater) throws IOException {
	
		return findElement( objectLocater).getText();
		
	}
	
	public static String getattributeValue(String objectLocater) throws IOException {
		
		return findElement(objectLocater).getAttribute("value");
		
	}
	
	public static String getattributeLabel(String objectLocater) throws IOException {
			
			return findElement(objectLocater).getAttribute("label");
			
	}
	
	public static void assertEqualsMessage(String actual,String expected, String message) throws IOException{
			System.out.println("Actual is " + actual + "expected is "+expected);		
			Assert.assertEquals(actual, expected, message);
	}
	
	
	
	public void captureScreen(String screenshot ) throws InterruptedException, IOException {
		
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("./Sceenshot/"+screenshot+".png"));
		System.out.println(" screen shot captured");
	}
	public void sleep (int milis) {
	    Long milliseconds = (long) milis;
	    try {
	        Thread.sleep(milliseconds);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	public  void uploadFile() throws Exception {
       
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL); 
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL); 
		r.keyRelease(KeyEvent.VK_T);
	      
    }
    
	

}
