package stepDefs;

import org.junit.Assert;
//import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import base.Base;
import configuration.ReadPropFile;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import manager.PageObjectManager;
import pages.HomePage;
import pages.LoginPage;
import utility.ReusableMethods;

public class LoginStepDefinition extends Base {
	WebDriver driver;
	ReadPropFile prop;
	PageObjectManager pageObjectManagerObj;
	LoginPage loginPageObj;
	HomePage homePageObj;

	@Before()
	public void browserSetUp() {
		
		driver = Base.setUp();
		pageObjectManagerObj = new PageObjectManager();
		loginPageObj = pageObjectManagerObj.getLoginPage(driver);
	}

	@Given("^user is in CRMPro Url$")
	public void user_navigates_to_CRMPro_Url() {
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.",
				driver.getTitle());
	}

	@Then("^user provides valid username and password and logs-in to Home Page$")
	public void user_provides_valid_username_and_password_and_logs_in_to_Home_Page() {
		// This method Logs in using credentials provided in Properties file
		loginPageObj.login();
	}

	@Then("^user validates the title and username in HomePage$")
	public void user_validates_the_title_and_username_in_HomePage() {
		homePageObj = pageObjectManagerObj.getHomePage(driver);
		// Validating Home Page Title
		Assert.assertEquals(homePageObj.getHomePageTitle(), "CRMPRO");
		// Validating Username in HomePage
		ReusableMethods.switchtoFrame(driver, "mainpanel");
		Assert.assertEquals(homePageObj.getHomePageUserName(), "User: tech nox");
	}

	@Then("^user provides INvalid username and password and logs-in$")
	public void user_provides_INvalid_username_and_password_and_logs_in() {
		loginPageObj.login("technox", "Test12");
	}

	@Then("^user validates crmpro is not logged in$")
	public void user_validates_crmpro_is_not_logged_in() {
		System.out.println(loginPageObj.getLoginPageTitle());
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.",
				loginPageObj.getLoginPageTitle());
	}

	@After()
	public void tearD() {
		Base.tearDown();
	}

}
