package seleniumMavenByMKT.MavenPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Amazon_CreateNewAccount {

	@DataProvider(name = "Customer Details")
	public Object[][] details()
	{
		return new Object[][] {{"Madhuri Avhad","9874563210","MadhuriA@123"}, 	//{(0,0),(0,1),(0,2)}
								{"Avhad Madhuri","8745632109","AvhadM@456"},	//{(1,0),(1,1),(1,2)}
								{"Madhuri Palve","7456321089","MPalve@789"},	//{(2,0),(2,1),(2,2)}
								{"Palve Madhuri","4563210789","PMadhuri@987"},	//{(3,0),(3,1),(3,2)}
								{"Chetan Madhuri","5632104789","ChetanM@654"},	//{(4,0),(4,1),(4,2)}
								{"Madhuri Chetan","6123054789","MadhuriC@321"},	//{(5,0),(5,1),(5,2)}
								{"Chetan Palve","1230654789","CPalve@147"},		//{(6,0),(6,1),(6,2)}
								{"Palve Chetan","2301654987","PChetan@258"},		//{(7,0),(7,1),(7,2)}
								{"Madhuri Chetan Palve","3021456987","MCPalve@369"},//{(8,0),(8,1),(8,2)}
								{"Chetan Madhuri Avhad","1234567890","CMAvhad@753"}};//{(9,0),(9,1),(9,2)}
		
	}
	
	@Test(dataProvider = "Customer Details")
	public void createAccount(String name, String phoneNum, String pass)
	{
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fs%2F%3F_encoding%3DUTF8%26adgrpid%3D59671903835%26ext_vrnc%3Dhi%26hvadid%3D590652406969%26hvdev%3Dc%26hvlocphy%3D9301185%26hvnetw%3Dg%26hvqmt%3De%26hvrand%3D2120210749882810711%26hvtargid%3Dkwd-837441119212%26hydadcr%3D24542_2265395%26k%3Dlogin%2520amazon%2520account%26ref%3Dpd_sl_2cwzc6x246_e%26tag%3Dgooginhydr1-21%26ref_%3Dnav_em_hd_re_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&ref_%3Dnav_em_hd_clc_signin_0_1_1_41");
		
		WebElement createAccount = driver.findElement(By.id("createAccountSubmit"));
				   createAccount.click();
		WebElement firstAndLastName = driver.findElement(By.name("customerName"));
			       firstAndLastName.sendKeys(name);
	    WebElement phoneNo = driver.findElement(By.id("ap_phone_number"));
	    	       phoneNo.sendKeys(phoneNum);       
	    WebElement password = driver.findElement(By.name("password"));
	               password.sendKeys(pass);
	    WebElement verify = driver.findElement(By.id("continue"));
		           verify.click();
	}
}
