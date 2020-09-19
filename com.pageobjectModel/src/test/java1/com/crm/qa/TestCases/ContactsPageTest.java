package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.DataproviderUtil;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactpage;
	String sheetname="Contacts";
	
	public ContactsPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setup(){
	initialise();
	testutil=new TestUtil();
	contactpage=new ContactsPage(); 
	loginpage=new LoginPage(); 
	homepage=loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	testutil.iframecapture();
	contactpage=homepage.verifycontacttest();
	}
	
	@Test(priority=1)
	public void checkcontactsLabel(){
		Assert.assertTrue(contactpage.CheckcontactslabelTest(), "Contact label is missing");
	}
	
	
	@Test(priority=2)
	public void checkanycontactsCheckboxTest(){
		contactpage.Checkspecificbox("Abraham Sarai");
		TakeScreenshots();
	}
	
	
	@Test(priority=3,dataProvider="getCRmtestdata")
	public void checkNewcontactsTest(String Title,String FirstName,String surName,String Company){
		homepage.clickonNewContact();
		//contactpage.createnewcontact("Title","Riya","Bhat","TCS");
		contactpage.createnewcontact(Title, FirstName, surName, Company);
		TakeScreenshots();
	}

	@DataProvider
	public Object[][] getCRmtestdata(){
		Object[][] data=DataproviderUtil.getTestData("Contacts");
		return data;
	
	}
	
	

	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	
	
	
	
	
	

}
