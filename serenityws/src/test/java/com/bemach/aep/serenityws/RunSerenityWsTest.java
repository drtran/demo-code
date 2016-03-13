package com.bemach.aep.serenityws;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

// mvn -Dtest=com.bemach.aep.serenity.RunSerenityWsTest -Dcucumber.options="--tags@arm_away" verify

/**
 * @author ktran
 *
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features"
, tags = { "@arm_away" })
public class RunSerenityWsTest {
	
}
