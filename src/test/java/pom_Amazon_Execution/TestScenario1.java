package pom_Amazon_Execution;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import listeners_Practice.Test_Listener;
import pom_Amazon.Amazon_Login_Page;

public class TestScenario1 extends Test_Listener {
 
	@Test
	public void Login_to_Search() throws EncryptedDocumentException, IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.manage().window().maximize();
		
		Amazon_Login_Page am = new Amazon_Login_Page(driver);
		am.enterEmail();
		am.clickContinue();
		am.enterPassword();
		am.clickSignIn();
		
		driver.close();
	}
}
