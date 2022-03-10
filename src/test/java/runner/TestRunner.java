package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\resources\\feature\\ecom.feature",
		glue="Stepdefs",
		tags="@tag5",
		plugin = {
				"pretty",
				"html:target/html/htmlReport.html",
	            "json:target/json/file.json",
		},
		monochrome = true,
		publish = true,
		dryRun=false
		
)
public class TestRunner {

}
