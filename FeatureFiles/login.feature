Feature: Login

  Scenario: Give invalid details and get error message
  
    Given Click on Login/Signup button and click on google
    And Redirecting to login page
    When Enter login details
    Then capture error message
