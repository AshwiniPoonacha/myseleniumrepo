package com.qa.ExtentReportListner;


	import java.io.File;
	import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.DisplayOrder;
	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;

	public class ExtentReportListner implements ITestListener{
		private static ExtentReports extent;
		public static ExtentTest Test;

		public static  ExtentReports getInstance(ITestResult result) {
			if (extent == null) {
				Date d=new Date();
				String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
				extent = new ExtentReports("C:\\Users\\91990\\Music\\Reports\\Reports"+fileName, true, DisplayOrder.NEWEST_FIRST);

				
				extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
				// optional
				extent.addSystemInfo("Selenium Version", "4.0.0").addSystemInfo(
						"Environment", "QA");
			}

			return extent;
		}



		public void onTestFailure(ITestResult result) {
		System.out.println(result.getName());
		System.out.println(result.getTestName());
			
		}

		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestStart(ITestResult result) {
			System.out.println(result.getName());
			System.out.println(result.getStatus());
			System.out.println(result.getThrowable().getMessage());
			
		}

		public void onTestSuccess(ITestResult result) {
			System.out.println(result.getName());
			System.out.println(result.getTestName());
			
		}



		public void onFinish(ITestContext arg0) {
			// TODO Auto-generated method stub
			
		}



		public void onStart(ITestContext arg0) {
			// TODO Auto-generated method stub
			
		}



		public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
			// TODO Auto-generated method stub
			
		}
		
		

	}


