package com.Hybrid.POM.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Hybrid.POM.qa.TestBase.TestBase;

public class LoginPage extends TestBase {
	

	
		
	@FindBy(xpath="//input[@id='login_id']")
	WebElement Email;
		
	@FindBy(xpath="//button[@id='nextbtn']")
	WebElement nextbutton;	
		
	@FindBy(xpath="//input[@id='password']")
	WebElement password;	
	
	@FindBy(xpath="//button[@id='nextbtn']")
	WebElement signupbttn;
	
	
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	

	public HomePage Logintoapplication(String uname,String Password){
		//Login.click();
		Email.sendKeys(Props.getProperty(uname));
		nextbutton.click();
		password.sendKeys(Props.getProperty(Password));
		signupbttn.click();
	
		return new HomePage();
		
		
	}
	
	
	
}
