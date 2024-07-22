package project1_Amazon_EndToEnd;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import endToend_Amazon.Registration_Page;

public class Scenario_01_NewCustomerRegistration {
	
	@Test
	public void Registration()
	{
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fs%2F%3F_encoding%3DUTF8%26adgrpid%3D59671903835%26ext_vrnc%3Dhi%26hvadid%3D590652406969%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9301185%26hvnetw%3Dg%26hvpone%3D%26hvpos%3D%26hvptwo%3D%26hvqmt%3Db%26hvrand%3D4628132074803840012%26hvtargid%3Dkwd-294882733100%26hydadcr%3D24542_2265395%26ie%3DUTF8%26index%3Daps%26keywords%3Dlogin%2520amazon%2520account%26ref%3Dpd_sl_2cwzc6x246_b%26tag%3Dgooginhydr1-21%26ref_%3Dnav_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        driver.manage().window().maximize();
        
        String firstURL = driver.getCurrentUrl();
     
        Registration_Page register = new Registration_Page(driver);
        register.your_Name();
        register.mobile_Number();
        register.password();
        register.verify_mobile_number();
        
        Assert.assertEquals(driver.getCurrentUrl().equals(firstURL), false, "After registration user should redirect to the next page.");     
        driver.close();
		
	}
	

}
