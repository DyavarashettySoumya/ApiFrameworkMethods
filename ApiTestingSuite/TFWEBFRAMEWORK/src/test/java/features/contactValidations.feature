Feature: Validating Contact API's
@AddPlace @Regression
Scenario Outline: Verify if Contact is being Succesfully added using AddContactAPI
	Given Add Place Payload with "<firstName>","<lastName>","<email>"
	When user calls "AddContactAPI" with "POST" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	And verify contact_Id created maps to "<_id>" using "getContactAPI"
	Examples:
		| firstName | lastName | email                    |  |
		| man       | Anna     | man@gatestautomation.com |  |


	@DeletePlace @Regression
Scenario: Verify if Delete Place functionality is working
	Given DeletePlace Payload
	When user calls "deletePlaceAPI" with "POST" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"


#@TenantCreation
#Scenario: Verify if tenant is getting creating successfully
#	Given create email payload with "<email>"
#	When the API call got success with status code 200
#	Then "msg" in response body "Verify your email address. We just sent an OTP to your email address."
#	And otp payload with "<email>" and "<otp>"
#	When the API call got success with status code 200
#	Then "msg" in response body "Congratulations!. You have successfully verified your email address."
#	And get "tenantId" using otp api call


	 


	

	
	
	
	
	
	

	
	
	