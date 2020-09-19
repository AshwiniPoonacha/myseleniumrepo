package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest(){ 
		super();
	}
	
	
	@BeforeMethod
	public void setup(){
		initialise();
		loginpage=new LoginPage();
	}
	
	
	@Test(priority=1)
	public void pagetitletest(){
		String title=loginpage.validatepagetitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	
	@Test(priority=2)
	public void CRMlogoimgtest(){
		boolean yn=loginpage.crmimg();
		Assert.assertEquals(true, yn);
		
	}
	
	@Test(priority=3)
	public void logintest(){
		homepage=loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	

}
