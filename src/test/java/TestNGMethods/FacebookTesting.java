package TestNGMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.page.objects.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FacebookTesting {
	public static WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}

	@Test(groups = "smoke")
	public void aloginPage() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.enterNameandPassword("karth@gmail.com", "kakakak");
		Thread.sleep(10000);
	}

	@Test(groups = { "smoke", "sanity" })
	public void loginPageTest2() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.enterNameandPassword("karth@gmail.com", "kakakak");

		Thread.sleep(10000);
	}

	@Test(groups = "sanity")
	public void loinPageWithInvalidInputs() {
		LoginPage login = new LoginPage(driver);
		login.enterNameandPassword("karth@gmail.com", "kakakak");
		login.clickLoginButton();
	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
}
