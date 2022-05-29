package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

public class RunParalel2 {
    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin={"html:target\\Pcucumber-reports2.html",
                    "json:target/json-reports/Pcucumber2.json",
                    "junit:target/xml-report/Pcucumber2.xml"},
            features="src/test/resources",
            glue = "stepdefinitions",
            tags="@paralel2",
            dryRun = false
    )

    public class ParalelTestRunner2 {
    }
}
