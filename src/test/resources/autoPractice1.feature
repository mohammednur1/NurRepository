@smokeTest @regrationTest
Feature: Verify checkout feature on Automation Practice website 
Scenario: User successfully checkout on automation practice website 
	Given user go the the automation homepage 
	When user click on the sign in button 
	And user enter valid email and password 
	And user click on sign in button 
	Then user navigate to the home page 
	And user verify the page title as "My account - My Store"
	Then user go to the upper left corner and select Dresses 
	And user click on sort by highest order 
	Then user select the second highest item
	And user click on add to cart button
	Then user verify the total price and the shipping fee on checkout page
	And user sign out 
	And user close the window