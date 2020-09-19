package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.Base.TestBase;

public class ContactsPage extends TestBase{

	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement ContactsLabel;
	
	@FindBy(name="title")
	WebElement newcontactTitle;
	
	@FindBy(id="first_name")
	WebElement FirstName;
	
	@FindBy(id="surname")
	WebElement surName;
	
	@FindBy(name="client_lookup")
	WebElement CompanyName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement Savebttn;
	
	//initializing the object//
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);	
	}
	
	public boolean CheckcontactslabelTest(){
		return ContactsLabel.isDisplayed();

	}
	
	
	public String Checkspecificbox(String val){
		driver.findElement(By.xpath("//a[contains(text(),'"+val+"')]//preceding::input[1]")).click();
		return val;
		
	}
	
	
	public void createnewcontact(String title,String fname, String surname,String company){
		Select select=new Select(newcontactTitle);
		select.selectByVisibleText(title);
		FirstName.sendKeys(fname);
		surName.sendKeys(surname);
		CompanyName.sendKeys(company);
		Savebttn.click();
	}
	
	
}
