package com.Hybrid.POM.qa.TestSuite;

import java.net.MalformedURLException;
import java.util.Hashtable;

import org.openqa.selenium.By;
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

public class ConvertLead extends TestBase{
	
	
	ExtentTest test=null;
	ExtentReports extent=null;
	SoftAssert softAssert;
	
	public ConvertLead(){
		super();
		
	}
	
	@BeforeMethod
	public void initialize(){
		//Reporting//
		extent=ExtentManager.getInstance();
		test=extent.startTest("Convertlead", "create Task");
		
	}
	
	
	@Test(dataProvider="getdata")
	public void verifyconvertlead(Hashtable data) throws InterruptedException, MalformedURLException{
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
		click("Leadtab_xpath");
		Thread.sleep(200);
		VerifyCheckbox("Leadcheckbox1_xpath",data.get("Name"),"Leadcheckbox2_xpath");
		test.log(LogStatus.INFO, "Lead clicked successfully");
		test.log(LogStatus.INFO, "Screenshots-->"+test.addScreenCapture("C:\\Users\\91990\\Music\\Selenium\\com.Hybrid.POM.qa.Testing\\Screenshots"));
		Thread.sleep(2000);
		click("CreateTask_xpath");
		
		verifytext("CreateTasklogo_xpath","CreateTaskexpected_xpath");
		softAssert.assertEquals(true, false,"Value mismatch");
		
		//click("calender_xpath");
		//String text=driver.findElement(By.xpath("//*[@id='calenDiv']/div/div[1]/div/span[3]")).getText();
 		//System.out.println(text);
		type("TaskSubject_xpath","TaskSubjectval");
		test.log(LogStatus.INFO, "create task clicked successfully");
		click("calender_xpath");
		Thread.sleep(200);
		selectdate("Datetobeselected");
		test.log(LogStatus.INFO, "date clicked successfully");
		TakeScreenshots();
		click("Repeatswitch_xpath");
		click("donebutton_xpath");
		click("savebtnn_xpath");
		test.log(LogStatus.INFO, "created task successfully");
		TakeScreenshots();
		//reportpass("Validate report pass");

	}
	

	@DataProvider
	public Object[][] getdata(){
	Object data[][]=new DataProviderUtil().dataproviderutility("Names");
	return data;	
		
	}
	
	
	
	
	@AfterMethod
	public void teardown(){
		try{
			softAssert.assertAll();
		}catch(Error e1){
			test.log(LogStatus.FAIL, e1.getMessage());
		}
		extent.endTest(test);
		extent.flush();
		
		if(driver!=null)
		driver.quit();
	 
		}
	
	

}
