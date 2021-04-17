package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericMethods2 
{
	static WebDriver driver;

	public void launch(String browsername) 
	{
		if (browsername.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\webdriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	}
	
	
	public void enterurl(String url)
	{
		driver.get(url);
	}
	
	public void enterdata(String locatortype,String locatorvalue,String data)
	{
		if(locatortype.equals("id"))
		{
			driver.findElement(By.id(locatorvalue)).sendKeys(data);
		}
		else if(locatortype.equals("name"))
		{
			driver.findElement(By.name(locatorvalue)).sendKeys(data);
		}
		else if(locatortype.equals("xpath"))
		{
			driver.findElement(By.xpath(locatorvalue)).sendKeys(data);
		}
	}
	
	public void click(String locatortype ,String locatorvalue)
	{
		
		 if(locatortype.equals("name"))
		{
			driver.findElement(By.name(locatorvalue)).click();
		}
		
		
	}
	public void screenshot(String path) throws IOException
	{
		TakesScreenshot src=(TakesScreenshot)driver;
		File srcfile=src.getScreenshotAs(OutputType.FILE);
		File destfile=new File(path);
		FileUtils.copyFile(srcfile, destfile);
		
	}


	
	
	

}
