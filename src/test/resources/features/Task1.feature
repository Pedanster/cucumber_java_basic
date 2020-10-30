
Feature: Test


  Scenario Outline: test for error cases
    Given I am on page
    When I enter number: "<number>"
     And I click: "<submit>"
    Then I see message: "<message>"

    Examples:
      | Number  | message                 |
      |    45   | Number is too small     |
      |    178  | Number is too big       |
      |    babe | Please enter a number   |

    Scenario: test for correct number
      Given I am on page
      When I enter number: "<49>"
      And I click: "<submit>"
      Then I should see: "<textAlert>"




