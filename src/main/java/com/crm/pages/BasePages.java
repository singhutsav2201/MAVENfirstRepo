package com.crm.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class BasePages 

{
	public static WebDriver driver;
	@Test
public void Fileread() throws IOException 
	{ 
		//ExtentTest test=extent.createTest("Fileread");
        File propfile=new File("config\\Userdetail.properties");
		Properties pro=new Properties();
		FileInputStream fis=new FileInputStream(propfile);
		pro.load(fis);
		
		String browser= pro.getProperty("Browser");
		if(browser.equals("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\utsav\\eclipse-workspace\\CrmAutomationProject\\Driver\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		else if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","Driver//geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		driver.get(pro.getProperty("URL"));
}
	
}
