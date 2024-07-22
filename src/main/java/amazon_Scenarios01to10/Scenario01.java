package amazon_Scenarios01to10;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.*;

public class Scenario01 extends LoginLogout {

	@Test
	public void searchForShoe()
	{
		WebElement searchFor = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		searchFor.sendKeys("shoe");
		searchFor.sendKeys(Keys.ENTER);
		
		List<WebElement> options = driver.findElements(By.xpath("//h2/a/span[@class='a-size-base-plus a-color-base a-text-normal']"));
		System.out.println("Number of options for shoe ->"+options.size());
		String optionSelected = options.get(0).getText();
		System.out.println("Product selected is -> "+optionSelected);
		options.get(0).click();
		
		Set<String> windowIDs = driver.getWindowHandles();
		Iterator<String> it = windowIDs.iterator();
		String parentID = it.next();
		String childID = it.next();
		System.out.println("Parent window ID -> "+parentID+"/nChild window ID -> "+childID);
		
		driver.switchTo().window(childID);
		WebElement product = driver.findElement(By.cssSelector("#productTitle"));
		String productName = product.getText();
		System.out.println("Product displayed is -> "+ productName);
		
		Assert.assertTrue(productName.contains(optionSelected), "Oops!! shoe selected and displayed are different");
		
	}
}
