package com.bemach.aep.cukes;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

// You can run this test using maven command as follows:
// mvn -Dtest=com.bemach.aep.cukes.RunCukesTest clean test 
//

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features"
// , tags = {"@adopting_two_pets"}
)
public class RunCukesTest {

}
