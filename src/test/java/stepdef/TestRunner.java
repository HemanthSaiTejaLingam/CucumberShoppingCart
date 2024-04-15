package stepdef;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resources/Features/"
		+ "datatabledemo.feature",
glue= {"stepdef"},
plugin= {"json:target/cucumberJson/jsonreport.json",
		"html:target/cucumberHtml/htmlreport.html",
		"junit:target/cucumberjUnit/junit-report"},dryRun = true,
		monochrome =true)
public class TestRunner {

}
