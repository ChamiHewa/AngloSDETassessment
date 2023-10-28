# Chamalika Hewawitharana
# 23.10.2023
# SDET Assessment1

@RegressionTest
Feature: Feature to test  user login functionality

  Scenario Outline: When I go to Login Page, and login with valid credentials,
  I expect to successfully login and see the MY ACCOUNT page

    Given user is on login page
    When user enters <username> and <password>
    And clicks on Login button
    Then user is navigates to the landing page successfully
    Examples:
      | username  | password |
      | ChamiTest | Test123  |

  Scenario Outline: When I go to Login Page, and login with invalid credentials,
  I expect to see a valid error message

    Given user is on login page
    When user enters <username> and <password>
    And clicks on Login button
    Then user gets a valid error message
    Examples:
      | username   | password |
      | AAA        | 123      |
      | !@#$%^guhj | $%&*GHJ  |