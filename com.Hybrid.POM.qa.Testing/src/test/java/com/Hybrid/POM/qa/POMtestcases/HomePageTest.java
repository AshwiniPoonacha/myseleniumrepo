package com.Hybrid.POM.qa.POMtestcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Hybrid.POM.qa.Pages.ActivitiesPage;
import com.Hybrid.POM.qa.Pages.HomePage;
import com.Hybrid.POM.qa.Pages.LoginPage;
import com.Hybrid.POM.qa.TestBase.TestBase;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage  homePage;
	ActivitiesPage activitiespage;
	
	public HomePageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setup() throws MalformedURLException{
		openBrowser("Chrome");
		navigate("url");
		loginpage=new LoginPage();
		homePage=loginpage.Logintoapplication("Username", "Password");
	}
	
	/*@Test
	public void VerifytileTest(){
		String text=homePage.verifypagetitle();
		Assert.assertEquals(text, "Expected_val");
	}*/
	
	@Test
	public void verifyclickoptionsTest(){
		homePage.verifyclickoptions();
	}
	
	/*@Test
	public void verifysubjectpresentTest(){
		activitiespage=homePage.verifysubjectpresent("test");
	}*/
	

	@AfterMethod
	public void teardown(){
		driver.quit();
		
	}
	
	
	
	
	
	
	

}
