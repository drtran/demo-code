@tomcat-tests 
Feature: Check System Status for Tomcat 8 instance 
	As a System Admin,
	I want to check a list of applications that are deployed
	So that I can monitor their status.
	
@tomcat-0-more-app-names 
Scenario: Login to a Tomcat 8 Server 
	Given I am at the default tomcat website "http://localhost:8080" 
	When I access Server Status with user "tomcat" and password "Tomcat!@#" 
	Then I should see 0 or more application names displayed 
	
@tomcat-verify-example-code 
Scenario: Verifying example code 
	Given I am at the default tomcat website "http://localhost:8080" 
	And I access Manager App with user "tomcat" and password "Tomcat!@#" 
	When I search source code for "Hello World" as a "Servlets examples" 
	Then I should see the following line of code "class HelloWorld extends HttpServlet" 
	
@tomcat-verify-example-code-substitute 
Scenario Outline: Verifying example code - using substitute table 
	Given I am at the default tomcat website "http://localhost:8080" 
	And I access Manager App with user "tomcat" and password "Tomcat!@#" 
	When I search source code for "<exampleName>" as a "<exampleType>" 
	Then I should see the following line of code "<expectedSourceCode>" 
	Examples: 
		| exampleType       | exampleName       | expectedSourceCode                    |
		| Servlets examples | Hello World       | class HelloWorld extends HttpServlet  |
		| Servlets examples | Request Info      | class RequestInfo extends HttpServlet |
	 	