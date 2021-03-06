@adopting_pets
Feature: Adopting pets from Puppy Adoption Agency
	As a pet lover,
    I want to adopt one or more pet
    So that they can chew on my furniture.

@adopting_one_pet
Scenario: Adopting one pet without additional products or services successfully
	Given I am at Puppy Adoption Agency website "http://puppies.herokuapp.com"
	When I adopt these pets:
		| Twinkie |
	And I pay for the adoption with:
		| full name | street address                            | email address | payment type |
		| John Doe  | 123 Main Street, Somewhere, Virginia, USA | jdoe@mail.com | Check        |
	Then I should see a message "Thank you for adopting a puppy!"

@adopting_multiple_pets
Scenario Outline: Adopting multiple pets without additional products or services with different type of pays
	Given I am at Puppy Adoption Agency website "http://puppies.herokuapp.com"
	When I adopt these pets:
		| <pet_1> |
		| <pet_2> |
	And I pay for the adoption with:
		| full name | street address                            | email address | payment type |
		| John Doe  | 123 Main Street, Somewhere, Virginia, USA | jdoe@mail.com | <payType>    |
	Then I should see a message "Thank you for adopting a puppy!"
	Examples:
		| payType        | pet_1      | pet_2   |
		| Check          | Brook      | Twinkie |
		| Credit card    | Maggie Mae | Tipsy   |
		| Purchase order | Ruby Sue   | Sparky  |

