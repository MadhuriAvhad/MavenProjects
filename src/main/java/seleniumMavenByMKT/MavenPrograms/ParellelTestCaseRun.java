package seleniumMavenByMKT.MavenPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParellelTestCaseRun {
	
	WebDriver driver;
	
	@Test
	@Parameters("Browser")
	public void testcase1(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			driver = new ChromeDriver();
		}
		if(browserName.equals("Edge"))
		{
			driver = new EdgeDriver();
		}
		if(browserName.equals("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		WebElement search = driver.findElement(By.xpath("(//textarea)[1]"));
		search.sendKeys("grotechminds");
		search.sendKeys(Keys.ENTER);
	}

}