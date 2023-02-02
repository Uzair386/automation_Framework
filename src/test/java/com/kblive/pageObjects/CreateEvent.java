package com.kblive.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	
public class CreateEvent {
		
		WebDriver local_driver;
		
		//this is the constructor we created
		//r driver means remote driver
		public CreateEvent(WebDriver rdriver)
		{
			local_driver = rdriver;
			//page factory class setup
			PageFactory.initElements(rdriver, this);
		}

		
		
	
		
		
		@FindBy(css = "body.ant-scrolling-effect:nth-child(2) div.ant-modal-root div.ant-modal-wrap.ant-modal-centered div.ant-modal.modal-generic.modal-700 div.ant-modal-content:nth-child(2) div.ant-modal-body div.select-role-list div.ant-radio-group.ant-radio-group-outline.ant-radio-group-large > label.ant-radio-button-wrapper:nth-child(1)")
		@CacheLookup
		WebElement modalUserRole;
		
		@FindBy(css="body.ant-scrolling-effect:nth-child(2) div.ant-modal-root div.ant-modal-wrap.ant-modal-centered div.ant-modal.modal-generic.modal-700 div.ant-modal-content:nth-child(2) div.ant-modal-body div.select-role-list div.ant-radio-group.ant-radio-group-outline.ant-radio-group-large > label.ant-radio-button-wrapper:nth-child(1)")
		@CacheLookup
		WebElement onClickmodalbtn;
	
		@FindBy(xpath="//span[contains(text(),'Create Event')]")
		@CacheLookup
		WebElement onClickEventBtn;
		
		@FindBy(id="title")
		@CacheLookup
		WebElement setTitle;
		
		@FindBy(id="category_id")
		@CacheLookup
		WebElement setCategory;
		
		@FindBy(id="notes")
		@CacheLookup
		WebElement setDetail;
		
		@FindBy(id="datetime")
		
		WebElement setDateTime;
		
		@FindBy(xpath="//span[contains(text(),'OK')]")
	
		WebElement onClick_OkBtnDateTime;

		@FindBy(id="react-select-2-input")
		@CacheLookup
		WebElement setPrimaryHost;
		
		@FindBy(id="react-select-3-input")
		@CacheLookup
		WebElement setHost2;
		
		@FindBy(id="react-select-4-input")
		@CacheLookup
		WebElement setHost3;
		
		@FindBy(id="react-select-5-input")
		@CacheLookup
		WebElement setHost4;
		
		
		@FindBy(xpath="//body/div[@id='root']/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[2]")
		@CacheLookup
		WebElement onClickNextBtn1;
		
		@FindBy(xpath="//span[contains(text(),'Use a sample image')]")
		@CacheLookup
		WebElement onClickBanner;
		
		@FindBy(id="thankyou_message")
		@CacheLookup
		WebElement setthankYou_msg;
		
		
		@FindBy(xpath="//span[contains(text(),'Next')]")
		@CacheLookup
		WebElement onClickNextBtn2;
		
		
		@FindBy(id="react-select-6-input")
		@CacheLookup
		WebElement productSKU;
		
		@FindBy(xpath="//span[contains(text(),'Create Event')]")
		@CacheLookup
		WebElement onClickCreateEventBtn;
		
		@FindBy(xpath="//span[contains(text(),'Go to Event')]")
		@CacheLookup
		WebElement CreateEventModalText;
		
		@FindBy(xpath="//body/div[5]/div[1]/div[2]/div[1]/div[2]/div[2]/button[1]")
		@CacheLookup
		WebElement onCLickGoToEventBtn;
		

		
		
		public boolean modalUserRole() {
			return modalUserRole.isDisplayed();
		}
		
		public void onClickmodalbtn() {
			onClickmodalbtn.click();
		}
		
		public boolean displayEventBtn() {
			return onClickEventBtn.isDisplayed();	
		}
		
		public void onClickEventBtn() {
			onClickEventBtn.click();
			
		}
		
		public void setTitle(String eventTitle) {
			setTitle.sendKeys(eventTitle);
		}
		
		public void setCategory(String category) throws InterruptedException {
			setCategory.sendKeys(category);	
			Thread.sleep(2000);
			setCategory.sendKeys(Keys.DOWN);
			Thread.sleep(2000);
			setCategory.sendKeys(Keys.ENTER);
			Thread.sleep(2000);	
		}
		
		
		public void setDetail(String details) {
			setDetail.sendKeys(details);	
		}
		
		public void setDateTime(String date) throws InterruptedException {
			Thread.sleep(2000);
			setDateTime.sendKeys(date);		
			Thread.sleep(2000);
			Thread.sleep(2000);
		}
		
		public String datePicker() {
			String datePicker =  setDateTime.getAttribute("value");	
			System.out.println("datePicker"+datePicker);
			return datePicker;
		}
		
		
		//test
		public boolean date1() {
			boolean noDatePresent = setDateTime.getText().isEmpty();
			return noDatePresent;
		}
		
		public void onClick_OkBtnDateTime() {
			onClick_OkBtnDateTime.click();
		}
		
		public void setPrimaryHost(String prim_host) throws InterruptedException {
			setPrimaryHost.sendKeys(prim_host);
			Thread.sleep(3000);
			setPrimaryHost.sendKeys(Keys.ENTER);
		}
		
		public void setHost2(String host2) throws InterruptedException {
			setHost2.sendKeys(host2);	
			Thread.sleep(2000);
			setHost2.sendKeys(Keys.ENTER);
		}
		
		public void setHost3(String host3) throws InterruptedException {
			setHost3.sendKeys(host3);
			Thread.sleep(2000);
			setHost3.sendKeys(Keys.ENTER);
			
		}
		
		public void setHost4(String host4) throws InterruptedException {
			setHost4.sendKeys(host4);
			Thread.sleep(2000);
			setHost4.sendKeys(Keys.ENTER);
		}
		
		public void onClickNextBtn1() {
			onClickNextBtn1.click();
		}
		
		public void onClickBanner() {
			onClickBanner.click();
		}
		
		public void setthankYou_msg(String tkMsg) {
			setthankYou_msg.sendKeys(tkMsg);
		}
		
		public void onClickNextBtn2() {
			onClickNextBtn2.click();
		}
		
		public void productSKU(String p_Sku) {
			productSKU.sendKeys(p_Sku);
		}
		
		public void onClickCreateEventBtn() {
			onClickCreateEventBtn.click();
		}
		
		//yahan check krna h kis trha sai text lekr uper send krna
		public String CreateEventModalText() {
			String text = CreateEventModalText.getText();
			return text;
		}
		
		public void onCLickGoToEventBtn() {
			onCLickGoToEventBtn.click();
		}

	
		
	
	}
	 

