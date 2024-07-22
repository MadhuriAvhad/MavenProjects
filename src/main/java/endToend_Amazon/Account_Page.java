package endToend_Amazon;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testData.Login_Details;

public class Account_Page {
	
	String userName;
	
	WebDriver driver;
	
	@FindBy(css="[class='a-spacing-none ya-card__heading--rich a-text-normal']")
	List<WebElement> options;
	
	@FindBy(css="#ya-myab-address-edit-btn-2")
	WebElement edit;
	
	@FindBy(css="#address-ui-widgets-enterAddressFullName")
	WebElement fullName;
	
	@FindBy(css="[aria-labelledby='address-ui-widgets-form-submit-button-announce']")
	WebElement updateAddress;
	
	@FindBy(css="[class='a-alert-heading']")
	WebElement inlineMessage;
	
	public void your_addresses()
	{
		options.get(3).click();
	}
	
	public void edit_address()
	{
		edit.click();
		fullName.clear();
		fullName.sendKeys(userName);
		updateAddress.click();
	}
	
	public String incline_Message_Address_save()
	{
		return inlineMessage.getText();
		
	}
	
	public Account_Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		Login_Details data = new Login_Details();
		data.fetching_registration_details();
		this.userName = data.userName;
	}

}
