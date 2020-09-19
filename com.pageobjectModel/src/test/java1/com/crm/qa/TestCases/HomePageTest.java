package com.crm.qa.TestCases;

	import org.testng.Assert;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
	import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

	public class HomePageTest extends TestBase{
		
		LoginPage loginpage;
		HomePage homepage;
		TestUtil testutil;
		ContactsPage contactpage;
		
		public HomePageTest(){
			super();
		}
		
		@BeforeMethod
		public void setup(){
		initialise();
		testutil=new TestUtil();
		contactpage=new ContactsPage(); 
		loginpage=new LoginPage(); 
		homepage=loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		
		}
		
		@Test(priority=1)
		public void verifyHomepagetitletest(){
		String title=homepage.verifyhomepagetitle();
			Assert.assertEquals(title, "CRMPRO","Homepage title not correct");
		}
		
		
		@Test(priority=2)
		public void verifyLoggedinusertest(){
			testutil.iframecapture();
			String logintext=homepage.verifyuserloggedin();
			Assert.assertEquals(logintext, "  User: Demo User");
		}
		
		
		
		@Test(priority=3)
		public void verifycontactsnavigationtest(){
			testutil.iframecapture();
			contactpage=homepage.verifycontacttest();
	
			
		}


		@AfterMethod
		public void teardown(){
			driver.quit();
		}
		


}
