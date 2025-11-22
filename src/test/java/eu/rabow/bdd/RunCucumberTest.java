package eu.rabow.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:eu/rabow/bdd",
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class RunCucumberTest {

}
