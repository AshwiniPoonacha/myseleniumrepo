package com.Hybrid.POM.qa.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	public static Properties Props=null;
	public static WebDriver driver=null;
	 ExtentTest test=null;
	ExtentReports extent=null;
	Logger log=Logger.getLogger(TestBase.class);	
	
	public TestBase(){
		String path=System.getProperty("user.dir")+"\\src\\main\\resources\\Prop.properties";
			try {
				Props=new Properties();
				FileInputStream file=new FileInputStream(path);
				Props.load(file);
				System.out.println(Props.get("env"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	
	  public void openBrowser(String Browser) throws MalformedURLException{
		 if(Browser.equals("Chrome")){
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\91990\\Music\\Softwares\\Webdrivers\\chromedriver.exe");
			 ChromeOptions options=new ChromeOptions();
			 log.info("Logging in with chrome");
			 options.addArguments("--disable-notifications");
			 driver=new ChromeDriver(options);
			//Define desrired capabilities//
				//DesiredCapabilities cap=new DesiredCapabilities();
				//cap.setBrowserName("Chrome");
				//cap.setPlatform(Platform.WIN10);
				
				//Chromeoptions//
				//ChromeOptions options=new ChromeOptions();
				//options.merge(cap);

				
				//String huburl="http://192.168.0.105:4444/wd/hub";
				//WebDriver driver=new RemoteWebDriver(new URL(huburl),options);
				
		 }
		 else if(Browser.equals("Mozilla")){
			 //FirefoxProfile profile=new FirefoxProfile();
			 FirefoxOptions options=new FirefoxOptions();
			 ProfilesIni ini=new ProfilesIni();
			 FirefoxProfile profileset=ini.getProfile("Selenium");
			 options.setProfile(profileset);
			 profileset.setPreference("dom.webnotifications.enabled", false);
			 profileset.setAcceptUntrustedCertificates(true);
			 profileset.setAssumeUntrustedCertificateIssuer(false);
			 driver=new FirefoxDriver(options);
			
	
			 
			 
		 }
		 else if(Browser.equals("IE")){
			 driver=new InternetExplorerDriver();
		 
		 }
		 
		 //Wait implicitly//
		 driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
				
	}
	
	 public void navigate(String url){
		 driver.get(Props.getProperty(url));
		 log.info("Navigated to url successfully ");
	 	}

	 
	 public void click(String clickpath){
		 driver.findElement(By.xpath(Props.getProperty(clickpath))).click();
			
		}
	 
	 public void type(String xpath,String value){
		 driver.findElement(By.xpath(Props.getProperty(xpath))).sendKeys(Props.getProperty(value));
			
		}
	 
	 public void typedataP(String xpath,String value){
		 driver.findElement(By.xpath(Props.getProperty(xpath))).sendKeys(value);
			
		}
	 
	 
	 public void Dropdown(String dropxpath,String dropval){
		 
		 Select s=new Select(driver.findElement(By.xpath(dropxpath)));
		 //List<WebElement> listopy= s.getOptions();
		//System.out.println(listopy);
		 s.selectByValue(dropval); 
	 }
	
	//**********************validations*************************//
	
	 public boolean verifytitle(){
		return false;
			
		}
	
	 public boolean isElementpresent(String expath){
		 boolean element=driver.findElement(By.xpath(Props.getProperty(expath))).isDisplayed();
		 if(element=false){
		 boolean element1=driver.findElement(By.cssSelector(Props.getProperty(expath))).isDisplayed();
		 }
		 
		 
		 if(element==true)
			 return true;
		 else 
		
			return false;	
			}
	 
	 
	 
	 
	 	public boolean verifytext(String Actual,String expected){
	 		String Actualtext =driver.findElement(By.xpath(Props.getProperty(Actual))).getText();
	 		String expectedtxt=Props.getProperty(expected);
	 		System.out.println(Actualtext);
	 		System.out.println(expectedtxt);
	 		if(Actualtext==expectedtxt)
	 			return true;
	 		else
			   return false;
	 		
			}
	 	
	 	
	 	public void verifyDropdown(String option){
	 		Select s=new Select(driver.findElement(By.xpath("//*[@id='Accounts_fldRow_ACCOUNTTYPE']/div[2]/div/span/span[1]/span")));
	 		s.selectByValue(option);
	 	}
	 	
	 	
	 	public void VerifyCheckbox(String Leadxpath1,Object name,String Leadxpath2){

	 		driver.findElement(By.xpath(Props.getProperty(Leadxpath1)+name+Props.getProperty(Leadxpath2))).click();
	
	 	}
	 	
	 	
	 	
	 	public String gettext(String expath){
	 		String text=driver.findElement(By.xpath(Props.getProperty(expath))).getText();
	 		//System.out.println(text);
			return text;

	 	}
	 	
	 	public void selectdate(String date){
	 		
	 		//convert string date to date object//
	 		
	 		SimpleDateFormat sdf=new SimpleDateFormat("d/MM/yyyy");
	 		try {
				Date datetobe=sdf.parse(Props.getProperty(date));
				Date currentdate=new Date();
				
				sdf=new SimpleDateFormat("MMMM");
				String Monthtobe=sdf.format(datetobe);
				sdf=new SimpleDateFormat("yyyy");
				String Yeartobe=sdf.format(datetobe);
				sdf=new SimpleDateFormat("d");
				String datetob=sdf.format(datetobe);
				
				String MonthYeartobe=Monthtobe+" "+Yeartobe;
				
				while(true){

					if(currentdate.compareTo(datetobe)==1){
						click("Backbutton_xpath");
					}else if(currentdate.compareTo(datetobe)==-1){
						click("Frontbutton_xpath");
					}
					if(MonthYeartobe.equals(gettext("Monthyeardisplayed_xpath"))){
						break;
					}
					
				}
				driver.findElement(By.xpath("//tr/td[text()='"+datetob+"']")).click();
				
			} catch (ParseException e) {
				e.printStackTrace();
			}

	 	}
	//**********************Wait*************************//
	 	
	 	public boolean waitforelementexplicit(String path){
	 		
	 		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2000));
	 		try{
	 		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
	 		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
	 		}catch(Exception e){
	 			e.printStackTrace();
	 		}
	 		return false;
	 	}
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	//**********************Reporting*************************//

	 public void reportpass(String Passmsg){
		 test.log(LogStatus.PASS, "Test Passed");
		 System.out.println("Passed successfully");
	 }
	 
	 public void reportfail(String failmsg){
		 test.log(LogStatus.FAIL, failmsg);
		 TakeScreenshots();
		 Assert.fail(failmsg);
		 
	 }
	 
	 public void TakeScreenshots(){
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			Date d=new Date();
			String ScFileName=d.toString().replace(":", "-").replace(" ", "-")+".png";
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(SrcFile, new File("C:\\Users\\91990\\Music\\Selenium\\com.Hybrid.POM.qa.Testing\\Screenshots"+ScFileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//test.log(LogStatus.INFO, "Screenshots-->"+test.addScreenCapture("C:\\Users\\91990\\Music\\Selenium\\com.Hybrid.POM.qa.Testing\\Screenshots"+ScFileName));
		}
			
	 
}
