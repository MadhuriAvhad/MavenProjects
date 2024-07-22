package amazon_Scenarios01to10;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario08 extends LoginLogout {
	
	@Test
	public void searchPowerOfMind()
	{
		WebElement search = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		search.sendKeys("Power of mind");
		search.sendKeys(Keys.ENTER);
		
		List<WebElement> options = driver.findElements(By.xpath("//h2/a/span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("Number of options available -> "+options.size());
		String productSelected = options.get(0).getText();
		System.out.println("Product selected is -> " + productSelected);
		options.get(0).click();
		
		Set<String> WindowIDs = driver.getWindowHandles();
		Iterator<String> it = WindowIDs.iterator();
		String parentID = it.next();
		String childID = it.next();
		System.out.println("Parent window ID -> " + parentID);
		System.out.println("Child window ID -> " + childID);
		driver.switchTo().window(childID);
		
		WebElement product = driver.findElement(By.cssSelector("#productTitle"));
		String productDisplayed = product.getText();
		System.out.println("Product displayed is -> " + productDisplayed);
		
		Assert.assertEquals(productDisplayed.contains(productSelected),true,"Oops!! selected product is not displayed");
		;
	}

}
