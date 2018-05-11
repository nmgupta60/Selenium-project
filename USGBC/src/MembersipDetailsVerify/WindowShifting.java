package MembersipDetailsVerify;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import Utility.ConfigReader;

public class WindowShifting {

	WebDriver driver;
	ConfigReader config;
	
	public void tabShift() throws Exception {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL); r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL); r.keyRelease(KeyEvent.VK_T);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		//To navigate to new link/URL in 2nd new tab
		driver.get(config.getURL2());
	}
}
