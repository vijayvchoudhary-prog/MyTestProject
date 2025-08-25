package utils;

import org.openqa.selenium.WebDriver;

public class Libs {

	private WebDriver driver;
	
	public Libs(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void prints()
	{
		System.out.println("This is test");
	}
}
