package seleniumMavenByMKT.MavenPrograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assert_Google_Search {
	
	@Test
	public void google_Search() throws InterruptedException
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		WebElement search = driver.findElement(By.xpath("(//textarea)[1]"));
		search.sendKeys("India");
		search.sendKeys(Keys.ENTER);
		
		Thread.sleep(500);
		Assert.assertEquals(driver.getTitle(), "India - Google Search", "Title of the page is incorrect");
	}

}
