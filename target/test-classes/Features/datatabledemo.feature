Feature: Demo on Datatable

  Scenario: user Registartion
    Given User is on register page
    When User enter following details
      | Fields          | Value      |
      | Gender          | Female     |
      | Firstname       | Larry      |
      | Lastname        | Bond       |
      | Email           | lb34@d.com |
      | Password        | test123    |
      | ConfirmPassword | test123    |
    Then User click on register
    And User register successfully

    