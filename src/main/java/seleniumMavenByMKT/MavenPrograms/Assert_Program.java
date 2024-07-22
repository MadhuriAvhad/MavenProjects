package seleniumMavenByMKT.MavenPrograms;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assert_Program {
	
	
	@Test
	public void testCase1()
	{
		
		Assert.assertTrue(false); 	// To fail the test
//		Assert.assertFalse(true);	// To fail the test
		
		Assert.assertEquals(false, true);
		Assert.assertEquals(false, true, "Sorry!! It is not as expected");
			
	}

}
