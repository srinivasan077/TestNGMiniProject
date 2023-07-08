package TestNGMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	@org.testng.annotations.Test
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement emailId = driver.findElement(By.xpath("//input[@id='email']"));
		emailId.sendKeys("srinivasankrishnan68@gmail.com");

		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		password.sendKeys("honda@1100");

		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		// driver.quit();
	}
}