package com.kblive.testCases;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

import com.kblive.pageObjects.CreateEvent;
import com.kblive.pageObjects.LoginPage;

public class TC_CreateEvent_003 extends BaseClass {
	
	@Test
	public void createEvent() throws IOException, InterruptedException {
		driver.get(baseURL);	
		logger.info("URL is Opened");
		LoginPage lp = new LoginPage(driver);
		CreateEvent ce = new CreateEvent(driver);
		lp.setUserName(username);
		logger.info("Entered Username" + username);
        Thread.sleep(2000);
        Thread.sleep(2000);
		lp.setPassword(password);
		logger.info("Entered Password: " + password);
        Thread.sleep(2000);
        Thread.sleep(2000);
        lp.clickSubmit();
		Thread.sleep(2000);
		Thread.sleep(2000);
		Thread.sleep(2000);
		boolean modalUserRole =	ce.modalUserRole();
        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
		if(modalUserRole == true) {
			ce.onClickmodalbtn();
			logger.info("Admin option is selected from modal");	
			boolean displayEventBtn = ce.displayEventBtn();
			if(displayEventBtn==true){
				logger.info("Create Event Button is display");
				ce.onClickCreateEventBtn();	
				String createEventActualUrl = driver.getCurrentUrl();
				 if (createEventActualUrl.equals(createEventExpectedUrl)) {
					 logger.info("Create Event Button is clicked >> Expected Url Matched");
					 Thread.sleep(2000);
					 ce.setTitle(eventTitle);
					 Thread.sleep(2000);
					 ce.setCategory(catgeory);
					 Thread.sleep(2000);
					 ce.setDetail(details);
					 
					 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
				     LocalDateTime now= LocalDateTime.now().plusHours(1).plusMinutes(30);
				     logger.info("New Date" + dtf.format(now)); 
				    
					 ce.setDateTime(dtf.format(now));
					 Thread.sleep(3000);
					  					   
					 ce.setPrimaryHost(primaryHost);
					 
					 if(ce.date1() == true) {
						   logger.info("Date Field is not Filled ----> again enter date" + ce.date1());
						   ce.setDateTime(dtf.format(now));
						   ce.onClick_OkBtnDateTime();
					   }else {
						   logger.info("Date Field is Filled");
					   }
					 ce.setHost2(host2);
					 ce.setHost3(host3);
					 ce.setHost4(host4);
					 ce.onClickNextBtn2();
					 					 
				 }else {
					 logger.info("Create Event Button is not clicked");
				 }
			}else {
			logger.info("Create Event Button is not display");	
			}		
		}else {
			logger.info("Admin option is not selected from modal");
		}

	}
}
