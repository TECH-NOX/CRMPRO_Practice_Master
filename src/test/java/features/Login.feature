Feature: Login Featute
	Description: This feature tests the login functionality
	
	#Background: Create Objects for Extent Reports
	#	When extent reports are handled
		
	Scenario: Valid Login 
		Given user is in CRMPro Url
		Then user provides valid username and password and logs-in to Home Page
		And user validates the title and username in HomePage
	
	
	Scenario: Invalid Login
		Given user is in CRMPro Url
		Then user provides INvalid username and password and logs-in 
		And user validates crmpro is not logged in