package com.weborders.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        glue = "com/weborders/step_definitions",
        features = "src/test/resourses/festures",
        dryRun = true,
        strict = false,
        tags = "@First",
        plugin = { "html:target/default-report",
                    "json:target/cucumber1.json" }
)
public class CucumberRunner {

}
