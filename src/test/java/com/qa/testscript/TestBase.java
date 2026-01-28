package com.qa.testscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase 
{
	WebDriver driver;
	
	JavascriptExecutor js;
	FileInputStream FileLoc;
	Properties prop;
	String Browser = "Chrome";
	
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void SetUp () throws IOException {
		//FileLoc = new FileInputStream("");
		//prop=new Properties();
		//prop.load(FileLoc);
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			// Chrome Browser
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("Edge")) {
			// Edge Browser
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
//		CitiBankPages CitiBankOR= CitiBankPage(driver);
		
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
			//driver.get(Browser);
	}	
	
	
	@AfterClass
	public void tearDown() 
	{
		//driver.quit();
		driver.close();
	}
	
	
	public void captureScreenShot(WebDriver driver,String tName) throws IOException {
	 TakesScreenshot ts = (TakesScreenshot)driver;
	 File src =ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/ScreenShots/"+tName+".png");
		FileUtils.copyFile(src, target);
	}
	

}
