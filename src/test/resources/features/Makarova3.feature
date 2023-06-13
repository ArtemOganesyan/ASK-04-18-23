@makarova_scenario
Feature: Tests
  @makarova_scenario_test_cases_positive
  Scenario Outline: Registration Password / Positive
    Given I register new user
    And I enter "<Password>"
    And I click Submit btn
    Then I see message: You have been Registered
    Examples:
      | Password                         |
      | Tre!@#12345                      |
      | 12345                            |
      | 12345678901234567890123456789012 |


  @makarova_scenario_test_cases__negative
  Scenario Outline: Registration Password / Negative
    Given I register new user
    And I enter "<Password>" and "<Confirm Password>"
    And I click Submit btn
    Then I see error message
    Examples:
      | Password                          | Confirm Password                  |
      | 1234                              | 1234                              |
      | 123456789012345678901234567890123 | 123456789012345678901234567890123 |
      | Tre!@ #12345                      | Tre!@ #12345                      |
      |                                   |                                   |
      | 1234!@Tre                         | 5678!@Poi                         |
  @makarova_scenario_createQuiz
  Scenario: Create New Quiz
    Given I log in as a Teacher
    And I create new quiz
    Then most recent quiz "Anna Demo Quiz 1111" presented