#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@datatable
Feature: Checking the TestMeApp functionality
	@register
  Scenario: The one where user successfully registers on TestMeApp
    Given The user is on Register page
    When The user enters the following details
    |uname  |NaruHinata1|
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
    And clicks on register button
    Then the user must register successfully

  @search
  Scenario Outline: When the user search for a product in TestMe App
    Given the user is in home page of the TestMe App
    When user search for "<product>" in the search box
		Then TestMeApp display products matching with the keyword

    Examples: 
      | product  |
      | travel   |
      | phone    |
      | bag      |
