package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@DataProvider(name = "TestData")
	public Object[][] provideTestData() {
		return new Object[][] { { "UN1", "PW1" }, { "UN2", "PW2" }, { "UN3", "PW3" } };
	}

	@Test(dataProvider = "TestData")
	public void myTest(String Un, String Pw) {
		System.out.println("UserName:" + Un);
		System.out.println("Password:" + Pw);
	}
}
