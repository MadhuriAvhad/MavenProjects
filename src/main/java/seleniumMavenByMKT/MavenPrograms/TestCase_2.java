package seleniumMavenByMKT.MavenPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestCase_2 {
		
		@Test
		public static void login_to_flipkart()
		{
			EdgeDriver driver = new EdgeDriver();
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();
			
			driver.findElement(By.id("email")).sendKeys("avhad@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("Madhuri");
			driver.findElement(By.name("login")).click();
		}


	

}
