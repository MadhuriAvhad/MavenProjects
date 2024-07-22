package amazon_Scenarios01to10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario06 extends LoginLogout {
	
	@Test
	public void electronicsRedmi()
	{
		List<WebElement> menuOptions = driver.findElements(By.cssSelector("[class='nav-a  ']"));
		System.out.println("Number of options on home page -> "+menuOptions.size());
		System.out.println("Option selected -> "+ menuOptions.get(2).getText());
		menuOptions.get(2).click();
		
		List<WebElement> electronicsMenu = driver.findElements(By.cssSelector("[class='a-link-normal']"));
		electronicsMenu.get(7).click();
		
		List<WebElement> RedmiOptions = driver.findElements(By.cssSelector("[class='a-size-base-plus a-color-base a-text-normal']"));
		System.out.println(RedmiOptions.size());
		String optionName = RedmiOptions.get(0).getText();
		System.out.println("Item name to check Redmi brand selected -> " + optionName);
		Assert.assertEquals(optionName.contains("Redmi"), true, "Oops!! Options are not related to Redmi");

	}

}
