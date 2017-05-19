Feature: Check System Status for Tomcat 8 instance 
	As a System Admin,
	I want to check a list of applications that are deployed
	So that I can monitor their status.
	
@tomcat-0-more-app-names
Scenario: Login to a Tomcat 8 Server 
	Given I am at the default tomcat website "http://192.168.99.100:8888" 
	When I access Server Status with user "tomcat" and password "Tomcat!@#" 
	Then I should see 0 or more application names displayed 
	 