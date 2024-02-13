package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import steDefs.TestBase;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steDefs", // this is how it knows where are the steps to run
        plugin = { "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cukes.xml",
                "rerun:target/rerun.txt"},
        tags = "@Smoke" // this means that all @smoke scenarios will run all positive scenarios from all features

)
public class Runner extends AbstractTestNGCucumberTests {

}
