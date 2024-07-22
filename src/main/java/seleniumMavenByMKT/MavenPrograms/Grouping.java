package seleniumMavenByMKT.MavenPrograms;

import org.testng.annotations.Test;

public class Grouping {
	
	@Test(groups = "Smoke")
	public void TestCase1()
	{
		System.out.println("TestCase1 -> Smoke");
	}
	
	@Test(groups = "Sanity")
	public void TestCase2()
	{
		System.out.println("TestCase2 -> Sanity");
	}
	
	@Test(groups = "Smoke")
	public void TestCase3()
	{
		System.out.println("TestCase3 -> Smoke");
	}
	
	@Test(groups = "Sanity")
	public void TestCase4()
	{
		System.out.println("TestCase4 -> Sanity");
	}
	
	@Test(groups = "Smoke")
	public void TestCase5()
	{
		System.out.println("TestCase5 -> Smoke");
	}

}
