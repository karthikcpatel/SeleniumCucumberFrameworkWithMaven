package newRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features={"features"},
glue={"newStepDefinition"},
plugin={"html:target/cucumber-html-report","json:target/cucumber.json", "rerun:target/rerun.txt"}
)

/*@CucumberOptions(features=".",
glue={"newStepDefinition"},
plugin={"html:target/cucumber-html-report","json:target/cucumber.json",
"rerun:target/rerun.txt"}
)*/

public class TestRunner {
}




