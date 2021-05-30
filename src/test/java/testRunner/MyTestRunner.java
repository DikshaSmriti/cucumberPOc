package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features= {"src/test/resources/featureFiles/appFeatures"},
            glue = {"stepDefinitions","appHooks"},
            plugin = {"pretty",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                    "timeline:test-output-thread/",
                        "json:target/reports/report.json",
                        "junit:target/reports/report.xml"}
//            monochrome = false,
//            publish = true
//            dryRun = true
    )
    public class MyTestRunner {
}
