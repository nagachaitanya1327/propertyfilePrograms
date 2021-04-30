package by2Darray;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven2darray 
{
	WebDriver driver;

	@BeforeMethod
	public void setup() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/");

	}

	@Test(dataProvider = "setdata")
	public void login(String username, String password) 
	{

		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		System.out.println("data is entered successfully ");
		System.out.println("actual title after login is:  " +driver.getTitle());
		String actual = "Login: Mercury Tours";
		String expected = driver.getTitle();
		System.out.println("expected title is :" + expected);
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] setdata() 
	{
		Object[][] data = new Object[3][2];
		data[0][0] = "mercury";
		data[0][1] = "mercury";

		data[1][0] = "RBG";
		data[1][1] = "technologies";

		data[2][0] = "chaitanya";
		data[2][1] = "kalyan";

		return data;

	}

	@AfterMethod
	public void teardown() 
	{
		driver.quit();
	}

}
