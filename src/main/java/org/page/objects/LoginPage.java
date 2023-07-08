package org.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	
	private String emailIDLocator = "email";
	private By passwordLocator = By.id("pass");
	public By loginButton = By.xpath("//button[@type='submit']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
public void enterNameandPassword(String emailID ,String password) {
	
	WebElement emailId = driver.findElement(By.id(emailIDLocator));
	emailId.sendKeys(emailID);

	WebElement enterPassword = driver.findElement(passwordLocator);
	enterPassword.sendKeys(password);
	
}

public void clickLoginButton() {
   WebElement loginButtonClick=driver.findElement(loginButton);
   loginButtonClick.click();
}

}
