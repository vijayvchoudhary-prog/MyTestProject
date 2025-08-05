package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.loginPage;

public class loginTest2 extends BaseTest {

	@Test
	public void invalidLogin()
	{
		loginPage login = new loginPage(driver);
		login.login("Admin", "admin123");
	}
}
