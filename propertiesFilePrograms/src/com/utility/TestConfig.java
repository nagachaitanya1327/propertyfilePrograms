package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class TestConfig
{
	
@Test
	public void  propertyreader() throws Exception
	{
		
		File path=new File(".\\properties\\config.properties");
		FileInputStream fis=new FileInputStream(path);
		Properties pro=new Properties();
		pro.load(fis);
		System.out.println("chrome path from property file is "+pro.getProperty("chromepath"));
		System.out.println("get the url from the property files"+pro.getProperty("URL"));
		
		
		
		
	}

}
