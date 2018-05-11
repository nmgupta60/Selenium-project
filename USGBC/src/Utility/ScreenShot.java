
package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	WebDriver driver;
	

	public ScreenShot(WebDriver driver) {
		this.driver = driver;
	}
	
	public void captureScreen(String screenshot ) throws InterruptedException, IOException {
		
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("./Sceenshot/"+screenshot+".png"));
		System.out.println(" screen shot captured");
	}



	

}
