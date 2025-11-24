package eu.rabow.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:eu/rabow/bdd",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "html:reports/cucumber-reports/cucumber-report.html","json:target/cucumber-reports/cucumber.json"},
        tags = "not @Ausbaustufe"
        )

public class RunCucumberTest {

}
