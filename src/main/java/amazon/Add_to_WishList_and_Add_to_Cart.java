package amazon;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Add_to_WishList_and_Add_to_Cart extends LaunchLogin_Logout {
		
	@Test
	public void add_to_cart() throws InterruptedException
	{
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("shoe");
		Thread.sleep(2000);
		List<WebElement> search_results = driver.findElements(By.xpath("//div[@class='two-pane-results-container']/div/div"));
		int search_count = search_results.size();
		System.out.println("Search Count -> "+ search_count);
		search_results.get(5).click();
		
		List<WebElement> result_options = driver.findElements(By.xpath("//h2/a/span[@class='a-size-base-plus a-color-base a-text-normal']"));
		int result_count = result_options.size();
		System.out.println("Result Count -> "+result_count);
		String optionSelected = result_options.get(1).getText();
		System.out.println("Option selected is -> "+ optionSelected);
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
		WebElement viewYourList = driver.findElement(By.linkText("View Your List"));
		viewYourList.click();
		Thread.sleep(2000);
		
		List<WebElement> optionsPresentInTheWishlist = driver.findElements(By.xpath("//h2/a"));
		System.out.println(optionsPresentInTheWishlist.size());
		Thread.sleep(2000);
		
		for (int i = 0; i<optionsPresentInTheWishlist.size(); i++)
		{
//			System.out.println(optionsPresentInTheWishlist.get(i).getText());
			if(optionsPresentInTheWishlist.get(i).getText().equals(optionSelected))
			{
				WebElement addToCart = driver.findElement(By.linkText("Add to Cart"));
				addToCart.click();
			}
		}
		Thread.sleep(2000);
		WebElement viewCart = driver.findElement(By.cssSelector("[class = 'a-button a-button-base a-button-small g-cart-view-btn']"));
		viewCart.click();
		Thread.sleep(2000);
	}
}
