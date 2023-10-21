Feature : Login

Scenario : The user is able to login using correct credentials
	Given navigate to the URL of the application "http://www.saucedemo.com/"
	When the user inputs their registered username
	And the user enters their registered password
	And  the user clicks the login button
	Then the user should be logged in successfully
    