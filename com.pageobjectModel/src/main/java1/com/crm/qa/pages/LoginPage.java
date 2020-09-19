package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

public class LoginPage extends TestBase {
	
	
	//Setup page factory::
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id='loginForm']/div/div/input")
	WebElement Loginbttn;
	
	@FindBy(xpath="//*[@class='img-responsive']")
	WebElement CRMLogo;
	
	
	//initialize the page object//
	public LoginPage(){
	PageFactory.initElements(driver, this);
	}
	
	
	//Actions//
	
	
	public String validatepagetitle(){
		return driver.getTitle();
	}

	public boolean crmimg(){
		return CRMLogo.isDisplayed();
	}
	
	public HomePage login(String userN,String passWd){
		username.sendKeys(userN);
		password.sendKeys(passWd);
		Loginbttn.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return new HomePage();
	}

}
