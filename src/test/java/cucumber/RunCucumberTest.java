package cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/cucumber/DataTableRegistration.feature",
		"src/test/resources/cucumber/expressions.feature",
		"src/test/resources/cucumber/login.feature",
"src/test/resources/cucumber/POMregister.feature"},
plugin= {"pretty","json:cucumberReports/Json/reportall.json",
		"html:cucumberReports/Html/reportall.html",
"junit:cucumberReports/junit/Junit-reportall"},
dryRun = true,
monochrome =true)

public class RunCucumberTest {

}
