package TestNGMethods;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestNG1 {
	@BeforeClass
	public void method1() {
		System.out.println("method1");
	}

	@AfterClass
	public void method2() {
		System.out.println("method2");
	}
}
