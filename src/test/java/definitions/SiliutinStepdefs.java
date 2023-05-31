package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.Components;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class SiliutinStepdefs {
    private static String assignmentId;

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
        Thread.sleep(5000);
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
    public void siliutinGoAssignmentsToCreateNewAssignment() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Assignments')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Assignment')]")).click();
        Thread.sleep(4000);
    }

    @And("Siliutin click on last element containing student {string}")
    public void iClickOnLastElementContaining(String searchPattern) throws InterruptedException {
        List<WebElement> we = getDriver().findElements(By.xpath("//text()[contains(.,'"+searchPattern+"')]/.."));

        we.get(we.size() - 1).click();
        Thread.sleep(4000);
    }

    @And("Siliutin list of Quizzes to select Quiz to Assign")
    public void siliutinListOfQuizzesToSelectQuizToAssign() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Select Quiz To Assign')]")).click();
    }

    @And("Siliutin click on last element containing Quiz name {string}")
    public void siliutinClickOnLastElementContainingQuizName(String searchPattern) throws InterruptedException {
        List<WebElement> we = getDriver().findElements(By.xpath("//text()[contains(.,'"+searchPattern+"')]/.."));

        we.get(we.size() - 1).click();
        assertThat(getDriver().findElement(By.xpath("//h5[contains(text(),'Total Selected Students: 1')]")).isDisplayed()).isTrue();
        Thread.sleep(4000);
    }

    @Then("Siliutin give Assignment")
    public void siliutinGiveAssignment() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Give Assignment')]")).click();
        Thread.sleep(4000);
    }

    @Then("Siliutin check Assignment for Quiz name {string}")
    public void siliutinCheckAssignmentForQuizName(String searchPattern) {
        List<WebElement> we = getDriver().findElements(By.xpath("//text()[contains(.,'"+searchPattern+"')]/.."));

        we.get(we.size() - 1).click();

    }

    @Then("Siliutin LogOut from account")
    public void siliutinLogOutFromTeacherAccount() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
        Thread.sleep(2000);
        assertThat(getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).isDisplayed()).isTrue();
    }

    @Then("Siliutin LogIn as a Student")
    public void siliutinLogInAsAStudent() throws InterruptedException {
        WebElement loginField = getDriver().findElement(By.xpath("//input[@formcontrolname='email']"));
        loginField.sendKeys("vluvr1@boranora.com");
        WebElement passwordField = getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));
        passwordField.sendKeys("11111!");
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        assertThat(getDriver().findElement(By.xpath("//h3[contains(text(),'Bora Nora')]")).isDisplayed()).isTrue();
        Thread.sleep(2000);
    }

    @Then("Siliutin go to Assignments")
    public void silitinGoToAssignments() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'My Assignments')]")).click();
        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'My Assignments')]")).isDisplayed()).isTrue();
    }

    @Then("Siliutin search for assignment id")
    public void siliutinSearchForAssignmentId() throws InterruptedException {
        WebElement we = getDriver().findElement(By.xpath("//td/a"));
        String link = we.getAttribute("href");
        String [] s = link.split("/");
        assignmentId = s[s.length - 1];
        Thread.sleep(2000);
        System.out.println(assignmentId);
    }

    @Then("Siliutin click on Assesment with id")
    public void siliutinClickOnAssesmentWithId() throws InterruptedException {
        getDriver().findElement(By.xpath("//a[contains(@href,'"+assignmentId+"')]")).click();
        Thread.sleep(2000);
        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'Ver6')]")).isDisplayed()).isTrue();
    }

    @Then("Siliutin submit Quiz")
    public void siliutinSubmitQuiz() throws InterruptedException {
        getDriver().findElement(By.xpath("//label[@class='mat-checkbox-layout']/.//*[contains(text(),'A')]")).click();
        getDriver().findElement(By.xpath("//label[@class='mat-checkbox-layout']/.//*[contains(text(),'C')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Submit My Answers')]")).click();
        Thread.sleep(2000);
        assertThat(getDriver().findElement(By.xpath("//h1[contains(text(),'Success!')]")).isDisplayed()).isTrue();
        getDriver().findElement(By.xpath("//span[contains(text(),'Ok')]")).click();
        Thread.sleep(2000);
    }

    @Then("Siliutin check grade results")
    public void siliutinCheckGradeResults() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'My Grades')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//a[contains(@href,'"+assignmentId+"')]")).click();
        Thread.sleep(2000);
        assertThat(getDriver().findElement(By.xpath("//div[contains(text(),'ASSESSMENT PASSED')]")).isDisplayed()).isTrue();
        assertThat(getDriver().findElement(By.xpath("//td[contains(text(),'5 of 5 / 100%')]")).isDisplayed()).isTrue();
        getDriver().findElement(By.xpath("//span[contains(text(),'Close')]")).click();
    }


    @Then("Siliutin go to Submission, Automatically Graded")
    public void siliutinGoToSubmissionAutomaticallyGraded() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Submissions')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//div[contains(text(),'Automatically Graded')]")).click();
        Thread.sleep(2000);
    }

    @Then("Teacher check Automatically Graded Quiz result")
    public void teacherCheckAutomaticallyGradedQuizResult() throws InterruptedException {
        getDriver().findElement(By.xpath("//a[contains(@href,'"+assignmentId+"')]")).click();
        Thread.sleep(2000);
        assertThat(getDriver().findElement(By.xpath("//div[contains(text(),'ASSESSMENT PASSED')]")).isDisplayed()).isTrue();
        assertThat(getDriver().findElement(By.xpath("//td[contains(text(),'5 of 5 / 100%')]")).isDisplayed()).isTrue();
    }
}