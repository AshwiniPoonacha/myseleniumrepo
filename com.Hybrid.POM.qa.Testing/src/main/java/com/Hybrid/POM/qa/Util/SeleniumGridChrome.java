package com.Hybrid.POM.qa.Util;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGridChrome {

	public static void main(String[] args) throws MalformedURLException {
		//Define desrired capabilities//
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		
		//Chromeoptions//
		ChromeOptions options=new ChromeOptions();
		options.merge(cap);

		
		String huburl="http://192.168.0.105:4444/wd/hub";
		WebDriver driver=new RemoteWebDriver(new URL(huburl),options);
		
		driver.get("https://www.qtpselenium.com/selenium-training/module/561/15529");
	}

}
