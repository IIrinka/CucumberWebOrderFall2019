Feature:  Add order
  As user, Iwant to be able to create new oreder

  Scenario: Create order
    Given user is on the login page
    And user logs in
    And user navigates to "Order" page
    When User enters product information:
    |Product|Quality|Price per unit|Discount|
    |ScreenSaver|12 |20            |10%      |
    And user click on calculate button
    Then user should verify that total 216 is displayed
    When User enters adress information:
    |Customer name|Street|City|State|Zip|
    |Test user    |5 Avenue|New York| New York|10011|
    And user enters payment information:
    |Card|Card Nr:|Expire date (mm/yy)|
    |Visa|12345678|04/25              |
    And user click on prosses button
    And user navigates to "View all orders" page
    Then user verify that order displayed
    |Name|Product|
