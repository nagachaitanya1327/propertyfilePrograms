package rightcilckAndDoubleClick;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RightClick 
{
	@Test
	public void click() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\webdriver\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
    
	driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
	
	Actions act=new Actions(driver);
	
	act.contextClick(driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"))).perform();
	
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("/html/body/ul/li[3]/span")).click();
	
	Thread.sleep(5000);
	
	System.out.println(driver.switchTo().alert().getText());
	
	driver.switchTo().alert().accept();
	
	driver.quit();
	
	
	}

}
