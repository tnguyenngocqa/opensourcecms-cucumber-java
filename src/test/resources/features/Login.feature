Feature: Login Tests

  Description: The purpose of this feature is to test logging in.

  Background:
    Given I am on the CMS Main Home Page
    And I am on the CMS Login Page

  @smoke
  Scenario Outline: Successful login with valid credentials
    When I attempt to login as "<user_role>" with "<email>" and "<password>"
    Then I should see my account logged in successfully
    Examples:
      | user_role         | email                      | password              |
      | admin             | test@test.com              | abc.123               |
#      | sale_manager      | sale_manager@test.com      | sale_manager.123      |
#      | contact_point     | contact_point@test.com     | contact_point.123     |
#      | warehouse_manager | warehouse_manager@test.com | warehouse_manager.123 |
#      | finance_manager   | finance_manager@test.com   | finance_manager.123   |

  @regression
  Scenario Outline: Unsuccessful login with empty or wrong credentials
    When I attempt to login as "admin" with "<email>" and "<password>"
    Then I should see the error messages "<error_messages>"
    Examples:
      | email         | password      | error_messages                                                                              |
      | test@test.com |               | Empty passwords are not allowed. Please provide a password                                  |
      |               | opensourcecms | Please provide an email address                                                             |
      |               |               | Please provide an email address/nEmpty passwords are not allowed. Please provide a password |

  @wip
  Scenario: Unsuccessful login with the user has not been validated yet
    When I attempt to login as "admin" with "<email>" and "<password>"
    Then I should see the error messages "The user has not been validated yet"

  @wip
  Scenario: Unsuccessful login with the user doesn't exist
    When I attempt to login as "admin" with "<email>" and "<password>"
    Then I should see the error messages "The user doesn't exist"



