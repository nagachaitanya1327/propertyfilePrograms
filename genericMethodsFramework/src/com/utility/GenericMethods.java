package com.utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GenericMethods {
	
		WebDriver driver;
		public void openBrowser(String browserName)
		{
			if(browserName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\webdriver\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if(browserName.equals("internetexplorer"))
			{
				System.setProperty("webdriver.ie.driver", "C:\\Users\\HP\\Desktop\\webdriver\\IEDriverServer.exe");
				 driver=new InternetExplorerDriver();	
			}
			
		}

		public void enterURL(String url)
		{
			driver.get(url);
		}
		
		public void enterData(String locatorType,String locatorValue,String data ) 
		{
			if(locatorType.equals("xpath"))
			{
			driver.findElement(By.xpath(locatorValue)).sendKeys(data);
				
			}
			else if(locatorType.equals("id"))
			{
			driver.findElement(By.id(locatorValue)).sendKeys(data);
			}
			else if(locatorType.equals("name"))
			{
			driver.findElement(By.name(locatorValue)).sendKeys(data);
			
			}
		}
		
		public void click(String locatorType,String locatorValue)
		{
			if(locatorType.equals("xpath"))
			{
			driver.findElement(By.xpath(locatorValue)).click();
			}
			else if(locatorType.equals("id"))
			{
			driver.findElement(By.id(locatorValue)).click();
			}
			else if(locatorType.equals("name"))
			{
			driver.findElement(By.name(locatorValue)).click();
			}
			else if(locatorType.equals("className"))
			{
			driver.findElement(By.className(locatorValue)).click();
			}
			else if(locatorType.equals("tagName"))
			{
			driver.findElement(By.tagName(locatorValue)).click();
			}
			else if(locatorType.equals("cssSelector"))
			{
			driver.findElement(By.cssSelector(locatorValue)).click();
			}
			else if(locatorType.equals("linkText"))
			{
			driver.findElement(By.linkText(locatorValue)).click();
			}
			else if(locatorType.equals("partialLinkText"))
			{
			driver.findElement(By.partialLinkText(locatorValue)).click();
			}
		}
			
		
		public <SrcFile> void screenshot(SrcFile DestFile) throws IOException
		{
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			

			File DestFile1=new File( (String) DestFile);

			FileUtils.copyFile(SrcFile, DestFile1);
		}
		public void extentreports(String path)
		{
			ExtentHtmlReporter d1=new ExtentHtmlReporter(path);
			ExtentReports d2=new ExtentReports();
			d2.attachReporter(d1);
			ExtentTest d3=d2.createTest("flight login");
			d3.log(Status.PASS,"login test is passed");
			d2.flush();
		}
		
	}