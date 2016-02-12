Feature: Accepting credit card 
	As a pet lover,
    I want to adopt a pet using my credit card
    So that I can pay for it later.
  
@accepting_creditcard 
Scenario: Adopting a pet using credit card 
	Given I am at Puppy Adoption Agency website "http://puppies.herokuapp.com" 
	When I adopt these pets: 
		| Brook | 
	And I pay for the adoption with: 
		| name     | address                                   | email         | payType      |
		| John Doe | 123 Main Street, Somewhere, Virginia, USA | jdoe@mail.com | Credit card  |
	Then I should see a message "Thank you for adopting a puppy!" 