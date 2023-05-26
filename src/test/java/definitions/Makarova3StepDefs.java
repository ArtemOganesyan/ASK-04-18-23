package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Components;
import support.Helper;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class Makarova3StepDefs {
    @Then("I want to do something")
    public void iWantToDoSomething() {
        System.out.println("Our cool test");
    }

    @Then("B type {string} into element with xpath {string}")
    public void aTypeIntoElementWithXpath(String text, String fieldName) {
        getDriver().findElement(By.xpath(Components.componentFor(fieldName))).sendKeys(text);
    }

    @Then("B type {string} into element {string}")
    public void bTypeIntoElementWithXpath(String text, String fieldName) {
        getDriver().findElement(By.xpath(Components.componentFor(fieldName))).sendKeys(text);
    }

    @And("I activate user {string}")
    public void iActivateUser(String email) throws SQLException, IOException {
        String access_token = Helper.getAccessToken(email);
        System.out.println(access_token);
        String[] act = access_token.split(";");
        int userId = Integer.parseInt(act[0]);
        Helper.activateUser(userId, act[1]);
    }

    @Given("split Demo for Kostya and others")
    public void splitDemoForKostyaAndOthers() {
        String test = "Anna, Makarova, 38, makar2dart@gmail.com";
        String[] testArray = test.split(",");
        System.out.println(testArray[0]);
        for (int i = 0; i < testArray.length; i++) {
            System.out.println(testArray[i].trim());
        }
    }

    @Then("I test list of quizzes")
    public void iTestListOfQuizzes() {
        List<WebElement> element = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(), 'Anna Demo Quiz')]"));
        int i = 0;
        for (WebElement e : element){
            if (i == 5){
                e.click();
            }
            i++;
        }
    }

    @Then("I test Recent quiz")
    public void iTestRecentQuiz() {
        List<WebElement> element = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(), 'Anna Demo Quiz')]"));
        int i = 0;
        for (WebElement e : element){
            if (i == element.size() - 1){
                e.click();
            }
            i++;
        }
    }

    @Given("I register new user")
    public void iRegisterNewUser() {
        getDriver().get("http://ask-stage.portnov.com/#/registration");
        WebElement firstNameField = getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']"));
        firstNameField.sendKeys("Anna");
        WebElement lastNameField = getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']"));
        lastNameField.sendKeys("Makarova");
        WebElement emailField = getDriver().findElement(By.xpath("//input[@formcontrolname='email']"));
        emailField.sendKeys("250@g.com");
        WebElement groupField = getDriver().findElement(By.xpath("//input[@formcontrolname='group']"));
        groupField.sendKeys("ABC");
    }

    @And("I enter {string}")
    public void iEnter(String password) {
        WebElement passwordField = getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));
        passwordField.sendKeys("<Password>");
        WebElement confirmPasswordField = getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']"));
        confirmPasswordField.sendKeys("<Password>");
    }

    @And("I click Submit btn")
    public void iClickSubmitBtn() throws InterruptedException {
        getDriver().findElement(By.xpath("//*[contains(text(),'Register Me')]")).click();
        Thread.sleep(2000);
    }

    @Then("I see message: You have been Registered")
    public void iSeeMessageYouHaveBeenRegistered() {
        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'You have been Registered')]")).isDisplayed()).isTrue();
    }

    @And("I enter {string} and {string}")
    public void iEnterAnd(String arg0, String arg1) {
        WebElement passwordField = getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));
        passwordField.sendKeys("<Password>");
        WebElement confirmPasswordField = getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']"));
        confirmPasswordField.sendKeys("<Confirm Password>");
    }

    @Then("I see error message")
    public void iSeeErrorMessage() {
        assertThat(getDriver().findElement(By.xpath("//mat-error[@class='mat-error ng-star-inserted']")).isDisplayed()).isTrue();
    }

    @Given("I log in as a Teacher")
    public void iLogInAsATeacher() throws InterruptedException {
        getDriver().get("http://ask-stage.portnov.com/#/login");
        WebElement email = getDriver().findElement(By.xpath("//input[@formcontrolname='email']"));
        email.sendKeys("hirinca@24hinbox.com");
        WebElement password = getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));
        password.sendKeys("123456Tre");
        getDriver().findElement(By.xpath("//*[contains(text(),'Sign In')]")).click();
        Thread.sleep(2000);
    }

    @And("I create new quiz")
    public void iCreateNewQuiz() throws InterruptedException, IOException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
        Thread.sleep(4000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
        Thread.sleep(4000);
        WebElement quizName = getDriver().findElement(By.xpath("//input[@formcontrolname='name']"));
        quizName.sendKeys("Anna Demo Quiz 1111");
        //1st question
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
        getDriver().findElement(By.xpath("//*[contains(text(), 'Q1')]/../../..//*[contains(text(), 'Textual')]/../..//div[@class='mat-radio-container']")).click();
        WebElement question1 = getDriver().findElement(By.xpath("//*[contains(text(), 'Q1')]/../../..//textarea[@placeholder='Question *']"));
        question1.sendKeys("What is your name?");
        //2nd question
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//*[contains(text(), 'Q2')]/../../..//*[contains(text(), 'Single-Choice')]/../..//div[@class='mat-radio-container']")).click();
        Thread.sleep(2000);
        WebElement question2 = getDriver().findElement(By.xpath("//*[contains(text(), 'Q2')]/../../..//textarea[@placeholder='Question *']"));
        question2.sendKeys("Which city is city largest in California?");
        WebElement option1 = getDriver().findElement(By.xpath("//*[contains(text(), 'Q2')]/../../..//textarea[@placeholder='Option 1*']"));
        option1.sendKeys("San Francisco");
        WebElement option2 = getDriver().findElement(By.xpath("//*[contains(text(), 'Q2')]/../../..//textarea[@placeholder='Option 2*']"));
        option2.sendKeys("Sacramento");
        getDriver().findElement(By.xpath("//*[contains(text(), 'Q2')]/../../..//*[contains(text(), 'Add Option')]")).click();
        WebElement option3 = getDriver().findElement(By.xpath("//*[contains(text(), 'Q2')]/../../..//textarea[@placeholder='Option 3*']"));
        option3.sendKeys("Los Angeles");
        getDriver().findElement(By.xpath("//*[contains(text(), 'Q2')]/../../..//*[contains(text(), 'Add Option')]")).click();
        WebElement option4 = getDriver().findElement(By.xpath("//*[contains(text(), 'Q2')]/../../..//textarea[@placeholder='Option 4*']"));
        option4.sendKeys("Redding");
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Q2')]/../../..//*[contains(text(), 'Option 3*')]/../../../../../..//div[@class='mat-radio-outer-circle']")));
        getDriver().findElement(By.xpath("(//*[contains(text(), 'Q2')]/../../..//mat-radio-button)[6]")).click();
        Thread.sleep(2000);
        //3rd question
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
        getDriver().findElement(By.xpath("//*[contains(text(), 'Q3')]/../../..//*[contains(text(), 'Multiple-Choice')]")).click();
        WebElement question3 = getDriver().findElement(By.xpath("//*[contains(text(), 'Q3')]/../../..//textarea[@placeholder='Question *']"));
        question3.sendKeys("Who was apple founded by?");
        WebElement option31 = getDriver().findElement(By.xpath("//*[contains(text(), 'Q3')]/../../..//textarea[@placeholder='Option 1*']"));
        option31.sendKeys("Steve Jobs");
        WebElement option32 = getDriver().findElement(By.xpath("//*[contains(text(), 'Q3')]/../../..//textarea[@placeholder='Option 2*']"));
        option32.sendKeys("Steve Wozniak");
        getDriver().findElement(By.xpath("//*[contains(text(), 'Q3')]/../../..//*[contains(text(), 'Add Option')]")).click();
        WebElement option33 = getDriver().findElement(By.xpath("//*[contains(text(), 'Q3')]/../../..//textarea[@placeholder='Option 3*']"));
        option33.sendKeys("Ronald Wayne");
        getDriver().findElement(By.xpath("//*[contains(text(), 'Q3')]/../../..//*[contains(text(), 'Add Option')]")).click();
        WebElement option34 = getDriver().findElement(By.xpath("//*[contains(text(), 'Q3')]/../../..//textarea[@placeholder='Option 4*']"));
        option34.sendKeys("Ronald Reagan");
        getDriver().findElement(By.xpath("//*[contains(text(), 'Q3')]/../../..//*[contains(text(), 'Option 1*')]/../../../../../..//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")).click();
        getDriver().findElement(By.xpath("//*[contains(text(), 'Q3')]/../../..//*[contains(text(), 'Option 2*')]/../../../../../..//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")).click();
        getDriver().findElement(By.xpath("//*[contains(text(), 'Q3')]/../../..//*[contains(text(), 'Option 3*')]/../../../../../..//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")).click();
        getDriver().findElement(By.xpath("//*[contains(text(),'Save')]/..")).click();
        Thread.sleep(5000);
    }

    @Then("most recent quiz {string} presented")
    public void mostRecentQuizPresented(String quiz) {
        List<WebElement> element = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(), 'Anna Demo Quiz 1111')]"));
        int i = 0;
        for (WebElement e : element){
            if (i == element.size() - 1){
                e.click();
            }
            i++;
        }
    }
}