package amazon_Scenarios01to10;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario03 extends LoginLogout {
	
	@Test
	public void searchMouse()
	{
		WebElement searchFor = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		searchFor.sendKeys("mouse");
		searchFor.sendKeys(Keys.ENTER);
		
		WebElement getItIn2Days = driver.findElement(By.xpath("//span/a/span[.='Get It in 2 Days']"));
		getItIn2Days.click();
		
		List<WebElement> options = driver.findElements(By.xpath("//h2/a/span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("Number of options are -> "+options.size());
		String productSelected = options.get(0).getText();
		System.out.println("Product selected is -> "+ productSelected);
		options.get(0).click();
		
		Set<String> windowIDs = driver.getWindowHandles();
		Iterator<String> it = windowIDs.iterator();
		String parentID = it.next();
		String childID = it.next();
		System.out.println("Parent window ID -> "+parentID+"\nChild window ID -> "+childID);
		driver.switchTo().window(childID);
		
		WebElement product = driver.findElement(By.cssSelector("#productTitle"));
		String productDisplayed = product.getText();
		
		Assert.assertTrue(productDisplayed.contains(productSelected),"Oops!! mouse selected and displayed are different");
		
	}

}
