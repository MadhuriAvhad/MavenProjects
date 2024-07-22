package seleniumMavenByMKT.MavenPrograms;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotation_Class {
	
	@Test
	public static void t1()
	{
		System.out.println("@Test 1");
	}
	
	@Test
	public static void t2()
	{
		System.out.println("@Test 2");
	}
	
	@Test
	public static void t3()
	{
		System.out.println("@Test 3");
	}
	
	@BeforeMethod
	public static void bm()
	{
		System.out.println("@BeforeMethod");
	}
	
	@AfterMethod
	public static void am()
	{
		System.out.println("@AfterMethod");
	}
	
	@BeforeClass
	public static void bc()
	{
		System.out.println("@BeforeClass");
	}
	
	@AfterClass
	public static void ac()
	{
		System.out.println("@AfterClass");
	}
	
	@AfterTest
	public static void at()
	{
		System.out.println("@AfterTest");
	}
	
	@BeforeTest
	public static void bt()
	{
		System.out.println("@BeforeTest");
	}
	
	@AfterSuite
	public static void as()
	{
		System.out.println("@AfterSuite");
	}
	
	@BeforeSuite
	public static void bs()
	{
		System.out.println("@BeforeSuite");
	}

}
