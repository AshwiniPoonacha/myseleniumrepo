package com.crm.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.qa.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public static TestUtil testutil;
	
	@Test
	public TestBase(){
				try {
					prop=new Properties();
					String path=System.getProperty("user.dir")+"\\src\\main\\java1\\com\\crm\\qa\\config\\Prop.properties";
					FileInputStream fl= new FileInputStream(path);
					System.out.println(path);
					
					try {
						prop.load(fl);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	
	
	public static void initialise(){
		String Browsername=prop.getProperty("Browser");
		System.out.println(Browsername);
		if(Browsername.equals("Chrome")){
			driver=new ChromeDriver();
		}else if(Browsername.equals("Mozilla")){
			driver=new FirefoxDriver();
	}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

}
	
	
	/********************Screenshots****************************/
	public void TakeScreenshots(){
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		Date d=new Date();
		String ScFileName=d.toString().replace(":", "-").replace(" ", "-")+".png";
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(SrcFile, new File(System.getProperty("user.dir")+"//Screenshots"+ScFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Test.log(LogStatus.INFO, "Screenshots-->"+Test.addScreenCapture(System.getProperty("user.dir")+"//Screenshots"+ScFileName));
		
	
	}
}