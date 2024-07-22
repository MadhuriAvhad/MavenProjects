package endToend_Amazon;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import testData.Login_Details;

public class Registration_Page {
	
    WebDriver driver;
    WebDriverWait wait;
    
    String userName;
    String userMobileNum;
    String userNewPassword;
    
    @FindBy(name = "customerName")
    WebElement yourName;

    @FindBy(id="ap_phone_number")
    WebElement mobileNumber;
    
    @FindBy(id="ap_password")
    WebElement password;
    
    @FindBy(id="continue")
    WebElement verifyMobileNum;
    
    public void your_Name() {
    	yourName.sendKeys(userName);;
    }
    
    public void mobile_Number()
    {
    	mobileNumber.sendKeys(userMobileNum);
    }
    
    public void password()
    {
    	password.sendKeys(userNewPassword);
    }
    
    public void verify_mobile_number()
    {
    	verifyMobileNum.click();
    }
    public Registration_Page(WebDriver driver) {
        this.driver = driver; // Ensure driver is assigned here
        PageFactory.initElements(driver, this);
        
        Login_Details data = new Login_Details();
        data.fetching_registration_details();
        this.userName = data.userName;
        this.userMobileNum = data.userMobileNum;
        this.userNewPassword = data.userNewPassword;
    }
	
}
