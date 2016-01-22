@jtrac-demo
Feature: Demonstrate how cucumber-jvm can help in test automation
	As an agile developer,
	I want to use an acceptance testing tool
	So that, I can write and automate my acceptance tests
	
## This scenario is similar to that of the unit test under
## the Selenium project ... 
## JtracTest.shouldLoginSuccessfullyWithValidCredential()

##   given_i_am_at_website(JTRAC_WEBSITE_DEFAULT_URL);
##   when_i_logged_in(ADMIN_USER, ADMIN_PSW);
##   then_i_should_see_the_dashboard("DASHBOARD");

@jtrac-login-scenario
Scenario: Logging into jtrac application
	Given I am at the website "http://192.168.1.172:8080/jtrac/app/login"
	When I enter user id "admin" and password "admin"
	And I click on the Submit button
	Then I should see a main page display "DASHBOARD" as a part of the menu.
	
##  given_i_logged_in_as_an_admin();
##	and_i_remove_user(TEST_LOGINID);
##	when_i_search_user(TEST_LOGINID);
##  then_i_should_not_see_any_user_in_the_table();

@jtrac-nonexistent-search-scenario
Scenario: Verifying empty search result when a user does not exist.
	Given I am at the website "http://192.168.1.172:8080/jtrac/app/login"
	And I enter user id "admin" and password "admin"
	And I click on the Submit button
	And I verify user "XyzAbc12" does not exist
	When I select Options
	And I select Manage Users
	And I select Login Name from the dropdown box
	And I enter user "XyzAbc12"
	And I click the Search button
	Then I should not see any entry in the search result table.
	

