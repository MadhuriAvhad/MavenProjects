package amazon_Scenarios01to10;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Scenario04 extends LoginLogout {
	
	@Test
	public void searchMobileCover()
	{
		WebElement searchFor = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		searchFor.sendKeys("Mobile cover");
		searchFor.sendKeys(Keys.ENTER);
		
		WebElement includeOutOfStock = driver.findElement(By.xpath("//span/a/span[.='Include Out of Stock']"));
		includeOutOfStock.click();
		
	}
}
