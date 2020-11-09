package com.hiyar1.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features",
        glue = "com/hiyar1/step_definitions",
        tags = "@librarians"



)


public class CukesRunner {
}
