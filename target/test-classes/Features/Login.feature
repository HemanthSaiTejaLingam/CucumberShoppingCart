Feature: Registered user login Valid login

  Scenario: The one where registered user login successfully
    Given joe is on loginpage
    When joe enters credentials
    And clicks on login button
    Then Demowebshop homepage display

