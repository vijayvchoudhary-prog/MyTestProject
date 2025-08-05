package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.manage().window().fullscreen();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	

	@AfterMethod
	public void tearDown()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
}
