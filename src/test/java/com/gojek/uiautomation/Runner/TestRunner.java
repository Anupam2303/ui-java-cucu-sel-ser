package com.gojek.uiautomation.Runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/feature",
        tags = {"@Test"},
        glue = {"com/gojek/uiautomation/StepDefinitions"}
        )
public class TestRunner {

}