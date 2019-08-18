package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/java/features", glue = { "stepDefs" }, dryRun = false, monochrome = true, plugin = {
				"pretty", "html:target/HtmlReport" })

public class UnitTest {

}
