package seleniumMavenByMKT.MavenPrograms;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class Assertion_Types {
	
	
	@Test
	public void login_amazon() throws EncryptedDocumentException, IOException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26tag%3Dgooghydrabk1-21%26ref%3Dnav_signin%26adgrpid%3D155259815513%26hvpone%3D%26hvptwo%3D%26hvadid%3D674842289437%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D453630397977240177%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9301185%26hvtargid%3Dkwd-10573980%26hydadcr%3D14453_2316415%26gad_source%3D1&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.manage().window().maximize();
		
		FileInputStream excelPath = new FileInputStream("C:\\Users\\MADHURI AVHAD\\eclipse-workspace\\SeleniumByMKT\\testData\\dataFile.xlsx");
		Workbook openExcel = WorkbookFactory.create(excelPath);
		            
		String emailValue = openExcel.getSheet("firstSheet").getRow(1).getCell(5).getStringCellValue();
		WebElement email = driver.findElement(By.cssSelector("#ap_email"));
		email.sendKeys(emailValue);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(email.isDisplayed(), false, "email is not displayed");

		WebElement continueToLogin = driver.findElement(By.cssSelector("#continue"));
		continueToLogin.click();
		
		String passwordValue = openExcel.getSheet("firstSheet").getRow(1).getCell(3).getStringCellValue();
		WebElement password = driver.findElement(By.cssSelector("#ap_password"));
		password.sendKeys(passwordValue);
		
		WebElement signIN = driver.findElement(By.cssSelector("#signInSubmit"));
		signIN.click();
		
		WebElement search = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		
		Assertion a = new Assertion();
		a.assertEquals(search.isDisplayed(), true, "Search is not displayed");
	}
}
