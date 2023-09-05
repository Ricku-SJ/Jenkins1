package com.Git;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyAnnotions {

WebDriver driver;
	
	@BeforeClass
	public void openBrowser()
	{
		Reporter.log("Open Browser",true);
		if(System.getProperty("browser").equalsIgnoreCase("Chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if(System.getProperty("browser").equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
		}
	}
	@BeforeMethod
	public void login() throws InterruptedException
	{
		Reporter.log("Login",true);
		driver.get(System.getProperty("url"));
		driver.get("https://demo.actitime.com/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		
	}
	@AfterMethod
	public void logout() throws InterruptedException
	{
		Reporter.log("Logout",true);
		Thread.sleep(6000);
		driver.findElement(By.id("logoutLink")).click();
	
	
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		Reporter.log("Close Browser",true);
	}
}
