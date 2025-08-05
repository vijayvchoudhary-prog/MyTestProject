package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;


public class loginPage {

	WebDriver driver;

	@FindBy(how=How.XPATH,using=".//input[@name='username']")
	WebElement userName;
	
	@FindBy(xpath=".//input[@name='password']") 
	WebElement userPassword;
	
	@FindBy(xpath=".//button[@type='submit']") 
	WebElement submit;

	
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	public void login(String userId, String password)
	{
		userName.sendKeys(userId);
		userPassword.sendKeys(password);
		submit.click();
	}
}
