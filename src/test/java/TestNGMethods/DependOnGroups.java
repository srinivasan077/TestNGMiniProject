package TestNGMethods;

import org.testng.annotations.Test;

public class DependOnGroups {

	@Test(groups = "group1", dependsOnGroups = "group4", timeOut = 1000)
	public void method1() {
		System.out.println("method1");
	}

	@Test(groups = "group2")
	public void method2() {
		System.out.println("method2");
	}

	@Test(groups = "group3", dependsOnGroups = "group1")
	public void method3() {
		System.out.println("method3");
	}

	@Test(groups = "group4")
	public void method4() {
		System.out.println("method4");
	}

}
