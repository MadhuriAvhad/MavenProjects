package seleniumMavenByMKT.MavenPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase_3 {
		
		@Test
		public static void login_to_gmail()
		{
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.google.co.in/");
			
			driver.findElement(By.linkText("Gmail")).click();
		}


	

}
