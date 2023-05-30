@olia
Feature: Submissions - Status 2

  Background:
    Given I open url "http://ask-stage.portnov.com"
    And I wait for 2 sec
    Then Olia types "beachtrain@upoea.com" into element "LoginTextField"
    Then Olia types "World123" into element "PasswordTextField"
    Then I click on element with xpath "//button[@type='submit']"
    And I wait for 2 sec


  @olia1
  Scenario: Status "Passed" is correct in tab "Reviewed"
#    Assign quiz to the student
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
    And I click on element with xpath "//button[@type='submit']"
    And I wait for 2 sec
    And I click on element with xpath "//span[contains(text(),'Go To My Assignments')]"
    And I wait for 2 sec
    And Olia search for assignment id
    And I click on element with xpath "//span[contains(text(),'Go To Assessment')]"
    And I type "no" into element with xpath "//h3[contains(text(),'What is Cookies?')]/..//textarea[@formcontrolname='textAnswer']"
    And I click on element with xpath "//*[contains(text(),'At the end of each Sprint')]"
    And I click on element with xpath "//*[contains(text(),'Zero')]"
    And I click on element with xpath "//button"
    And I wait for 2 sec
    And I click on element with xpath "//button[@aria-label='Close dialog']"
    And I wait for 2 sec
    And I click on element with xpath "//h5[contains(text(),'Log Out')]"
    And I click on element with xpath "//span[contains(text(),'Log Out')]"
    And I wait for 2 sec

#  Quiz graded by teacher
    When Olia types "beachtrain@upoea.com" into element "LoginTextField"
    And Olia types "World123" into element "PasswordTextField"
    And I click on element with xpath "//button[@type='submit']"
    And I wait for 2 sec
    And I click on element with xpath "//h5[contains(text(),'Submissions')]"
    And I wait for 2 sec
    And Olia click on the assignment with id
    And Olia adds 5 poins to question by xpath "//h4[contains(text(),'Cookies?')]/../..//*[contains(text(),'+')]/.."
    Then element with xpath "//div[contains(text(),'ASSESSMENT PASSED')]" should be displayed
    When Olia takes a screenshot
    And I click on element with xpath "//button[@type='submit']"
    And I wait for 2 sec
    And I click on element with xpath "//*[contains(text(),'Reviewed')]/.."
    And I wait for 2 sec
#    Then element with xpath "//*[contains(text(),'Test Quiz for Submissions Status')]/..//*[contains(text(),'FAILED')]" should be displayed
    Then Olia sees "PASSED" assignment with id is displayed

  @olia2
  Scenario: Teacher's adjustments- changing Status from "Passed" to "Failed"
    When I click on element with xpath "//h5[contains(text(),'Submissions')]"
    And I wait for 2 sec
    And I click on element with xpath "//*[contains(text(),'Reviewed')]/.."
    And I wait for 2 sec
    And Olia click on the assignment with id
    And Olia adds 5 poins to question by xpath "//h4[contains(text(),'Cookies?')]/../..//*[contains(text(),'-')]/.."
    And I wait for 2 sec
    Then element with xpath "//div[contains(text(),'ASSESSMENT FAILED')]" should be displayed
    When I click on element with xpath "//button[@type='submit']"
    And I wait for 2 sec
    And I click on element with xpath "//*[contains(text(),'Reviewed')]/.."
    And I wait for 2 sec
    Then Olia sees "FAILED" assignment with id is displayed
    When Olia click on the assignment with id
    And Olia takes a screenshot

  @olia3
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
    Then Olia sees "FAILED" assignment with id is displayed
    When I wait for 2 sec
    And Olia takes a screenshot
    And I click on element with xpath "//h5[contains(text(),'Log Out')]"
    And I click on element with xpath "//span[contains(text(),'Log Out')]"
    And I wait for 2 sec

#  Delete Assignment
    When Olia types "beachtrain@upoea.com" into element "LoginTextField"
    And Olia types "World123" into element "PasswordTextField"
    And I click on element with xpath "//button[@type='submit']"
    And I wait for 2 sec
    And I click on element with xpath "//h5[contains(text(),'Assignments')]"
    And I wait for 2 sec
    And I click on element with xpath "//*[contains(text(),'Test Quiz for Submissions Status')]/../..//mat-icon"
    And I click on element with xpath "//*[contains(text(),'Delete Assignment')]/.."
    And I wait for 2 sec
    And I click on element with xpath "//span[contains(text(),'Delete')]/.."
    And I wait for 2 sec

#    Delete Quiz
    And I click on element with xpath "//h5[contains(text(),'Quizzes')]"
    And I wait for 2 sec
    And I click on element with xpath "//*[contains(text(),'Test Quiz for Submissions Status')]"
    And I click on element with xpath "(//*[contains(text(),'Test Quiz for Submissions Status')])[1]/../../..//span[contains(text(),'Delete')]"
    And I click on element with xpath "//h1[contains(text(),'Confirmation')]/..//span[contains(text(),'Delete')]/.."
    And I wait for 2 sec