#Feature: Validating TenantId AP's
#	@TenantCreation @Regression
#	Scenario Outline: Verify if tenant is being Successfully created by TenantCreationApi calls
#		Given create email payload with "<email>"
#		When user calls "createEmail" with "POST" http request
#		Then the API call got success with status code 200
#		And Then "msg" in response body "Verify your email address. We just sent an OTP to your email address."
#		And create otp payload with "<email>" and "<otp>"
#		Then User calls "otp" with "POST" http request
#		Then the API call got success with status code 200
#		Then "msg" in response body "Congratulations!. You have successfully verified your email address."
#		And get "tenantId" using "otp" api call
#		Examples:
#			| email                       | otp    |
#			| sravya@gatestautomation.com | 100000 |



#@DeletePlace @Regression
#Scenario: Verify if Delete Place functionality is working
#
#	Given DeletePlace Payload
#	When user calls "deletePlaceAPI" with "POST" http request
#	Then the API call got success with status code 200
#	And "status" in response body is "OK"
	 


	

	
	
	
	
	
	

	
	
	