package manager;

import org.openqa.selenium.WebDriver;

import base.Base;
import configuration.ReadPropFile;
import pages.HomePage;
import pages.LoginPage;

public class PageObjectManager {
	private static ReadPropFile prop;
	private Base baseObj;
	private LoginPage loginPageObj;
	private HomePage homePageObj;

	public static ReadPropFile getPropObj() {
		return (prop == null) ? prop = new ReadPropFile() : prop;
	}

	public Base baseObj() {
		return (baseObj == null) ? baseObj = new Base() : baseObj;
	}

	public LoginPage getLoginPage(WebDriver driver) {
		return (loginPageObj == null) ? loginPageObj = new LoginPage(driver) : loginPageObj;
	}

	public HomePage getHomePage(WebDriver driver) {
		return (homePageObj == null) ? homePageObj = new HomePage(driver) : homePageObj;
	}
}
