package com.bemach.aep.serenity;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * <code>
 * mvn -Dtest=com.bemach.aep.serenity.RunSerenityTest -Dcucumber.options="--tags@adopting_one_pet" verify
 *
 * -Dwebdriver.driver=chrome -Dwebdriver.chrome.driver=C:\drkiettran\bin\misc\chromedriver.exe
 * 
 * </code>
 * 
 * @author ktran
 *
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features"
// , tags = { "@not_accepting_with_blank_email, @not_accepting_with_blank_name"
// }
// , tags = { "@adopting_one_pet, @adopting_multiple_pets,
// @accepting_creditcard" })
		, tags = { "@tomcat-verify-example-code" })
public class RunSerenityTest {
}
