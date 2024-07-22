package amazon_Scenarios01to10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario10 extends LoginLogout {
	
	@Test
	public void searchShoeBackHome()
	{
		System.out.println(driver.getTitle());
		WebElement searchFor = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		searchFor.sendKeys("shoe");
		searchFor.sendKeys(Keys.ENTER);
		
		driver.navigate().back();
		WebElement amazon = driver.findElement(By.cssSelector("[aria-label='Amazon.in']"));
		amazon.click();
		
		Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", "Oops!! We have not landed on Home page. Something wents wrong...");
	}

}
