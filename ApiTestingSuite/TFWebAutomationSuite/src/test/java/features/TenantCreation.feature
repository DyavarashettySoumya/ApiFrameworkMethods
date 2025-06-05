Feature: Validating Tenant creation AP's
  @TenantCreation @Regression
  Scenario Outline: Verify if tenant is being Successfully created by TenantCreationApi calls
    Given create email payload with "<email>"
    When user calls "createEmail" with "POST" http request
    Then the API call got success with status code 200
    And Then "msg" in response body "Verify your email address. We just sent an OTP to your email address."
    Then create otp payload with "<email>" and <otp>
    When User calls "otp" with "POST" http request
    And "msg" in response body "Congratulations!. You have successfully verified your email address."
#    Then the API call got success with status code 200
    And verify tenantId create using "otp"
    Examples:
      | email                       | otp    |
      | Joson4@gatestautomation.com | 100000 |


#  Scenario Outline: Verify if tenant is being Successfully created by TenantCreationApi calls
#    Given create otp payload with "<email>" and "<otp>"
#    Then User calls "otp" with "POST" http request
#    Then the API call got success with status code 200
#    Then "msg" in response body "Congratulations!. You have successfully verified your email address."
#    And get "tenantId" using "otp" api call
#    Examples:
#      | email                       | otp    |
#      | sravya@gatestautomation.com | 100000 |

#  Scenario Outline: verifying tenantId creation by otp Api call
#    Given create otp payload with "<email>" and <otp>
#    When User calls "otp" with "POST" http request
##    Then the API call got success with status code 200
#    And verify tenantId create using "otp"
#    Examples:
#      | email                        | otp    |
#      | sravya2@gatestautomation.com | 100000 |