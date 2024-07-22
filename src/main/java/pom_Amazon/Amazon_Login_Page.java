package pom_Amazon;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testData.Login_Details;

public class Amazon_Login_Page extends Login_Details{
	
	WebDriver driver;
	
	String userCorrectEmail;
	String userCorrectPassword;
	String userIncorrectEmail;
	String userIncorrectPassword;
	
	@FindBy(id="ap_email")
	WebElement email;
	
	@FindBy(id="continue")
	WebElement continueToSignIn;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement signIn;

	public void enterEmail() throws EncryptedDocumentException, IOException
	{
		email.sendKeys(userCorrectEmail);
	}
	
	public void enterPassword() throws EncryptedDocumentException, IOException
	{
		password.sendKeys(userCorrectPassword);
	}
	
	public void clickContinue()
	{
		continueToSignIn.click();
	}
	
	public void clickSignIn()
	{
		signIn.click();
	}
	
	public Amazon_Login_Page(WebDriver driver) throws EncryptedDocumentException, IOException
	{
		PageFactory.initElements(driver, this);
		Login_Details data = new Login_Details();
		data.fetching_Login_Details();
		data.fecting_incorrect_email();
		data.fetching_incorrect_password();
		this.userCorrectEmail = data.userCorrectEmail;
		this.userIncorrectEmail = data.userIncorrectEmail;
		this.userCorrectPassword = data.userCorrectPassword;
		this.userIncorrectPassword = data.userIncorrectPassword;
	}
}
