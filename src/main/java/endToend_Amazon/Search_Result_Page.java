package endToend_Amazon;

import java.util.List;

//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Result_Page {
	
	WebDriver driver;
	
	@FindBy(css="[class='a-size-base a-color-base']")
	List<WebElement> selectCategory;
	
	@FindBy(css="[id='p_36/range-slider_slider-item_lower-bound-slider']")
	WebElement minPriceRange;
	
	@FindBy(css="[id='p_36/range-slider_slider-item_upper-bound-slider']")
	WebElement maxPriceRange;
	
	@FindBy(css="[class='a-size-base-plus a-color-base a-text-normal']")
	List<WebElement> searchResultOptions;
	
	public void calegory_selected()
	{
		 selectCategory.get(9).click();
	}
	
	public String verifyFilterApplied()
	{
		return searchResultOptions.get(0).getText();
	}
	
//	public void price_range_selected()
//	{
//		Point pt1 = minPriceRange.getLocation();
//		System.out.println("minPrice x value -> " + pt1.getX());
//		System.out.println("minPrice y value -> " + pt1.getY());
//		
//		Point pt2 = maxPriceRange.getLocation();
//		System.out.println("maxPrice x value -> " + pt2.getX());
//		System.out.println("maxPrice y value -> " + pt2.getY());
//		
//		Actions act = new Actions(driver);
//		act.doubleClick(minPriceRange).moveByOffset(10, 0).release().perform(); 
//		act.doubleClick(maxPriceRange).moveByOffset(-10, 0).release().perform();
//	}

	public Search_Result_Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
