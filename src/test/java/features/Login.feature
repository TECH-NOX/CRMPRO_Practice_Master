Feature: Login Featute
	This feature tests the login functionality
	
	Scenario: Valid Login 
		Given user is in CRMPro Url
		Then user provides valid username and password and logs-in to Home Page
		And user validates the title and username in HomePage