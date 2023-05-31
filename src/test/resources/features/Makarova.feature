@makarova_test_cases
Feature: Test Cases
  Background:
    Given I open url "http://ask-stage.portnov.com/#/registration"
  @makarova_test_cases_positive
  Scenario Outline:
    When I type "<Password>" into element with xpath "//input[@formcontrolname='password']"
    And I type "<Password>" into element with xpath "//input[@formcontrolname='confirmPassword']"
    And I type "Anna" into element with xpath "//input[@formcontrolname='firstName']"
    And I type "M" into element with xpath "//input[@formcontrolname='lastName']"
    And I type "2@g.com" into element with xpath "//input[@formcontrolname='email']"
    And I type "ABC" into element with xpath "//input[@formcontrolname='group']"
    And I click on element with xpath "//*[contains(text(),'Register Me')]"
    And I wait for element with xpath "//h4[contains(text(),'You have been Registered')]" to be present
    Then element with xpath "//h4[contains(text(),'You have been Registered')]" should be displayed
    Examples:
      | Password                         |
      | Tre!@#12345                      |
      | 12345                            |
      | 12345678901234567890123456789012 |
  @makarova_test_cases_negative
  Scenario Outline:
    When I type "<Password>" into element with xpath "//input[@formcontrolname='password']"
    And I type "<Confirm Password>" into element with xpath "//input[@formcontrolname='confirmPassword']"
    When I type "Anna" into element with xpath "//input[@formcontrolname='firstName']"
    And I type "M" into element with xpath "//input[@formcontrolname='lastName']"
    And I type "2@g.com" into element with xpath "//input[@formcontrolname='email']"
    And I type "ABC" into element with xpath "//input[@formcontrolname='group']"
    And I click on element with xpath "//*[contains(text(),'Register Me')]"
    Then element with xpath "//mat-error[@class='mat-error ng-star-inserted']" should be displayed
    Examples:
      | Password                          | Confirm Password                  |
      | 1234                              | 1234                              |
      | 123456789012345678901234567890123 | 123456789012345678901234567890123 |
      | Tre!@ #12345                      | Tre!@ #12345                      |
      |                                   |                                   |
      | 1234!@Tre                         | 5678!@Poi                         |