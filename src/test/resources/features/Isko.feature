@isko
Feature: Submissions - Status

  Background:
    Given I open url "http://ask-stage.portnov.com"
    And I wait for 2 sec
    Then Olia types "beachtrain@upoea.com" into element "LoginTextField"
    Then Olia types "World123" into element "PasswordTextField"
    Then I click on element with xpath "//button[@type='submit']"
    And I wait for 2 sec

  @isko1
  Scenario: Status "Failed" is correct in tab "Reviewed"
#  Create Quiz
    When I click on element with xpath "//h5[contains(text(),'Quizzes')]"
    And I wait for 2 sec
    And I click on element with xpath "//span[contains(text(),'Create New Quiz')]"
    And I wait for 2 sec
    And I type "Test Quiz for Submissions Status" into element with xpath "//input[@formcontrolname='name']"
    And I click on element with xpath "//mat-icon[contains(text(),'add_circle')]"
    And I click on element with xpath "//mat-panel-title[contains(text(),'Q1')]/../../..//div[contains(text(),'Textual')]"
    And I wait for 2 sec
    And I type "What is Cookies?" into element with xpath "//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[@formcontrolname='question']"
    And I click on element with xpath "//span[contains(text(),'Show-Stopper')]"
    And I click on element with xpath "//mat-icon[contains(text(),'add_circle')]"
    And I wait for 2 sec
    And I click on element with xpath "//mat-panel-title[contains(text(),'Q2')]/../../..//div[contains(text(),'Single-Choice')]"
    And I wait for 2 sec
    And I type "When is a Sprint Retrospective ceremony performed?" into element with xpath "//mat-panel-title[contains(text(),'Q2')]/../../..//textarea[@formcontrolname='question']"
    And I type "Whenever the team suggests" into element with xpath "//mat-panel-title[contains(text(),'Q2')]/../../..//textarea[@placeholder='Option 1*']"
    And I type "At the end of each Sprint" into element with xpath "//mat-panel-title[contains(text(),'Q2')]/../../..//textarea[@placeholder='Option 2*']"
    And I click on element with xpath "//mat-panel-title[contains(text(),'Q2')]/../../..//textarea[@placeholder='Option 2*']/../../../../..//mat-radio-button"
    And I click on element with xpath "//mat-panel-title[contains(text(),'Q2')]/../../..//*[contains(text(),'Other')]"
    And I wait for 2 sec
    And I click on element with xpath "//mat-icon[contains(text(),'add_circle')]"
    And I wait for 2 sec
    And I click on element with xpath "//mat-panel-title[contains(text(),'Q3')]/../../..//div[contains(text(),'Multiple')]"
    And I wait for 2 sec
    And I type "How many test cases you can create if you don't have requirements?" into element with xpath "//mat-panel-title[contains(text(),'Q3')]/../../..//textarea[@formcontrolname='question']"
    And I type "Zero! No requirements no test cases" into element with xpath "//mat-panel-title[contains(text(),'Q3')]/../../..//textarea[@placeholder='Option 1*']"
    And I type "As many as you want" into element with xpath "//mat-panel-title[contains(text(),'Q3')]/../../..//textarea[@placeholder='Option 2*']"
    And I click on element with xpath "//mat-panel-title[contains(text(),'Q3')]/../../..//textarea[@placeholder='Option 1*']/../../../../..//mat-checkbox"
    And I wait for 2 sec
    And I click on element with xpath "//*[contains(text(),'Save')]/.."
    And I wait for 3 sec
    Then element with xpath "//*[contains(text(),'Test Quiz for Submissions Status')]" should be displayed
    And I wait for 2 sec

  #  Assign quiz to the student
    When I click on element with xpath "//h5[contains(text(),'Assignments')]"
    And I click on element with xpath "//span[contains(text(),'Create New Assignment')]"
    And I click on element with xpath "//*[contains(text(),'Isk&01')]/../.."
    And I wait for 2 sec
    And I click on element with xpath "//mat-select[@aria-label='Select Quiz To Assign']"
    And I wait for 2 sec
    And I click on element with xpath "(//*[contains(text(),'Test Quiz for Submissions Status')])[1]"
    And I click on element with xpath "//button[@type='submit']"

#  Submit quiz by student
    When I click on element with xpath "//h5[contains(text(),'Log Out')]"
    And I click on element with xpath "//span[contains(text(),'Log Out')]"
    And I wait for 2 sec
    And Olia types "danlavall@btcmod.com" into element "LoginTextField"
    And Olia types "Qwe123@" into element "PasswordTextField"
    When I click on element with xpath "//button[@type='submit']"
    And I wait for 2 sec
    And I click on element with xpath "//span[contains(text(),'Go To My Assignments')]"
    And I wait for 2 sec
    And Olia search for assignment id
    And I click on element with xpath "//span[contains(text(),'Go To Assessment')]"
    And I type "Cookies" into element with xpath "//h3[contains(text(),'What is Cookies?')]/..//textarea[@formcontrolname='textAnswer']"
    And I click on element with xpath "//*[contains(text(),'Whenever the team suggests')]"
    And I click on element with xpath "//*[contains(text(),'As many as you want')]"
    And I click on element with xpath "//button"
    And I wait for 2 sec
    And I click on element with xpath "//button[@aria-label='Close dialog']"
    And I wait for 2 sec
    When I click on element with xpath "//h5[contains(text(),'Log Out')]"
    And I click on element with xpath "//span[contains(text(),'Log Out')]"
    When I wait for 2 sec

#  Quiz graded by teacher
    When Olia types "beachtrain@upoea.com" into element "LoginTextField"
    And Olia types "World123" into element "PasswordTextField"
    And I click on element with xpath "//button[@type='submit']"
    And I wait for 2 sec
    And I click on element with xpath "//h5[contains(text(),'Submissions')]"
    And I wait for 2 sec
    And Olia click on the assignment with id
    Then element with xpath "//div[contains(text(),'ASSESSMENT FAILED')]" should be displayed
    When Olia takes a screenshot
    And I click on element with xpath "//button[@type='submit']"
    And I wait for 2 sec
    And I click on element with xpath "//*[contains(text(),'Reviewed')]/.."
    And I wait for 2 sec
#    Then element with xpath "//*[contains(text(),'Test Quiz for Submissions Status')]/..//*[contains(text(),'FAILED')]" should be displayed
    Then Olia sees "FAILED" assignment with id is displayed

  @isko2
  Scenario: Teacher's adjustments- changing Status from "Failed" to "Passed"
    When I click on element with xpath "//h5[contains(text(),'Submissions')]"
    And I wait for 2 sec
    And I click on element with xpath "//*[contains(text(),'Reviewed')]/.."
    And I wait for 2 sec
    And Olia click on the assignment with id
    And Olia adds 5 poins to question by xpath "//h4[contains(text(),'Cookies?')]/../..//*[contains(text(),'+')]/.."
    And Olia adds 5 poins to question by xpath "(//h4[contains(text(),'Retrospective')]/../..//span[contains(text(),'+')]/..)[2]"
    And Olia adds 5 poins to question by xpath "//h4[contains(text(),'How many')]/../..//span[contains(text(),'+')]/.."
    Then element with xpath "//div[contains(text(),'ASSESSMENT PASSED')]" should be displayed
    When I click on element with xpath "//button[@type='submit']"
    And I wait for 2 sec
    And I click on element with xpath "//*[contains(text(),'Reviewed')]/.."
    And I wait for 2 sec
    Then Olia sees "PASSED" assignment with id is displayed
    When Olia click on the assignment with id
    And Olia takes a screenshot

  @submissionStatus2
  Scenario: Check quiz status in student's account
    When I click on element with xpath "//h5[contains(text(),'Log Out')]"
    And I click on element with xpath "//span[contains(text(),'Log Out')]"
    And I wait for 2 sec
    And Olia types "danlavall@btcmod.com" into element "LoginTextField"
    And Olia types "Qwe123@" into element "PasswordTextField"
    And I click on element with xpath "//button[@type='submit']"
    And I wait for 2 sec
    And I click on element with xpath "//span[contains(text(),'Go To My Grades')]"
    And I wait for 2 sec
    Then Olia sees "PASSED" assignment with id is displayed
    When I wait for 2 sec
    And Olia takes a screenshot
    And I click on element with xpath "//h5[contains(text(),'Log Out')]"
    And I click on element with xpath "//span[contains(text(),'Log Out')]"
    And I wait for 2 sec

#  Delete Quiz
    When Olia types "beachtrain@upoea.com" into element "LoginTextField"
    And Olia types "World123" into element "PasswordTextField"
    And I click on element with xpath "//button[@type='submit']"
    And I wait for 2 sec
    And I click on element with xpath "//h5[contains(text(),'Quizzes')]"
    And I wait for 2 sec
    And I click on element with xpath "//*[contains(text(),'Test Quiz for Submissions Status')]"
    And I click on element with xpath "(//*[contains(text(),'Test Quiz for Submissions Status')])[1]/../../..//span[contains(text(),'Delete')]"
    And I click on element with xpath "//h1[contains(text(),'Confirmation')]/..//span[contains(text(),'Delete')]/.."
    And I wait for 2 sec

#  Delete Assignment
    When I click on element with xpath "//h5[contains(text(),'Assignments')]"
    And I wait for 2 sec
    And I click on element with xpath "//*[contains(text(),'Test Quiz for Submissions Status')]/../..//mat-icon"
    And I click on element with xpath "//*[contains(text(),'Delete Assignment')]/.."
    And I wait for 2 sec
    And I click on element with xpath "//span[contains(text(),'Delete')]/.."
    And I wait for 2 sec