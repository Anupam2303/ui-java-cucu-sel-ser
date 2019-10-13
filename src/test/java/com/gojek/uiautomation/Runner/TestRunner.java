package com.gojek.uiautomation.Base.Runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/feature",
        tags = {""},
        monochrome = true,
        glue = {"com/gojek/uiautomation/Base/StepDefinitions"}
        )
public class TestRunner {

}