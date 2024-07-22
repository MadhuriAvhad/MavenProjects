package pomIMP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Facebook {
	
	WebDriver driver;
	
//	Step 1: Locate each element using @FindBy
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(xpath="//button[@name='login']")
	WebElement loginButton;
	
//	Step 2: Create a separate method to perform an action
	
	public void un()
	{
		username.sendKeys("Madhuri Chetan");
	}
	
	public void pwd()
	{
		password.sendKeys("CMpass");
	}
	
	public void login()
	{
		loginButton.click();
	}
	
//	Step3: Initialize each Element using PageFactory class inside the constructor
	
	public Login_Facebook(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
