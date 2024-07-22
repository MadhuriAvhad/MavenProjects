package iRetry;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestCase1 {

	@Test(retryAnalyzer = iRetry.IRetryDemo.class)
	public void assertFail() {
		
		System.out.println("Using IRetry logic");
		Assert.assertTrue(false);
		
		Reporter.log("Test Case Pass");
		
	} 

}
