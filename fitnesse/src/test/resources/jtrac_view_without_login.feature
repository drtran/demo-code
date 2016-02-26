@jtrac_view_open_issues_no_login
Feature: Viewing open issues without authentication
  As a JTrac user, 
  I want to view a list of all open issues without login
  So that I can determine if I need to open a new ticket for my issue.

  Scenario: Viewing a summary of open issues.
    Given the system has "3" open issues on "Help Desk"
    When I am at the JTrac website "http://pidev4:8080/jtrac/app"
    Then I should see an indicator of "3" open issues on the page.
    
  Scenario: Viewing a list of open issues. 
    Given I am at the JTrac website "http://pidev4:8080/jtrac/app"
    And the system has "3" open issues on "Help Desk"
    When I click on seeing detail
    Then I should see a list of "3" open issues.