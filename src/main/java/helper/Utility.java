package helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	static WebDriver driver;
	
	public static void takeScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		//File des=new File(".\\src\\test\\resources\\screenshot\\Screenshot_"+Dateformat()+".png");
		//File des=new File(".\\screenshots\\Screenshot_"+Dateformat()+".png");
		File des=new File(System.getProperty("user.dir")+"\\screenshot\\Screenshot_"+Dateformat()+".png");
		System.out.println("Screenshot is captured");
		
		try {
			FileHandler.copy(src, des);
		} catch (IOException e) {
			System.out.println("Screenshot is not captured "+e.getMessage());
		}
	}
	
	public static String Dateformat()
	{
		Date d=new Date();
	SimpleDateFormat date=new SimpleDateFormat("dd_MM_YYYY_HH_mm_ss");
			String customdate=date.format(d);
		//System.out.println("Date is "+customdate);
		return customdate;
	}
	
	public static WebElement waitForElement(WebDriver driver, WebElement element,int duration)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}
	

}
