package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.utility.GenericMethods2;

public class FlightLogin2 
{
	@Test
	public void login() throws Exception  
	{
		GenericMethods2 key=new GenericMethods2();
		key.launch("chrome");
		key.enterurl("http://demo.guru99.com/test/newtours/");
		key.enterdata("name","userName","mercury");
		key.enterdata("name","password","mercury");
		Thread.sleep(5000);
		key.click("name","submit");
        String format=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss").format(new Date());		
        key.screenshot("./Screenshots/"+format+".png");

		}

}
