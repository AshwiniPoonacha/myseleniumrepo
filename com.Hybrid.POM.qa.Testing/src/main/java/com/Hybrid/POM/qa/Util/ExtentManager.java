package com.Hybrid.POM.qa.Util;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;

import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class ExtentManager {
	public static ExtentReports extent;
	public static ExtentTest Test;

	public static  ExtentReports getInstance() {
		//List<XmlSuite> xmlSuites, List<ISuite> suites,String outputDirectory//
		if (extent == null) {
			Date d=new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			extent = new ExtentReports("C:\\Users\\91990\\Music\\Reports\\Reports"+fileName, true, DisplayOrder.NEWEST_FIRST);

			
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Hybrid\\POM\\qa\\Configs\\ReportsConfig.xml"));
			// optional
			extent.addSystemInfo("Selenium Version", "4.0.0").addSystemInfo(
					"Environment", "QA");

		
				      /*Iterating over each suite included in the test
				      for (ISuite suite : suites) {
				            
				         //Following code gets the suite name
				         String suiteName = suite.getName();
				            
				         //Getting the results for the said suite
				         Map<String, ISuiteResult> suiteResults = suite.getResults();
				         for (ISuiteResult sr : suiteResults.values()) {
				            ITestContext tc = sr.getTestContext();
				            System.out.println("Passed tests for suite '" + suiteName +
				               "' is:" + tc.getPassedTests().getAllResults().size());
				            System.out.println("Failed tests for suite '" + suiteName +
				               "' is:" + tc.getFailedTests().getAllResults().size());
				            System.out.println("Skipped tests for suite '" + suiteName +
				               "' is:" + tc.getSkippedTests().getAllResults().size());
				         }
				      }*/
				   }
		return extent;
	}
	

}
