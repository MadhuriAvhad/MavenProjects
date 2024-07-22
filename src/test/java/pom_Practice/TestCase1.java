package pom_Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pomIMP.Login_Facebook;

public class TestCase1 {
	
	@Test
	public void login_to_facebook_using_valid_credentials()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		Login_Facebook fb = new Login_Facebook(driver);
		fb.un();
		fb.pwd();
		fb.login();
		
	}

}
