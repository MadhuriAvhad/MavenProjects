package amazon_Scenarios01to10;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario05 extends LoginLogout {
	
	@Test
	public void searchCamera() throws InterruptedException
	{
		WebElement searchFor = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		searchFor.sendKeys("Camera");
		searchFor.sendKeys(Keys.ENTER);
		
		WebElement page2 = driver.findElement(By.cssSelector("[aria-label='Go to page 2']"));
		page2.click();
		List<WebElement> options = driver.findElements(By.cssSelector("[class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("Number of options -> "+options.size());
		
//		String productSelected = options.get(12).getText();
//		options.get(12).click();
//		System.out.println("Product selected is -> "+productSelected);
//		
//		Set<String> windowID = driver.getWindowHandles();
//		Iterator<String> it = windowID.iterator();
//		String parentID = it.next();
//		String childID = it.next();
//		System.out.println("Parent ID is -> "+parentID+"\nchild ID is ->"+childID);
//		driver.switchTo().window(childID);
//		
//		WebElement product = driver.findElement(By.cssSelector("#productTitle"));
//		String productDisplayed = product.getText();
//		
//		Assert.assertTrue(productDisplayed.contains(productSelected),"Oops!! Camera selected and displayed are different");
	}

}
