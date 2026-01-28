package com.qa.testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Launch_Browser extends TestBase
{
	@Test(priority = 1)
	public void QST_LaunchBrowser() throws InterruptedException
	{
		driver.get("https://www.google.com/travel/");
		boolean contains = driver.getCurrentUrl().contains("https://www.google.com/travel/");
		if(contains)
		{
			System.out.println("User is landed on Google Travel Home Page");
		}
		else
		{
			System.out.println("User is not landed on Google Travel Home Page");
		}
		
		System.out.println("Title of the Page :" +driver.getTitle());
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void Search() throws InterruptedException, AWTException
	{
		WebElement SearchTextField = driver.findElement(By.xpath("(//input[@placeholder='Search for flights, hotels and more'])[1]"));
		SearchTextField.sendKeys("Chennai");
		Thread.sleep(2000);
		
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
	}
	

}
