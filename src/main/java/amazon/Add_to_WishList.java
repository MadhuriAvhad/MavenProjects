package amazon;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Add_to_WishList extends LaunchLogin_Logout {
	
	@Test
	public void add_to_wishlist() throws InterruptedException
	{
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("shoe");
		Thread.sleep(2000);
		List<WebElement> search_results = driver.findElements(By.xpath("//div[@class='two-pane-results-container']/div/div"));
		int search_count = search_results.size();
		System.out.println("Search Count -> "+ search_count);
		search_results.get(5).click();
		
		List<WebElement> result_options = driver.findElements(By.xpath("//a[@class='a-link-normal s-no-outline']"));
		int result_count = result_options.size();
		System.out.println("Result Count -> "+result_count);
		result_options.get(1).click();
		
		Set<String> windowIDs = driver.getWindowHandles();
		Iterator<String> it = windowIDs.iterator();
		System.out.println("Window IDs -> "+windowIDs);
		String parentID = it.next();
		String childID = it.next();
		System.out.println("Parent ID -> "+parentID);
		System.out.println("Child ID -> "+childID);
		
		driver.switchTo().window(childID);
		
		WebElement addToWishList = driver.findElement(By.cssSelector("#add-to-wishlist-button-submit"));
		addToWishList.click();
		
		Thread.sleep(2000);
		WebElement closeWindowPopup = driver.findElement(By.cssSelector("[class=' a-button-close a-declarative']"));
		closeWindowPopup.click();
		Thread.sleep(2000);
	}

}
