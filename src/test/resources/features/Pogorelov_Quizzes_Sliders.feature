@Finding_Sliders

  Feature:

    @TC1_PassingRate_Slider

    Scenario:

      Given I open url "http://ask-stage.portnov.com/#/login"
      And I type "hunsumen@forumbens.store" into element with xpath "//input[@formcontrolname='email']"
      And I type "ABc123" into element with xpath "//input[@formcontrolname='password']"
      And I click on element with xpath "//button[@type='submit']"
      And I wait for 2 sec
      And I click on element with xpath "//h5[text()='Quizzes']"
      And I wait for 2 sec
      And I click on element with xpath "//button/span[text()='Create New Quiz']"
      And I wait for 2 sec
      And I type "Delete Me" into element with xpath "//div/input[@formcontrolname='name']"
      And I click on element with xpath "//button/span/mat-icon[text()='add_circle']"
      #here come the sliders
      Then element with xpath "//mat-card/div/mat-slider[@aria-valuemax='100']" should be present
      And element with xpath "//mat-slider[@aria-valuemax='10']" should be present
      Then element with xpath "//mat-card/div/mat-slider[@aria-valuemax='100']" should have attribute "aria-valuenow" as "75"
      When KP increase the slider with xpath "//mat-card/div/mat-slider[@aria-valuemax='100']" by value 25
      And I wait for 3 sec
      Then element with xpath "//mat-card/div/mat-slider[@aria-valuemax='100']" should have attribute "aria-valuenow" as "100"
      And element with xpath "//mat-card/h5[contains(text(),'Points')]" should contain text "5 of 5 Points"


      
      

