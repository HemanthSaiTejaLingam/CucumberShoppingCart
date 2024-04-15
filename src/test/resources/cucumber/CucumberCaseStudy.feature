@casestudy
Feature: Testing Functionalities of TestMe App
@register
Scenario: The one where user successfully registers on TestMeApp
    Given user is on Register page
    When The user enters the username as "NarutoHap"
    And enters the firstname as "Naruto"
    And enters the lastname as "Hinata"
    And enters the password as "Pass1234"
    And enters the confirm password as "Pass1234"
    And enters the gender as "Male"
    And enters the mail as "test@gamil.com"
    And enters the mobile as "7865645345"
    And enters the dob as "01/01/2001"
    And enters the address as "Hyderabad, India"
    And enters the question as "What is your favour color?"
    And enters the answer as "black"
    And clicks register button
    Then the use registers successfully

@login
Scenario Outline: User successfully logins when enter valid credentials else not
				Given user is on log in page of TestMe App
				When user enters his "<username>" and "<password>"
				And clicks login button
				Then user logins navigates to home page if credentials are valid
				Examples: 
				| username | password |
				| AlexUser | Alex@123 |
				| JoeUser  | Joe@123  |
				
@search
Scenario Outline: When the user search for a product in TestMe App
    Given the user is in home page of the TestMe App
    When user search for "<product>" in the search box
		Then TestMeApp display products matching with the keyword

    Examples: 
      | product  |
      | tra      |
      | phon     |
      | bag      |