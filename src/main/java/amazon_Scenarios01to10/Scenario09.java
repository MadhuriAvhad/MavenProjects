package amazon_Scenarios01to10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Scenario09 extends LoginLogout {
	
	@Test
	public void dealsOfTheDay()
	{
//		WebElement horizontalMenu = driver.findElement(By.cssSelector("#nav-xshop"));
//		horizontalMenu.click();
		WebElement menuOption = driver.findElement(By.cssSelector("[data-csa-c-slot-id='nav_cs_33']"));
//		List<WebElement> menuOptions = driver.findElements(By.cssSelector("[class='nav-a  ']"));
//		System.out.println("Number of menu options in Home page -> "+menuOptions.size());
//		System.out.println("Option selected -> "+ menuOptions.get(33).getText());
//		menuOptions.get(33).getText().click();
		menuOption.click();
		
		List<WebElement> todaysDealsMenu = driver.findElements(By.cssSelector("[class='a-carousel-card']"));
		System.out.println("Number of options for today's Deal -> "+todaysDealsMenu.size());
		System.out.println("Option selected -> "+ todaysDealsMenu.get(2).getText());
		todaysDealsMenu.get(2).click();
		
	}

}
