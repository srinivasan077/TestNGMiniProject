package com.web.AngularPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestShopApple {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		WebElement shop = driver.findElement(By.xpath("(//a[@class='nav-link'])[2]"));
		shop.click();
		WebElement element = driver.findElement(By.xpath("(//i[@class='zmdi zmdi-shopping-cart'])[1]"));
		element.click();
		WebElement shopIphone = driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']"));
		shopIphone.click();
		WebElement checkOut = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		checkOut.click();
		WebElement location = driver.findElement(By.xpath("//input[@id='country']"));
		location.sendKeys("India");
		WebElement checkbox = driver.findElement(By.xpath("//label[@for='checkbox2']"));
		checkbox.click();
		WebElement purchaseButton = driver.findElement(By.xpath("//input[@type='submit']"));
		purchaseButton.click();
		// Verify successful submission message
		WebElement successMessage = driver
				.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		String messageText = successMessage.getText();
		if (messageText.contains("Success! Thank you! Your order will be delivered in next few weeks :-).")) {
			System.out.println("Test Passed: Order submitted successfully");
		} else {
			System.out.println("Test Failed: Order submission failed");
		}
		// WebElement popup =
		// driver.findElement(By.xpath("//button[@class='nsm-dialog-btn-close']"));
		// popup.click();
		driver.quit();

	}

}
