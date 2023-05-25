@Scenario
Feature: Log in
  Background:
    Given I open url "http://ask-stage.portnov.com/"
  @scenario_list_elem
  Scenario: List of elements
    When I type "teacher@gmail.com" into element with xpath "//input[@formcontrolname='email']"
    And I type "12345Abc" into element with xpath "//input[@formcontrolname='password']"
    And I click on element with xpath "//*[contains(text(),'Sign In')]"
    And I wait for 1 sec
    And I click on element with xpath "//h5[contains(text(), 'Assignments')]"
    And I wait for 1 sec
    And I click on element with xpath "//*[contains(text(), 'Create New Assignment')]"
    And I click on last element containing "Dmytro"
    And I wait for 5 sec