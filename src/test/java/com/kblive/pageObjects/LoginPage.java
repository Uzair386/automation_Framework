package com.kblive.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver local_driver;
	
	//this is the constructor we created
	//r driver means remote driver
	public LoginPage(WebDriver rdriver)
	{
		local_driver = rdriver;
		//page factory class setup
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="basic_username")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(id="basic_password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//span[contains(text(),'Login')]")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(css = "body.ant-scrolling-effect:nth-child(2) div.ant-modal-root div.ant-modal-wrap.ant-modal-centered div.ant-modal.modal-generic.modal-700 div.ant-modal-content:nth-child(2) div.ant-modal-body div.select-role-list div.ant-radio-group.ant-radio-group-outline.ant-radio-group-large > label.ant-radio-button-wrapper:nth-child(1)\"))\r\n")
	@CacheLookup
	WebElement modalUserRole;
	
	public void setUserName(String uname) {
		txtUsername.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	
	public void modalUserRole() {
		modalUserRole.isDisplayed();
	}
}
 