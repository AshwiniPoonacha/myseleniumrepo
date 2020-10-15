package com.Hybrid.POM.qa.POMtestcases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Hybrid.POM.qa.Pages.HomePage;
import com.Hybrid.POM.qa.Pages.LoginPage;
import com.Hybrid.POM.qa.TestBase.TestBase;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage  homePage;
	
	public LoginPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setup() throws MalformedURLException{
		openBrowser("Chrome");
		navigate("url");
		loginpage=new LoginPage();
		
	}
	
	@Test
	public void VerifyLogintotheapp(){
	homePage=loginpage.Logintoapplication("Username", "Password");
		
	}
	

	@AfterMethod
	public void teardown(){
		driver.quit();
		
	}
	


}
