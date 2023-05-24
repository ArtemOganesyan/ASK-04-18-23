@ComponentTests

  Feature: Component Tests

    @LoginScreen

    Scenario: Login Page Elements

      When I open url "http://ask-stage.portnov.com/#/login"
      And I wait for element "LoginEmailField" to be present
      And I type "hunsumen@forumbens.store" into element "LoginEmailField"
      And I type "ABc123" into element "LoginPasswdField"
      And I click on element "SubmitButtn"
      And I wait for 3 sec
#      And I log out
#      And I wait for 2 sec
#      And I wait for element "LoginEmailField" to be present
#      And I click on element "ForgotPass"
#      And I wait for 2 sec
#      And I go back to previous page
#      And I wait for element "LoginEmailField" to be present
#      And I click on element "RegisterNow"
#      And I wait for 2 sec

      And I click on element "Quizzes"
      And I wait for element "QuizzesList" to be present
#      And I click on Quiz with name "Klumsy qUIZ" and index 5
#      And I click on Quiz with index 5
      And I click on quiz with unique name "el quiz"
      And I wait for 2 sec



      