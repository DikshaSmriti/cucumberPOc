Feature: Check accounts tab

  Background:
    Given User logs in to app with credentials
      | username                 | password    |
      | smritidiksha29@gmail.com | Qwerty12345 |

  Scenario: Check accounts page title
    Given user is on accounts page
    When user gets the title of the page
    Then page title should be "My account - My Store"

  Scenario: Check the accounts section count
    Given user is on accounts page
    Then user gets accounts options
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
    And accounts section count should be 5
