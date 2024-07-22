package seleniumMavenByMKT.MavenPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestCase_4 {
		
		@Test
		public static void login_to_amazon_xpath()
		{
			EdgeDriver driver = new EdgeDriver();
			driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F_encoding%3DUTF8%26adgrpid%3D155259815513%26gad_source%3D1%26hvadid%3D674842289437%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9302181%26hvnetw%3Dg%26hvpone%3D%26hvpos%3D%26hvptwo%3D%26hvqmt%3De%26hvrand%3D11822390844659475432%26hvtargid%3Dkwd-10573980%26hydadcr%3D14453_2316415%26ref%3Dpd_sl_7hz2t19t5c_e%26tag%3Dgooghydrabk1-21%26ref_%3Dnav_em_hd_re_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&ref_%3Dnav_em_hd_clc_signin_0_1_1_38");
			
			WebElement email = driver.findElement(By.xpath("//input[@id='ap_email']"));
			email.sendKeys("avhadmadhuri28@gmail.com");
			
			WebElement continueToSubmit = driver.findElement(By.xpath("//input[@id='continue']"));
			continueToSubmit.click();
			
			WebElement password = driver.findElement(By.xpath("//input[@id='ap_password']"));
			password.sendKeys("Avhad");
			
			WebElement signIN = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
			signIN.click();
		}


	

}
