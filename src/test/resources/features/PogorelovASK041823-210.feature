@Registration-GroupCode
  Feature: ASK041823-484 Registration - Group Code

    Background: Check specified e-mail and delete the associated account if it exists.

#      Given I Cleanup account by email "dkirichenko23@gmail.com" and password "student35"

      Given KP obtain admin token
      Given KP obtain account ID for email "dkirichenko23@gmail.com"
      And KP delete the account if it exists

      Given I open url "http://ask-stage.portnov.com/#/registration"
      And I type "Denis" into element with xpath "//input[@formcontrolname='firstName']"
      And I type "Kirichenko" into element with xpath "//input[@formcontrolname='lastName']"
      And I type "dkirichenko23@gmail.com" into element with xpath "//input[@formcontrolname='email']"
      And I type "student35" into element with xpath "//input[@formcontrolname='password']"
      And I type "student35" into element with xpath "//input[@formcontrolname='confirmPassword']"

  @test1##ASK041823-210;ASK041823-212;ASK041823-213;ASK041823-254

  Scenario Outline: Positive cases (Alphanumeric; Min 1 char; max 10 char)
    Given I type "<groupValue>" into element with xpath "//input[@formcontrolname='group']"
    When I click on element with xpath "//button[@type='submit']"
    And I wait for 2 sec
    Then KP page with url "http://ask-stage.portnov.com/#/registration-confirmation" should be loaded
    Then element with xpath "//h4[contains(text(),'You have been Registered')]" should be present
    Examples:
      | groupValue  |
      | G#$34       |
      | D           |
      | GDL45#67LK  |

    @test2##ASK041823-211;ASK041823-212;ASK041823-254;ASK041823-215

    Scenario Outline: Negative Cases (Group code field required; 11 chars; spaces)

      Given I type "<groupValue>" into element with xpath "//input[@formcontrolname='group']"
      When I click on element with xpath "//button[@type='submit']"
      And I wait for 1 sec
      Then element with xpath "//mat-card[@class='mat-card']" should contain text "<message>"

      Examples:
        | groupValue  | message                                |
        |             | This field is required                 |
        | GDL45#67LK2 | no more than 10 characters             |
        | GDL45 #67   | White spaces are not allowed           |




