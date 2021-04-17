package test;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.utility.GenericMethods;

public class FlightLogin 
{
	WebDriver driver;
	@Test
	public void flightlogin() throws IOException
	{
		GenericMethods key=new GenericMethods();
		key.openBrowser("chrome");
		key.enterURL("http://demo.guru99.com/test/newtours/");
		key.enterData("name","userName","mercury");
		key.enterData("name","password","mercury");
		key.click("name","submit");
		String format=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss").format(new Date());
		key.screenshot("./Screenshots/"+format+".png");
		key.extentreports("./Reports/"+format+".html");
		
		
		
	}

}
