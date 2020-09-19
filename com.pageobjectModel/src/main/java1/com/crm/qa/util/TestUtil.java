package com.crm.qa.util;

import com.crm.qa.Base.TestBase;

public class TestUtil extends TestBase {
	
	
	
	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT=10;
	
	
	
	public void iframecapture(){
		driver.switchTo().frame("mainpanel");	
	}

}
