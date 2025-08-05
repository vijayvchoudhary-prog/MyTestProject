package tests;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.loginPage;

public class loginTest extends BaseTest {

	//sample test
	@Test
	public void validLogin()
	{
		loginPage login = new loginPage(driver);
		login.login("Admin", "admin123");
	}
}
