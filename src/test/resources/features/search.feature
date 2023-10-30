# Chamalika Hewawitharana
# 28.10.2023
# SDET Assessment1

@RegressionTest
Feature: Feature to test product filtering based on Name-Type

  Scenario Outline: When I go to Home Page, and enter a valid product name on the search bar,
  I expect to see the relevant search results

    Given that I am on the Home page
    When I add <product> to the search box
    And click the Search Button
    Then I should be able to see all the relevant search results according to the <product>
    Examples:
      | product |
      | Alleg   |
      | nail    |

  Scenario Outline: When I go to Home Page, and enter a invalid product name on the search bar,
  I expect to see a message saying "No such results"

    Given that I am on the Home page
    When I add <product> to the search box
    And click the Search Button
    Then I should be able to see a text with No such Results
    Examples:
      | product   |
      | test      |
      | %^&*VHBJN |

  Scenario Outline: When I go to Home Page, and enter a valid product name with invalid product type on the search bar,
  I expect to see the relevant search results

    Given that I am on the Home page
    When I select the <product_type>
    And I add <product> to the search box
    And click the Search Button
    Then I should be able to see a text with No such Results
    Examples:
      | product  | product_type |
      | lipstick | Books        |

