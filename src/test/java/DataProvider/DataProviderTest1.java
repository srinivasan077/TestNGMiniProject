package DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.page.objects.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest1 {
	public static WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}
	@Test(priority = 1)
	public void aloginPage() throws InterruptedException {
		LoginPage login=new LoginPage(driver);
		login.enterNameandPassword("srinivasan@gmail.com", "password");
		
		Thread.sleep(10000);
	}
	@DataProvider(name = "testData")
	public Object[][] provideTestData(){
		return  new Object[][] {
			{ "srini@gmail.com", "password1" },
			{"vasan@gmail.com", "password2" },
			{"krish@gmail.com" ,"password3" },
		};
	}
		@Test(priority = 2, dataProvider = "testData")
		public void loinPageWithInvalidInputs(String username,String password) {
			LoginPage login=new LoginPage(driver);
			login.enterNameandPassword(username, password);
		WebElement checkbox = driver.findElement(By.xpath("//button[@type='submit']"));
		checkbox.click();
	}
		@AfterMethod
		public void quitBrowser() {
			 driver.quit();
		}

}
