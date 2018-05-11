package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ConfigReader {
	
	Properties pro;
	
	public ConfigReader() {
		try {
			File src = new File("./lib/config.property");
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			pro.load(fis);
		
		} catch (Exception e) {
			System.out.println("Exception is - "+e.getMessage());
		}
	}
	public String getChromepath() {
		String path = pro.getProperty("ChromeDriver");
		return path;
		
	}

	public String getURL1() {
		
		String url = pro.getProperty("URL1");
		
		return url;
	}
	public String getURL2() {
		
		String url = pro.getProperty("URL2");
		
		return url;
	}


}
