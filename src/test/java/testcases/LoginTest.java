package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import base.BaseClass;
import dataProvider.CustomDataProvider;

public class LoginTest extends BaseClass{
	

	@Test(dataProvider="EmpLogin", dataProviderClass=CustomDataProvider.class)
	public void LoginIntoApplication(String username, String password)
	{
		LoginPage login=new LoginPage(driver);
		login.LoginintoApp(username, password);
		Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Sign out']")).isDisplayed());
	}

}
