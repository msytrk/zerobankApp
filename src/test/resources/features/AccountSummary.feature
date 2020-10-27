@Reg
Feature:AccountSummary Page
  Background:
    Given the user is should be login page
    When the should be able to enter "username" "password"

  Scenario:Page title verify
    Then the title should be "Zero - Account Summary"
  Scenario:Account Types
    Then the Account Summary page should have to following account types
      |Cash Accounts|
      |Investment Accounts|
      |Credit Accounts|
      |Loan Accounts|
  Scenario:Credit Accounts table
    Then the Credit Accounts table should have to following account types
      |Account    |
      |Credit Card|
      |Balance    |

