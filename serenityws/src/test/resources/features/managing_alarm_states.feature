Feature: Managing the alarm states
  As a Pi Sentry user,
  I want to manage the state of the alarm
  So that, I can use to protect my residence.
  
@arm_away
Scenario: Arming the system while away
  Given that PI Sentry Web Services is running
  And the system is not armed
  When I arm the system while away
  Then the system should be armed away
  
