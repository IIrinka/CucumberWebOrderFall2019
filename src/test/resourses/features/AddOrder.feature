Feature: Add order
  As user, I want to be able to create new orders


  @First
  Scenario: 1. Verify product information
    Given user is on login page
    And user logs in
    And user navigates to "Order" page
    When user enters product information
      | Product     | Quantity | Price per unit | Discount |
      | ScreenSaver | 12       | 28             | 10%      |
    And user click on calculator button
    Then user should verify that total 216 is displayed

    When user enters address information
      | Customer name | Street  | City     | State    | Zip   |
      | Test User     | 5th Ave | New York | New York | 10011 |
    And user enters payment information:
      | Card | Card Nr  | Expire date (mm/yy) |
      | Visa | 123456789 | 04/25               |
    And user click on process button
    And user navigates to check "View all orders" page
    Then user verifies that order is displayed
      | Name      | Product     |
      | Test User | ScreenSaver |