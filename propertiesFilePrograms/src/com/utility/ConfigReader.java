package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader 
{
	Properties pro;
	public ConfigReader() throws Exception
	{
		try {
			File path=new File(".\\properties\\config.properties");
			
			FileInputStream fis=new FileInputStream(path);
			
			pro=new Properties();
			
			
			pro.load(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
			
			System.out.println(e.getMessage());
		} 
	}
	public String chromepath()
	{
		String path=pro.getProperty("chromepath");
		
		return path;
	}
	public String getURL()
	{
		return pro.getProperty("URL");
	
		
	}
	public String getusername()
	{
		return pro.getProperty("username");
	}
	public String getpassword()
	{
		return pro.getProperty("password");
	}

}
