package seleniumMavenByMKT.MavenPrograms;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_tc {
	
	@DataProvider(name = "data1")
	public Object[][] method1()
	{
		return new Object[][] {{"ram"}, {"laxman"}, {"shiva"}, {"vishu"}};
		
	}
	
	@DataProvider(name = "data2")
	public Object[][] method2()
	{
		return new Object[][] {{11}, {21}, {31}, {41}};
		
	}
	
	@Test(dataProvider = "data1")
	public void testCase1(String name)
	{
		System.out.println(name.concat(name));
	}
	
	@Test(dataProvider = "data2")
	public void testCase2(int num)
	{
		System.out.println(num);
	}

}
