package testRunner;

import org.junit.Test;

import base.Base;
import pages.HomePage;
import pages.LoginPage;

public class UnitTest {
	LoginPage loginPageObj;
	HomePage homePageObj;

	@Test
	public void testRun() throws InterruptedException {
		loginPageObj = new LoginPage();
		Base.setUp();
		loginPageObj.login();
		homePageObj = new HomePage();
		homePageObj.navigateToCalendarPage();
		Base.tearDown();
	}

}
