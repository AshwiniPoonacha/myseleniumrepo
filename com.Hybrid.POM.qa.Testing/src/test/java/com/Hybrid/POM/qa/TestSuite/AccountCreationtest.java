package com.Hybrid.POM.qa.TestSuite;

import java.net.MalformedURLException;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Hybrid.POM.qa.TestBase.TestBase;
import com.Hybrid.POM.qa.Util.DataProviderUtil;
import com.Hybrid.POM.qa.Util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AccountCreationtest extends TestBase{
	ExtentTest test=null;
	ExtentReports extent=null;
	SoftAssert softAssert;
	
	public AccountCreationtest(){
		super();
		
	}
	
	@BeforeMethod
	public void initialize(){
		//Reporting//
		extent=ExtentManager.getInstance();
		test=extent.startTest("LoginTest", "Login to the application");
		
	}
	
	
	@Test(dataProvider="getdata")
	public void verifyAccountcreation(String AccountName ,String ParentAccount ,String AccountType) throws InterruptedException, MalformedURLException{
		softAssert=new SoftAssert();
		test.log(LogStatus.INFO, "Starting the Login Test");
		openBrowser("Chrome");
		test.log(LogStatus.INFO, "Browser opened successfully");
		navigate("url");
		type("email_xpath","Username");
		click("nextbttn_xpath");
		type("password_xpath","Password");
		click("signupbttn_xpath");
		test.log(LogStatus.INFO, "Logged into ZOho  successfully");
		
		click("Account_xpath");
		click("AddAccount_xpath");
		typedataP("AddAccountName_xpath",AccountName);
		click("AddParentAccount_xpath");
		typedataP("PopupParentsearch_xpath",ParentAccount);
		Thread.sleep(300);
		click("PopupclickonParent_xpath");
		//click("AccountClick");
		//Dropdown("AccounttypeDropdown_xpath",AccountType);
		type("AccountClick","Accountvalue");
		Thread.sleep(3000);
		click("Savebutton_xpath");
		TakeScreenshots();
		test.log(LogStatus.INFO, "Account created successfully");
		TakeScreenshots();
	}
	
	
	@DataProvider
	public Object[][] getdata(){
		Object data[][]=new DataProviderUtil().dataproviderutility("Data");
		return data;
	}
	
	
	@AfterMethod
	public void teardown(){
		softAssert.assertAll();
		extent.endTest(test);
		extent.flush();
		driver.quit();
	
	}
	

}
