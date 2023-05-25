@feature_main
Feature: Registration_Last Name

  Background:
    Given I open url "http://ask-stage.portnov.com/#/registration"

  @scenario2
  Scenario Outline:  Registration_Last Name: Positive (Allowable characters, boundary: 254, 50, 1 characters)
    When I type "<first name>" into element with xpath "//input[@formcontrolname='firstName']"
    And I type "<last name>" into element with xpath "//input[@formcontrolname='lastName']"
    And I type "<email>" into element with xpath "//input[@formcontrolname='email']"
    And I type "<group number>" into element with xpath "//input[@formcontrolname='group']"
    And I type "<password>" into element with xpath "//input[@formcontrolname='password']"
    And I type "<confirm password>" into element with xpath "//input[@formcontrolname='confirmPassword']"
    And I wait for element with xpath "//span[contains(text(),'Register Me')]" to be present
    And I click on element with xpath "//span[contains(text(),'Register Me')]"
    And I wait for 2 sec
    Then element with xpath "//h4[contains(text(),'You have been Registered.')]" should be displayed
    Examples:
      | first name | last name                                                                                                                                                                                                                                                      | email                 | group number | password | confirm password |
      | Susan      | Smith&23                                                                                                                   | susansmith23@abcd.com | GR1          | 98745Abc | 98745Abc         |
      | S          | Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf123456789 | susansmith23@abcd.com | GR1          | 98745Abc | 98745Abc         |
      | S          | Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf                                                                                                                                                                                                             | susansmith23@abcd.com | GR1          | 98745Abc | 98745Abc         |
      | S          | A                                                                                                                                                                                                                                                              | susansmith23@abcd.com | GR1          | 98745Abc | 98745Abc         |


  Scenario Outline:  Registration_Last Name: Negative (Allowable characters, white space)
    When I type "<first name>" into element with xpath "//input[@formcontrolname='firstName']"
    And I type "<last name>" into element with xpath "//input[@formcontrolname='lastName']"
    And I type "<email>" into element with xpath "//input[@formcontrolname='email']"
    And I type "<group number>" into element with xpath "//input[@formcontrolname='group']"
    And I type "<password>" into element with xpath "//input[@formcontrolname='password']"
    And I type "<confirm password>" into element with xpath "//input[@formcontrolname='confirmPassword']"
    And I wait for element with xpath "//span[contains(text(),'Register Me')]" to be present
    And I click on element with xpath "//span[contains(text(),'Register Me')]"
    And I wait for 2 sec
    Then element with xpath "//*[contains(text(),'Should contain only')]" should be displayed
    And I wait for 1 sec
    Examples:
      | first name | last name   | email                 | group number | password | confirm password |
      | Susan      | Smith&23АБВ | susansmith234@abc.com | GR1          | 98745Abc | 98745Abc         |
      | S          | A B         | susansmith234@abc.com | GR1          | 98745Abc | 98745Abc         |

  Scenario:  Registration_Last Name: Negative (empty field)
    When I type "Susan" into element with xpath "//input[@formcontrolname='firstName']"
    And I type "" into element with xpath "//input[@formcontrolname='lastName']"
    And I type "susansmith234@abc.com" into element with xpath "//input[@formcontrolname='email']"
    And I type "GR1" into element with xpath "//input[@formcontrolname='group']"
    And I type "98745Abc" into element with xpath "//input[@formcontrolname='password']"
    And I type "98745Abc" into element with xpath "//input[@formcontrolname='confirmPassword']"
    And I wait for element with xpath "//span[contains(text(),'Register Me')]" to be present
    And I click on element with xpath "//span[contains(text(),'Register Me')]"
    And I wait for 2 sec
    Then element with xpath "//*[contains(text(),'This field is required')]" should be displayed
    And I wait for 1 sec

  Scenario:  Registration_Last Name: Negative (boundary: 255 characters)
    When I type "Susan" into element with xpath "//input[@formcontrolname='firstName']"
    And I type "Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890Abcdf1234567890" into element with xpath "//input[@formcontrolname='lastName']"
    And I type "susansmith234@abc.com" into element with xpath "//input[@formcontrolname='email']"
    And I type "GR1" into element with xpath "//input[@formcontrolname='group']"
    And I type "98745Abc" into element with xpath "//input[@formcontrolname='password']"
    And I type "98745Abc" into element with xpath "//input[@formcontrolname='confirmPassword']"
    And I wait for element with xpath "//span[contains(text(),'Register Me')]" to be present
    And I click on element with xpath "//span[contains(text(),'Register Me')]"
    And I wait for 2 sec
    Then element with xpath "//*[contains(text(),'Should no more 254 characters')]" should be displayed
    And I wait for 1 sec




