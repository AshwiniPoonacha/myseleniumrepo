package com.Hybrid.POM.qa.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Hybrid.POM.qa.TestBase.TestBase;

public class HomePage extends TestBase{
	
	
	@FindBy(css="span#show-uName")
	WebElement Pagetitle;
	
	@FindBy(css="a.customhome-icon.homeLink.ellipsistext.pR.sel")
	WebElement MyHome;
	
	@FindBy(css=".classichome-icon.homeLink.ellipsistext.pR")
	WebElement classicview;

	
	@FindBy(css=".newtable.w100per>tbody>tr>td:nth-child(3)>link-to>a")
	List<WebElement> Subject;
	
	
	public HomePage(){
		PageFactory.initElements(driver, HomePage.class);
	
	}
	
	
	public String verifypagetitle(){
		String Actual=Pagetitle.getText();
		return Actual;
	
	}
	
	
	public void verifyclickoptions(){
		MyHome.click();
		classicview.click();
	}
	
	/*public ActivitiesPage verifysubjectpresent(String subject){
		System.out.println(Subject.size());
		for(int i=0;i<Subject.size();i++){
			String s=Subject.get(i).getText();
			if(s.equals(subject)){
				Subject.get(i).click();
			}
		}
		return new ActivitiesPage();
		
	}*/
	

}
