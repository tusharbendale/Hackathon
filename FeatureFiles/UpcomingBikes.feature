Feature: upcoming bikes

  Scenario: Get Bike Details
    Given Verifing HomePage title
    And Hover on new bikes
    And verifing upcoming bikes option
    When User clicked on upcoming bike option
    Then Verify clicked or not on upcoming bike
    When click on manufacturer and select honda from dropdown and click on view more
    Then verify honda is selected or not
    And get all Bike details for selected manufacturer
