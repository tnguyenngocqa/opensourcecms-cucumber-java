Feature: Registration Tests
  Description: The purpose of this feature is to test registration.

  Background:
    Given I am on the CMS Main Home Page
    When I register for a free account

  @smoke
  Scenario Outline: Successful register a new account with valid account details
    And I enter account details as follows "<name>" and "<email>" and "<password>" and "<repeat_password>"
    And I attempt to create a new account
    Then The account should be created successfully verified with message "The user has been created. An activation email has been sent"
    Examples:
      | name          | email                          | password      | repeat_password |
      | opensourcecms | opensourcecms@mailinator.com | opensourcecms | opensourcecms   |

  @wip
  Scenario Outline: Unsuccessful register a new account with empty fields
    And I enter account details as follows "<name>" and "<email>" and "<password>" and "<repeat_password>"
    And I attempt to create a new account
    Then The account should be created successfully verified with message "<error_list>"
    Examples:
      | name          | email                        | password      | repeat_password | error_list                               |
      |               | opensourcecms@mailinator.com | opensourcecms | opensourcecms   | Name: this field is required.            |
      | opensourcecms |                              | opensourcecms | opensourcecms   | Email: this field is required.           |
      | opensourcecms | opensourcecms@mailinator.com |               | opensourcecms   | Password: this field is required.        |
      | opensourcecms | opensourcecms@mailinator.com | opensourcecms |                 | Second password: this field is required. |
      |               |                              |               |                 |                                          |

  @wip
  Scenario Outline: Unsuccessful register a new account with existing email
    And I enter account details as follows "<name>" and "<email>" and "<password>" and "<repeat_password>"
    And I attempt to create a new account
    Then The account should be created successfully verified with message "<error_list>"
    Examples:
      | name          | email                        | password      | repeat_password | error_list                               |
      |               | opensourcecms@mailinator.com | opensourcecms | opensourcecms   | Name: this field is required.            |
      | opensourcecms |                              | opensourcecms | opensourcecms   | Email: this field is required.           |
      | opensourcecms | opensourcecms@mailinator.com |               | opensourcecms   | Password: this field is required.        |
      | opensourcecms | opensourcecms@mailinator.com | opensourcecms |                 | Second password: this field is required. |
      |               |                              |               |                 |                                          |

  @wip
  Scenario Outline: Unsuccessful register a new account with passwords don't match.
    And I enter account details as follows "<name>" and "<email>" and "<password>" and "<repeat_password>"
    And I attempt to create a new account
    Then The account should be created successfully verified with message "<error_list>"
    Examples:
      | name          | email                        | password      | repeat_password | error_list                               |
      |               | opensourcecms@mailinator.com | opensourcecms | opensourcecms   | Name: this field is required.            |
      | opensourcecms |                              | opensourcecms | opensourcecms   | Email: this field is required.           |
      | opensourcecms | opensourcecms@mailinator.com |               | opensourcecms   | Password: this field is required.        |
      | opensourcecms | opensourcecms@mailinator.com | opensourcecms |                 | Second password: this field is required. |
      |               |                              |               |                 |                                          |
