package browserFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class BrowserFactory {
	public static WebDriver driver;
	
	public static WebDriver startBrowser(String BrowserName, String URL)
	{	
		
		if(BrowserName.equalsIgnoreCase("Chrome")|| BrowserName.equalsIgnoreCase("Google Chrome"))
		{
			driver=new ChromeDriver();
			Reporter.log("Chrome started",true);
		}
		else if(BrowserName.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
			Reporter.log("Firefox started",true);
		}
		else if(BrowserName.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
			Reporter.log("Edge started",true);
		}
		else
		{
			driver=new ChromeDriver();
			Reporter.log("Default browser Chrome started",true);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		return driver;
		
	}

}
