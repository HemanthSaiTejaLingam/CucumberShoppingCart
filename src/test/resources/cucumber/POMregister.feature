@pom
Feature: Checking the TestMeApp functionality
	@registernewuser
  Scenario: User successful registration on TestMe App
    Given The user opens the registration page
    When The user enters necessary details and registers
    |uname  |Narutouzu|
    |fname  |Naruto|
    |lname  |Hinata|
    |pass   |Pass1234|
    |cpass  |Pass1234|
    |gender |Male|
    |mail   |test@gamil.com|
    |mobile |7865645345|
    |dob    |01/01/2001|
    |address|Hyderabad, India|
    |ques   |What is your favour color?|
    |answer |black|
    Then user must successfully register