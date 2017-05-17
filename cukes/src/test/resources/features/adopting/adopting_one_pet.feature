Feature: Adopting one pet from Puppy Adoption Agency 
	As a pet lover,
    I want to adopt a pet
    So that it can choose my furniture.
  
  
@adopting_one_pet
Scenario: Adopting one pet successfully 
	Given I am at Puppy Adoption Agency website "http://puppies.herokuapp.com" 
	When I click on View Details button for a pet name "Brook" 
	And I click on Adopt Me! button 
	And I click on Complete the Adoption button 
	And I fill out the payment details "John Doe", "123 Main Street, New York, NY 10001", "jdoe@mail.com", "Check" 
	And I click on Place Order button 
	Then I should see a message "Thank you for adopting a puppy!" 
	
  