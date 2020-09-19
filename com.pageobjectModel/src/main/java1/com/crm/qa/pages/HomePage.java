package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

public class HomePage extends TestBase{
	
	
	@FindBy(xpath="//td[contains(text(),'Demo User')]")
	WebElement userlogininfo;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement checkcontact;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContact;
	
	@FindBy(xpath="//td[contains(text(),'Name')]")
	WebElement contactname;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement checkDeals;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement checkTasks;
	
	
	
	//initial the page objects by creating a constructor

	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	public String verifyhomepagetitle(){
		return driver.getTitle();
	}
	
	public String verifyuserloggedin(){
		return userlogininfo.getText();
	
	}
	
	public ContactsPage verifycontacttest(){
		checkcontact.click();
		Boolean val=contactname.isDisplayed();
		System.out.println("is displayed");
		
		return new ContactsPage();
	}
	
	public DealPage verifyDealtest(){
		checkcontact.click();
		return new DealPage();
	}
	
	public void clickonNewContact(){
		
		Actions Act=new Actions(driver);
		Act.moveToElement(checkcontact).build().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		NewContact.click();
	}
	
	
	
}
