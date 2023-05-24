@Scenario
Feature: Log in
  Background:
    Given I open url "http://ask-stage.portnov.com/#/registration"
  @ScenarioPositive
  Scenario Outline:
    When I type "d.mo7oko@gmail.com" into element with xpath "//input[@id='mat-input-16']"
    And I type "Maklak4ikov" into element with xpath "//input[@id='mat-input-17']"
    And I click on element using JavaScript with xpath "//span[contains(text(),'Sign In')]"
    Then element with xpath "//p[contains(text(),'TEACHER')]" should be displayed
