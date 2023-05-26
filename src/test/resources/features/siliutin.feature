@feature_main
Feature: Main tests

  @scenario1 #ASK041823-435
  Scenario Outline: Student, Settings - Full Name, Min 2 characters plus 1 space between two words
    Given I open url "http://ask-stage.portnov.com"
    Then Siliutin type "ioceanic@superintendent.store" into element with xpath "LoginTextField"
    Then Siliutin type "12345Abc" into element with xpath "PasswordTextField"
    Then Siliutin click on element "SubmitButton"
    Then I wait for 2 sec
    Then Siliutin click on element "Settings"
    Then Siliutin click on element button "ChangeYourName"
    Then Siliutin clear an element with xpath "NewName"
    Then Siliutin type "<FullName>" into element "NewName"
    Then Siliutin click on element "Change" name
    Then Siliutin an element with xpath "UserName" should contain text "<FullName>"
    And I wait for 3 sec
    Examples:
      | FullName |
      | E S             |
      | Siliutin E1     |
      | Ernest Siliutin |

  @scenario2 #ASK041823-488
  Scenario: Automatically Graded Multiple-Choice Quiz
    Given Siliutin LogIn as a Teacher
    Then Siliutin navigate to the Quizzes section
    Then Siliutin create new Quiz
    Then Siliutin add questions to Quiz
    Then Siliutin save Quiz
    Then Siliutin go Assignments to create new Assignment
    And Siliutin click on last element containing student "Bora Nora"
    And Siliutin list of Quizzes to select Quiz to Assign
    And Siliutin click on last element containing Quiz name "Ver6"
    Then Siliutin give Assignment
    Then Siliutin LogOut from account
    Then Siliutin LogIn as a Student
    Then Siliutin go to Assignments
    Then Siliutin search for assignment id
    Then Siliutin click on Assesment with id
    Then Siliutin submit Quiz
    Then Siliutin check grade results
    Then Siliutin LogOut from account
    Then Siliutin LogIn as a Teacher
    Then Siliutin go to Submission, Automatically Graded
    Then Teacher check Automatically Graded Quiz result