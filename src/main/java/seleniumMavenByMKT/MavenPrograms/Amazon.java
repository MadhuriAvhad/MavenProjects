package seleniumMavenByMKT.MavenPrograms;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Amazon {
	
	ChromeDriver driver;
		
		@BeforeMethod
		public void login() throws EncryptedDocumentException, IOException
		{
			driver = new ChromeDriver();
			driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26tag%3Dgooghydrabk1-21%26ref%3Dnav_signin%26adgrpid%3D155259815513%26hvpone%3D%26hvptwo%3D%26hvadid%3D674842289437%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D453630397977240177%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9301185%26hvtargid%3Dkwd-10573980%26hydadcr%3D14453_2316415%26gad_source%3D1&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
			driver.manage().window().maximize();
			
			FileInputStream excelPath = new FileInputStream("C:\\Users\\MADHURI AVHAD\\eclipse-workspace\\SeleniumByMKT\\testData\\dataFile.xlsx");
			Workbook openExcel = WorkbookFactory.create(excelPath);
			            
			String emailValue = openExcel.getSheet("firstSheet").getRow(1).getCell(5).getStringCellValue();
			WebElement email = driver.findElement(By.cssSelector("#ap_email"));
			email.sendKeys(emailValue);

			WebElement continueToLogin = driver.findElement(By.cssSelector("#continue"));
			continueToLogin.click();
			
			String passwordValue = openExcel.getSheet("firstSheet").getRow(1).getCell(3).getStringCellValue();
			WebElement password = driver.findElement(By.cssSelector("#ap_password"));
			password.sendKeys(passwordValue);
			
			WebElement signIN = driver.findElement(By.cssSelector("#signInSubmit"));
			signIN.click();
			
		}
		@Test(priority = 1)
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
		
		@Test(priority = 2)
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
//				System.out.println(optionsPresentInTheWishlist.get(i).getText());
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
		
		@AfterMethod
		public void logout() throws InterruptedException
		{
			
			WebElement AccounAndList = driver.findElement(By.cssSelector(".nav-line-1-container"));
			Actions actions = new Actions(driver);
			actions.moveToElement(AccounAndList).perform();
			
			WebElement signOut = driver.findElement(By.cssSelector("#nav-item-signout"));
			actions.moveToElement(signOut).click().perform();
		}
		
	

}
