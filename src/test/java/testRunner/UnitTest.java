package testRunner;

import org.junit.After;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
//import org.testng.annotations.AfterTest;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
//import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/java/features", glue = { "stepDefs" }, dryRun = false, monochrome = true, 
		plugin = {"pretty", "html:target/HtmlReport",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" })

public class UnitTest {

	@After
	public void generateReports() {
		Reporter.loadXMLConfig(
				"Users/ramizramizmrr/eclipse-workspace/CRMPRO_Test_Suite/src/main/java/extentReports/extentReports.xml");
	}

}
