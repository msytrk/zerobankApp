@Reg
Feature:Login Page
  Background:
    Given the user is should be login page

  Scenario:Authorized user can be login
    When the should be able to enter "username" "password"
    Then the title should be "Zero - Account Summary"

  Scenario Outline:Invalid user can not  be login
    When the should be able to enter "<userName>" "<passWord>"
    Then the error message should display "Login and/or password are wrong."


    Examples:
      |userName    | passWord |
      |username    | wrong    |
      |wrong       | password |
      |username    |          |
      |            | password |
      |wrong       | wrong    |


