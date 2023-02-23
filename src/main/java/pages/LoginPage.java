package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	By username=By.name("email1");
	By pass=By.id("password1");
	By SigninButton=By.xpath("//button[text()='Sign in']");
	
	public void LoginintoApp(String uname, String password)
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(SigninButton).click();
		Utility.takeScreenshot(driver);
		
	}

}
