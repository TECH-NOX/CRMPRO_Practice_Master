package stepDefs;

import base.Base;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utility.ReusableMethods;

public class LoginStepDefinition extends Base {

	LoginPage loginPageObj = null;
	HomePage homePageObj = null;

	@Before
	public void browserSetUp() {
		loginPageObj = new LoginPage();
		Base.setUp();
	}

	@Given("^user is in CRMPro Url$")
	public void user_navigates_to_CRMPro_Url() {
	}

	@Then("^user provides valid username and password and logs-in to Home Page$")
	public void user_provides_valid_username_and_password_and_logs_in_to_Home_Page() {

		// This method Logs in using credentials provided in Properties file
		loginPageObj.login();
	}

	@Then("^user validates the title and username in HomePage$")
	public void user_validates_the_title_and_username_in_HomePage() {
		homePageObj = new HomePage();
		//Validating Home Page Title
		Assert.assertEquals(homePageObj.getHomePageTitle(), "CRMPRO");
		//Validating Username in HomePage
		ReusableMethods.switchtoFrame(driver, "mainpanel");
		Assert.assertEquals(homePageObj.getHomePageUserName(), "User: tech nox");
	}

	@After
	public void tearD() {
		Base.tearDown();
	}

}
