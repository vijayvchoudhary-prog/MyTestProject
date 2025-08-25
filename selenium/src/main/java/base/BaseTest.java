package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import utils.Libs;

public class BaseTest {
	
	protected WebDriver driver;
	protected Libs libs;
	
	@BeforeMethod
	public void setUp()
	{
		
		
		String browser = ConfigReader.get("browser");
		String baseUrl = ConfigReader.get("baseUrl");
		
		driver = getDriver(browser);
		driver.get(baseUrl);

		libs = new Libs(driver); // Initialize once here
	}
	

	@AfterMethod
	public void tearDown()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
	
	
	public WebDriver getDriver(String browser)
	{
		WebDriver _driver = null;
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			_driver = new ChromeDriver();	
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			_driver = new FirefoxDriver();
		}
		else
		{
			throw new RuntimeException("Unsupported browser: " + browser);

		}
		
		_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		_driver.manage().window().fullscreen();
		
		return _driver;
	}
}
