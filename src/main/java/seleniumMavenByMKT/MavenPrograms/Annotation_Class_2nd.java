package seleniumMavenByMKT.MavenPrograms;

import org.testng.annotations.Test;

public class Annotation_Class_2nd {
	
	@Test(priority  = 1)
	public void registration()
	{
		
	}
	
	@Test(priority = 2, invocationCount = 5)
	public void login()
	{
		
	}
	
	@Test (enabled = false)
	public void logout()
	{
		
	}

}
