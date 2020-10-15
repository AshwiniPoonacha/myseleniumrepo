package com.Hybrid.POM.qa.TestSuite;

import java.net.MalformedURLException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Hybrid.POM.qa.TestBase.TestBase;
import com.Hybrid.POM.qa.Util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Javascriptexecutor_Actions extends TestBase {

	ExtentTest test=null;
	ExtentReports extent=null;
	SoftAssert softAssert;
	
	public Javascriptexecutor_Actions(){
		super();
		
	}
	
	@BeforeMethod
	public void initialize(){
		//Reporting//
		extent=ExtentManager.getInstance();
		test=extent.startTest("LoginTest", "Login to the application");
		
	}
	
	
	@Test
	public void verifyAccountcreation() throws InterruptedException, MalformedURLException{
	
		test.log(LogStatus.INFO, "Starting the Login Test");
		openBrowser("Mozilla");
		test.log(LogStatus.INFO, "Browser opened successfully");
		navigate("url");
		//type("email_xpath","Username");
		//click("nextbttn_xpath");
		//type("password_xpath","Password");
		//click("signupbttn_xpath");
		test.log(LogStatus.INFO, "Logged into ZOho  successfully");
		driver.findElement(By.xpath("//a[@id='157333000000156062']")).click();
		
		//WebElement path=driver.findElement(By.xpath("//a[@id='157333000000156062']"));
		
		waitforelementexplicit("Scrollpath");
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Customize Home page']"))).click().build().perform();
		

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		driver.findElement(By.xpath("//div[text()='Closing This Month']")).getText();

	

}
}