package com.Hybrid.POM.qa.TestSuite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.fluent.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Hybrid.POM.qa.TestBase.TestBase;
import com.Hybrid.POM.qa.Util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.http.client.fluent.Request;

public class LoginTest extends TestBase {
	ExtentTest test=null;
	ExtentReports extent=null;
	SoftAssert softAssert;
	

	public LoginTest(){
		super();
		
	}
	
	@BeforeMethod
	public void initialize(){
		//Reporting//
		extent=ExtentManager.getInstance();
		test=extent.startTest("LoginTest", "Login to the application");
		
	}
	
	
	@Test
	public void login() throws InterruptedException, MalformedURLException{
		softAssert=new SoftAssert();
		test.log(LogStatus.INFO, "Starting the Login Test");
		openBrowser("Mozilla");
		test.log(LogStatus.INFO, "Browser opened successfully");
		navigate("url1");
		//type("email_xpath","Username");
		//click("nextbttn_xpath");
		//type("password_xpath","Password");
		//click("signupbttn_xpath");
		//test.log(LogStatus.INFO, "Logged into ZOho  successfully");
		//test.log(LogStatus.FAIL, "Screenshot="+test.addScreenCapture("C:\\Users\\91990\\Music\\Screenshots"));
		//Thread.sleep(40);
		
		//isElementpresent("CRMlogo_xpath");
		//softAssert.assertTrue(true, "Element is not present");
		
		//verifytext("Llogintext_xpath","Expectedtext");
		//softAssert.assertTrue(true, "Text mismatch");
		
		
		List<WebElement> list =driver.findElements(By.tagName("a"));
	
		List<WebElement> list1 =driver.findElements(By.tagName("img"));
		
		
		list.addAll(list1);
		System.out.println("Links All"+list.size());
		
		
		List<WebElement> Activelinks=new ArrayList<WebElement>();
		for(int i=0;i<list.size();i++){
			//System.out.println(list.get(i).getText());
			if(list.get(i).getAttribute("href")!= null){
				Activelinks.add(list.get(i));
				System.out.println(Activelinks.get(i).getAttribute("href"));
				String url=Activelinks.get(i).getAttribute("href");
				
				int response=0;
				try {
					response=Request.Get(url).execute().returnResponse().getStatusLine().getStatusCode();
					System.out.println("Response code for URL"+url+"is -->" +response);
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}
			}
		}
		
		
		System.out.println("Links Active"+Activelinks.size());
		
		
		
	}
	
	
	@AfterMethod
	public void teardown(){
		softAssert.assertAll();
		extent.endTest(test);
		extent.flush();
		driver.quit();
		
	
	}
	
}
