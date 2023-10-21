Feature: Checkout

Scenario: The user add quantity product.
	Given User navigates to the webpage "https://www.saucedemo.com/" in their browser
	When The user successfully log in using the correct username
	And The user select the item "Sauce Labs Fleece Jacket"
	And The user click the "Add to Cart" button
	And The user click the "Shopping Cart" button
	And in the cart, The user add a quantity to the product
	And The user click the "Checkout" button
	And The user provide their first name, last name, and ZIP/postal code
	And The user click the "Continue" button
	And the user click the "Finish" button
	The the transaction should be completed successfully
    