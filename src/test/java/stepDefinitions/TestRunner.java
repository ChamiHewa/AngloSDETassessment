package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/login.feature","src/test/resources/features/filterProducts.feature"}, glue = {"stepDefinitions"},
        monochrome = true,
        plugin = {"pretty","html:src/test/resources/reports/loginTest.html"})

public class TestRunner {
}
