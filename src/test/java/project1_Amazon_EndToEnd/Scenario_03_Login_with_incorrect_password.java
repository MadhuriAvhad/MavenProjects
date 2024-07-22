package project1_Amazon_EndToEnd;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import endToend_Amazon.Login_Page;

import testData.Login_Details;

public class Scenario_03_Login_with_incorrect_password {
	
	@Test
	public void Login_incorrectPassword() throws EncryptedDocumentException, IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.manage().window().maximize();
		
		Login_Details data = new Login_Details();
		data.fetching_incorrect_password();
		
		Login_Page lp = new Login_Page(driver);
		lp.enterCorrectEmail();
		lp.clickContinue();
		lp.enterIncorrectPassword();
		lp.clickSignIn();
		
		Assert.assertEquals(lp.disclaimerMessage(),"Your password is incorrect" ,"Login should not be done using incorrect password" );	
		
		driver.quit();
	}
}
