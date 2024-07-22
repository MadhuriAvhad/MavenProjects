package project1_Amazon_EndToEnd;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import endToend_Amazon.Account_Page;
import endToend_Amazon.Home_Page;
import endToend_Amazon.Login_Page;

public class Scenario_04_Edit_profile_details {
	
	@Test
	public void editProfile() throws EncryptedDocumentException, IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.manage().window().maximize();
		
		Login_Page login = new Login_Page(driver);
		login.enterCorrectEmail();
		login.clickContinue();
		login.enterCorrectPassword();
		login.clickSignIn();
		
		Home_Page home = new Home_Page(driver);
		home.account_list();
		home.your_account();
		
		Account_Page account = new Account_Page(driver);
		account.your_addresses();
		account.edit_address();
		Assert.assertEquals(account.incline_Message_Address_save(), "Address saved");
	}

}
