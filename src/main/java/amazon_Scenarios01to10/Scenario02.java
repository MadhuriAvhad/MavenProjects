package amazon_Scenarios01to10;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario02 extends LoginLogout {
	
	@Test
	public void searchForMobile()
	{
		WebElement searchFor = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		searchFor.sendKeys("Mobile");
		searchFor.sendKeys(Keys.ENTER);
		
		List<WebElement> options = driver.findElements(By.xpath("//h2/a/span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("Number of Options are -> "+options.size());
		String productSelected = options.get(0).getText();
		System.out.println("Product selected is -> "+productSelected);
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
		
		Assert.assertTrue(productName.contains(productSelected),"Oops!! mobile selected and displayed are different");
		
	}
	
}
