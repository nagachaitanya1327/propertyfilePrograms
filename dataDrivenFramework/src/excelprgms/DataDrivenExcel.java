package excelprgms;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenExcel 
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
	public Object[][] setdata() throws IOException 
	{
		Excelread config=new Excelread("C:\\Users\\HP\\eclipse\\Frameworks\\dataDrivenFramework\\testdata\\data 2.xlsx");
int rows=config.getrowcount(0);
Object[][] obj=new Object[rows][2];
for(int i=0;i<rows;i++)
{
	obj[i][0]=config.data(0, i, 0);
	obj[i][1]=config.data(0, i, 1);
}
		return obj;

	}

	@AfterMethod
	public void teardown() 
	{
		driver.quit();
	}

}
