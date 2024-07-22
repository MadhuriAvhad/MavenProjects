package seleniumMavenByMKT.MavenPrograms;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SkipAndTimeout_TestCase {
	
	@Test(timeOut = 1000)
	public void  login() throws EncryptedDocumentException, IOException
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26tag%3Dgooghydrabk1-21%26ref%3Dnav_ya_signin%26adgrpid%3D155259815513%26hvpone%3D%26hvptwo%3D%26hvadid%3D674842289437%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D12874131755759381115%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9301185%26hvtargid%3Dkwd-10573980%26hydadcr%3D14453_2316415%26gad_source%3D1&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.manage().window().maximize();
		
		FileInputStream excelPath = new FileInputStream("C:\\Users\\MADHURI AVHAD\\eclipse-workspace\\SeleniumByMKT\\testData\\dataFile.xlsx");
		Workbook openExcel = WorkbookFactory.create(excelPath);
		String userEmail = openExcel.getSheet("firstSheet").getRow(1).getCell(5).getStringCellValue();
		String userPassword = openExcel.getSheet("firstSheet").getRow(1).getCell(3).getStringCellValue();
		WebElement email = driver.findElement(By.cssSelector("#ap_email"));
		email.sendKeys(userEmail);
		WebElement continueToSignIn = driver.findElement(By.cssSelector("#continue"));
		continueToSignIn.click();
		WebElement password = driver.findElement(By.cssSelector("#ap_password"));
		password.sendKeys(userPassword);
		WebElement signIn = driver.findElement(By.cssSelector("#signInSubmit"));
		signIn.click();
		Reporter.log("Login Successfully !!!");
	}
}
