package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.Components;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class SiliutinStepdefs {
    @Then("Siliutin type {string} into element with xpath {string}")
    public void siliutinTypeIntoElementWithXpath(String text, String fieldName) {
        getDriver().findElement(By.xpath(Components.componentFor(fieldName))).sendKeys(text);
    }

    @Then("Siliutin click on element {string}")
    public void siliutinClickOnElement(String fieldName) {
        getDriver().findElement(By.xpath(Components.componentFor(fieldName))).click();
    }

    @Then("Siliutin click on element button {string}")
    public void siliutinClickOnElementButton(String fieldName) {
        getDriver().findElement(By.xpath(Components.componentFor(fieldName))).click();
    }

    @Then("Siliutin clear an element with xpath {string}")
    public void siliutinClearAnElementWithXpath(String fieldName) {
        getDriver().findElement(By.xpath(Components.componentFor(fieldName))).clear();
    }

    @Then("Siliutin type {string} into element {string}")
    public void siliutinTypeIntoElement(String text, String fieldName) {
        getDriver().findElement(By.xpath(Components.componentFor(fieldName))).sendKeys(text);
    }

    @Then("Siliutin click on element {string} name")
    public void siliutinClickOnElementName(String fieldName) {
        getDriver().findElement(By.xpath(Components.componentFor(fieldName))).click();
    }

    @Then("Siliutin an element with xpath {string} should contain text {string}")
    public void siliutinAnElementWithXpathShouldContainText(String fieldName, String text) {
        getDriver().findElement(By.xpath(Components.componentFor(fieldName)));
    }

    @Given("Siliutin LogIn as a Teacher")
    public void siliutinLogInAsATeacher() throws InterruptedException {
        getDriver().get("http://ask-stage.portnov.com/#/login");
        WebElement loginField = getDriver().findElement(By.xpath("//input[@formcontrolname='email']"));
        loginField.sendKeys("sanvaroberoi@muryegcbsvd.cloud");
        WebElement passwordField = getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));
        passwordField.sendKeys("22222!");
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        assertThat(getDriver().findElement(By.xpath("//p[contains(text(),'TEACHER')]")).isDisplayed()).isTrue();
        Thread.sleep(2000);
    }

    @Then("Siliutin navigate to the Quizzes section")
    public void siliutinNavigateToTheQuizzesSection() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
        Thread.sleep(2000);
        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'List of Quizzes')]")).isDisplayed()).isTrue();
    }

    @Then("Siliutin create new Quiz")
    public void siliutinCreateNewQuiz() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
        Thread.sleep(2000);
        WebElement quizTitle = getDriver().findElement(By.xpath("//input[@formcontrolname='name']"));
        quizTitle.sendKeys("Ver6");
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
        assertThat(getDriver().findElement(By.xpath("//span[contains(text(),'Preview')]")).isDisplayed()).isTrue();
        Thread.sleep(2000);
    }

    @Then("Siliutin add questions to Quiz")
    public void siliutinAddQuestionsToQuiz() throws InterruptedException {
        getDriver().findElement(By.xpath("//div[contains(text(),'Multiple-Choice')]")).click();
        WebElement Question1 = getDriver().findElement(By.xpath("//textarea[@placeholder='Question *']"));
        Question1.sendKeys("Question1");
        getDriver().findElement(By.xpath("//span[contains(text(),'Add Option')]")).click();
        WebElement Option1 = getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']"));
        Option1.sendKeys("A");
        WebElement Option2 = getDriver().findElement(By.xpath("//textarea[@placeholder='Option 2*']"));
        Option2.sendKeys("B");
        WebElement Option3 = getDriver().findElement(By.xpath("//textarea[@placeholder='Option 3*']"));
        Option3.sendKeys("C");
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-2']/..//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")).click();
        getDriver().findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-4']/..//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Preview')]")).click();
        assertThat(getDriver().findElement(By.xpath("//span[contains(text(),'Preview')]")).isDisplayed()).isTrue();
        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'Ver6')]")).isDisplayed()).isTrue();
        getDriver().findElement(By.xpath("//button[@aria-label='Close dialog']")).click();
        Thread.sleep(2000);
    }

    @Then("Siliutin save Quiz")
    public void siliutinSaveQuiz() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        Thread.sleep(2000);
    }

    @Then("Siliutin go Assignments to create new Assignment")
    public void siliutinGoAssignmentsToCreateNewAssignment() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Assignments')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Assignment')]")).click();
    }
}
