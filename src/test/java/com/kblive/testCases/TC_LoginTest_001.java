package com.kblive.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.kblive.pageObjects.CreateEvent;
import com.kblive.pageObjects.LoginPage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class TC_LoginTest_001 extends BaseClass {
//when ever you create a new test case we must extend the base class
//because base class contain a common variable like setup and tear down method

	 
	@Test
	public void loginTest() throws IOException, InterruptedException {
		
		driver.get(baseURL);	
		logger.info("URL is Opened");
		
		LoginPage lp = new LoginPage(driver);
		CreateEvent ce = new CreateEvent(driver);
		
		lp.setUserName(username);
		logger.info("Entered Username" + username);
		
		lp.setPassword(password);
		logger.info("Entered Password: " + password);
		
		lp.clickSubmit();
		
		if(driver.getCurrentUrl().equals("https://www.kblive.com/home")) {
			Assert.assertTrue(true);
			logger.info("Login Succesfully");
		}else {
			
			captureScreen(driver, "loginTest");
			
			Assert.assertTrue(false);

			logger.info("Login Failed");
		}
		
		
	}
}
