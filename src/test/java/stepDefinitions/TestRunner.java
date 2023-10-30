package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/login.feature"},
        glue = {"stepDefinitions", "hooks"},
        monochrome = true,
        plugin = {"pretty","html:src/test/resources/reports/loginTest.html",
                "json:src/test/resources/reports/loginTest.json",
                "junit:src/test/resources/reports/loginTest.xml"})

public class TestRunner {
}
