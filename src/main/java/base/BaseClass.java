package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import browserFactory.BrowserFactory;
import dataProvider.ConfigReader;

public class BaseClass {
	
	public WebDriver driver;
	@BeforeClass
	public void setup()
	{
		driver=BrowserFactory.startBrowser(ConfigReader.getProperty("Browser"), ConfigReader.getProperty("URL"));
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		System.out.println("LOG-INFO: Closing the browser");
	}

}
