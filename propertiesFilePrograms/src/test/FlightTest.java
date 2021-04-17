package test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.utility.ConfigReader;

public class FlightTest {
@Test
	public void logontest() throws Exception
	{
		ConfigReader config=new ConfigReader();
		
		System.setProperty("webdriver.chrome.driver",config.chromepath());
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(config.getURL());
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("userName")).sendKeys(config.getusername());
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys(config.getpassword());
		Thread.sleep(5000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(5000);
		driver.quit();
		
		
		

	}

}
