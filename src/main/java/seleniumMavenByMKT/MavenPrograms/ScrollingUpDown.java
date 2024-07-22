package seleniumMavenByMKT.MavenPrograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollingUpDown {
	
	@Test
	public void scrolling()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		WebElement aboutAmazon = driver.findElement(By.linkText("About Us"));
		Point pt = aboutAmazon.getLocation();
		int x = pt.getX();
		int y = pt.getY();
		System.out.println("x -> "+ x);
		System.out.println("y -> "+ y);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,1000)");
		jse.executeScript("window.scrollBy(0,"+y+")");

	}
	

}
