package TestNGMethods;

import org.testng.annotations.Test;

public class DependOnMethods {

	@Test
	public void method1() {
		System.out.println("method1");
	}

	@Test
	public void method2() {
		System.out.println("method2");
	}

	@Test(dependsOnMethods = "method2")
	public void method3() {
		System.out.println("method3");
	}

	@Test(dependsOnMethods = { "method1", "method3" })
	public void method4() {
		System.out.println("method4");
	}

}
