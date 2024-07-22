package amazon_Scenarios01to10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario07 extends LoginLogout {
	
	String searchFor = "Mango";
	
	@Test
	public void amazonFresh()
	{
		Actions actions = new Actions(driver);
		List<WebElement> freshDropdown = driver.findElements(By.xpath("//div/a/span[@class='nav-icon nav-arrow']"));
		System.out.println(freshDropdown.size());
		actions.moveToElement(freshDropdown.get(0)).perform();
		WebElement freshIcon = driver.findElement(By.cssSelector("[class='f3-cgi-flyout-store-box f3-cgi-flyout-store-box-left']"));
		actions.moveToElement(freshIcon).click().perform();
		
		WebElement search = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		search.sendKeys(searchFor);
		search.sendKeys(Keys.ENTER);
		
		WebElement resultShowed = driver.findElement(By.xpath("//div/div/span[@class='a-color-state a-text-bold']"));
		String resultShownFor = resultShowed.getText();
		System.out.println(resultShownFor);
		
		Assert.assertTrue(resultShownFor.contains(searchFor),"Oops!! Results shown here are different");
		
	}

}
