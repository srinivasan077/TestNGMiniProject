package TestNGMethods;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {
	@BeforeClass
	public void method1() {
		System.out.println("method1");
	}

	@AfterClass
	public void method2() {
		System.out.println("method2");
	}

	@BeforeSuite
	public void method3() {
		System.out.println("method3");
	}

	@AfterSuite
	public void method4() {
		System.out.println("method4");
	}

	@AfterTest
	public void method5() {
		System.out.println("method5");
	}

	@BeforeTest
	public void method6() {
		System.out.println("method6");
	}

	@BeforeMethod
	public void method7() {
		System.out.println("method7");
	}

	@AfterMethod
	public void method8() {
		System.out.println("method8");
	}

	@Test(groups = "smoke")
	public void method9() {
		System.out.println("method9");
	}

	@Test(groups = "sanity")
	public void method10() {
		System.out.println("method10");
	}

	@Test(groups = { "smoke", "sanity" })
	public void method11() {
		System.out.println("method11");
	}

	@Test(dependsOnGroups = "sanity")
	public void method12() {
		System.out.println("method12");
	}

}
