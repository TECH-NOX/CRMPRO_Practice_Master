package testRunner;

import org.junit.Test;

import base.Base;
import pages.LoginPage;

public class UnitTest {
	LoginPage loginPageObj;

	@Test
	public void testRun() throws InterruptedException {
		loginPageObj = new LoginPage();
		Base.setUp();
		loginPageObj.login();
		Base.tearDown();
	}

}
