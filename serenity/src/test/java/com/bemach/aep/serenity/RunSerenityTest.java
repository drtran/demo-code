package com.bemach.aep.serenity;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

// mvn -Dtest=com.bemach.aep.serenity.RunSerenityTest -Dcucumber.options="--tags@adopting_one_pet" verify

/**
 * @author ktran
 *
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features"
//, tags = { "@adopting_one_pet" }
)
public class RunSerenityTest {
}
