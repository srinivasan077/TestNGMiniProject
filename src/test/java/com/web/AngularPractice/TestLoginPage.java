package com.web.AngularPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestLoginPage {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		// Fill in the login page
		WebElement nameInput = driver.findElement(By.xpath("//input[@minlength='2']"));
		nameInput.sendKeys("Srinivasan");

		WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
		emailInput.sendKeys("Srini@gmail.com");

		WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
		passwordInput.sendKeys("password@123");

		WebElement checkbox = driver.findElement(By.xpath("//input[@id='exampleCheck1']"));
		checkbox.click();

		Select genderDropdown = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		genderDropdown.selectByVisibleText("Male");

		WebElement employmentRadio = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		employmentRadio.click();

		WebElement dobInput = driver.findElement(By.xpath("//input[@max='3000-12-31']"));
		dobInput.sendKeys("02-06-1986");

		WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
		submitButton.click();

		// Verify successful submission message
		WebElement successMessage = driver
				.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		String messageText = successMessage.getText();
		if (messageText.contains("Success! The Form has been submitted successfully!.")) {
			System.out.println("Test Passed: Form submitted successfully");
		} else {
			System.out.println("Test Failed: Form submission failed");
		}

		// WebElement TwoWayDataBindingExample =
		// driver.findElement(By.xpath("//input[@class='ng-untouched ng-pristine
		// ng-valid']"));
		// TwoWayDataBindingExample.sendKeys("Hai");
		// driver.quit();
	}
}
