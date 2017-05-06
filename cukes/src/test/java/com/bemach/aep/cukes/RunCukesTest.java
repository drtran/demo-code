package com.bemach.aep.cukes;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

// You can run this test using maven command as follows:
// mvn -DwebDriver=FIREFOX -Dtest=com.bemach.aep.cukes.RunCukesTest clean test 
// mvn -DwebDriver=CHROME -Dwebdriver.chrome.driver=c:\csd-work\win\bin\misc\chromedriver.exe 
//     -Dtest=com.bemach.aep.cukes.RunCukesTest clean test 
//   

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features"
 , tags = {"@adopting_one_pet"}
)
public class RunCukesTest {

}
