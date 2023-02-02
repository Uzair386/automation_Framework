
package com.kblive.testCases;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kblive.pageObjects.LoginPage;
import com.kblive.utilities.XLUtils;

import java.io.IOException;



public class TC_LoginTest_002 extends BaseClass {
//when ever you create a new test case we must extend the base class
//because base class contain a common variable like setup and tear down method

	 
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd ) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided: "+user);
		lp.setPassword(pwd);
		logger.info("password provided: "+pwd);
		Thread.sleep(2000);
		lp.clickSubmit();
		
		Thread.sleep(5000);
		
		if(isAlertPresent()==true) {
			 driver.switchTo().alert().accept();
			 driver.switchTo().defaultContent();
			 Assert.assertTrue(false);
			 logger.warn("Login Failed");
		}else {
			Assert.assertTrue(true);
		}
		
	}
	
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	//data provider method
	@DataProvider(name = "LoginData")
	String [][] getData() throws IOException{
		String path = System.getProperty("user.dir") + "/src/test/java/com/kblive/testData/loginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String [rownum][colcount];
		
		for(int i=1; i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return logindata;
	}

}
