package com.kblive.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.kblive.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	
	public String baseURL = readConfig.getApplicationURL();
	public String username = readConfig.getUsermame();
	public String password = readConfig.getPassword();
	public String eventTitle = readConfig.getEventtitle();
	public String catgeory = readConfig.getCatgeory();
	public String createEventExpectedUrl = readConfig.getCreateEventExpectedUrl();
	public String details = readConfig.getDetail();
	public String primaryHost = readConfig.getPrimaryHost();
	public String host2 = readConfig.getHost2();
	public String host3 = readConfig.getHost3();
	public String host4 = readConfig.getHost4();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	
	@BeforeClass
	public void setup(String br) {
		
		logger = Logger.getLogger("Kblive");
		
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
				
		}else if(br.equals("firefox")) {

			System.setProperty("webdriver.chrome.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
			
		}else if(br.equals("ie")) {

			System.setProperty("webdriver.chrome.driver", readConfig.getIEPath());
			driver = new InternetExplorerDriver();
			
		}
		driver.get(baseURL);
		
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
	
        //Call getScreenshotAs method to create image file

        File SrcFile=ts.getScreenshotAs(OutputType.FILE);

       //Move image file to new destination

    
        File DestFile=new File(System.getProperty("user.dir") + "//Screenshots//" + tname + ".png");

        //Copy file at destination

         FileUtils.copyFile(SrcFile, DestFile);
         
         System.out.println("ScreenShot Taken");
	}
	
}
