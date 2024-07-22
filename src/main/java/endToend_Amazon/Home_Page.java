package endToend_Amazon;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	WebDriver driver;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchArea;
	
	@FindBy(css="[class='a-color-state a-text-bold']")
	WebElement searchInlineMessage;
	
	@FindBy(css="[class='nav-line-2 ']")
	WebElement AccountAndList;
	
	@FindBy(css="[class='nav-text']")
	List<WebElement> yourAccount;
	
	public boolean visibilityOf_SearchTextBox()
	{
		return searchArea.isDisplayed();	
	}
	
	public void search_for(String productName)
	{
		searchArea.sendKeys(productName);
		searchArea.sendKeys(Keys.ENTER);
	}
	
	public String inlineMessage_Search()
	{
		return searchInlineMessage.getText();
	}
	
	public void account_list()
	{
		Actions act = new Actions(driver);
		act.moveToElement(AccountAndList).build().perform();
	}
	
	public void your_account()
	{
		yourAccount.get(6).click();;
	}
	
	public Home_Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
