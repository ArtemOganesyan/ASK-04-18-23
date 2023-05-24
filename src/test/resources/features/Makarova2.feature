@ask
Feature: Main Tests
  Background:
    Given I open url "http://ask-stage.portnov.com/#/login"
    When I type "hirinca@24hinbox.com" into element with xpath "//input[@formcontrolname='email']"
    And I type "123456Tre" into element with xpath "//input[@formcontrolname='password']"
    And I click on element with xpath "//*[contains(text(),'Sign In')]"
    And I wait for 2 sec
  @ask1
  Scenario: Create Quiz
    #Create Quiz
    When I click on element with xpath "//h5[contains(text(),'Quizzes')]"
    And I wait for 4 sec
    And I click on element with xpath "//span[contains(text(),'Create New Quiz')]"
    And I wait for 4 sec
    And I type "Anna Demo Quiz 1904" into element with xpath "//input[@formcontrolname='name']"
    #1st question
    Then I click on element with xpath "//mat-icon[contains(text(),'add_circle')]"
    And I click on element with xpath "//*[contains(text(), 'Q1')]/../../..//*[contains(text(), 'Textual')]/../..//div[@class='mat-radio-container']"
    And I type "What is your name?" into element with xpath "//*[contains(text(), 'Q1')]/../../..//textarea[@placeholder='Question *']"
    #2nd question
    Then I click on element with xpath "//mat-icon[contains(text(),'add_circle')]"
    And I wait for 2 sec
    And I click on element with xpath "//*[contains(text(), 'Q2')]/../../..//*[contains(text(), 'Single-Choice')]/../..//div[@class='mat-radio-container']"
    And I wait for 2 sec
    And I type "Which city is city largest in California?" into element with xpath "//*[contains(text(), 'Q2')]/../../..//textarea[@placeholder='Question *']"
    When I type "San Francisco" into element with xpath "//*[contains(text(), 'Q2')]/../../..//textarea[@placeholder='Option 1*']"
    And I type "Sacramento" into element with xpath "//*[contains(text(), 'Q2')]/../../..//textarea[@placeholder='Option 2*']"
    And I click on element with xpath "//*[contains(text(), 'Q2')]/../../..//*[contains(text(), 'Add Option')]"
    And I type "Los Angeles" into element with xpath "//*[contains(text(), 'Q2')]/../../..//textarea[@placeholder='Option 3*']"
    And I click on element with xpath "//*[contains(text(), 'Q2')]/../../..//*[contains(text(), 'Add Option')]"
    And I type "Redding" into element with xpath "//*[contains(text(), 'Q2')]/../../..//textarea[@placeholder='Option 4*']"
    And I wait for element with xpath "//*[contains(text(), 'Q2')]/../../..//*[contains(text(), 'Option 3*')]/../../../../../..//div[@class='mat-radio-outer-circle']" to be present
    And I click on element with xpath "(//*[contains(text(), 'Q2')]/../../..//mat-radio-button)[6]"
    And I wait for 2 sec
    #3rd question
    Then I click on element with xpath "//mat-icon[contains(text(),'add_circle')]"
    And I click on element with xpath "//*[contains(text(), 'Q3')]/../../..//*[contains(text(), 'Multiple-Choice')]"
    And I type "Who was apple founded by?" into element with xpath "//*[contains(text(), 'Q3')]/../../..//textarea[@placeholder='Question *']"
    When I type "Steve Jobs" into element with xpath "//*[contains(text(), 'Q3')]/../../..//textarea[@placeholder='Option 1*']"
    When I type "Steve Wozniak" into element with xpath "//*[contains(text(), 'Q3')]/../../..//textarea[@placeholder='Option 2*']"
    And I click on element with xpath "//*[contains(text(), 'Q3')]/../../..//*[contains(text(), 'Add Option')]"
    And I type "Ronald Wayne" into element with xpath "//*[contains(text(), 'Q3')]/../../..//textarea[@placeholder='Option 3*']"
    And I click on element with xpath "//*[contains(text(), 'Q3')]/../../..//*[contains(text(), 'Add Option')]"
    And I type "Ronald Reagan" into element with xpath "//*[contains(text(), 'Q3')]/../../..//textarea[@placeholder='Option 4*']"
    And I click on element with xpath "//*[contains(text(), 'Q3')]/../../..//*[contains(text(), 'Option 1*')]/../../../../../..//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']"
    And I click on element with xpath "//*[contains(text(), 'Q3')]/../../..//*[contains(text(), 'Option 2*')]/../../../../../..//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']"
    And I click on element with xpath "//*[contains(text(), 'Q3')]/../../..//*[contains(text(), 'Option 3*')]/../../../../../..//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']"
    And I click on element with xpath "//*[contains(text(),'Save')]/.."
    And I wait for 5 sec
    Then element with xpath "(//mat-panel-title[contains(text(), 'Anna Demo Quiz 1904')])[1]" should be present
    And I wait for 5 sec