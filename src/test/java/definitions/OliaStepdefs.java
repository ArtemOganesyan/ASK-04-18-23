package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import support.OliaComponents;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class OliaStepdefs {
    private static String assignmentId;

    @And("Olia types {string} into element {string}")
    public void oliaTypesIntoElement(String text, String fieldName) {
        getDriver().findElement(By.xpath(OliaComponents.componentFor(fieldName))).sendKeys(text);
    }

    @When("Olia adds {int} poins to question by xpath {string}")
    public void oliaAddsPoinsToQuestionByXpath(int points, String add) {
            for(int i = 0; i < points; i++) {
                getDriver().findElement(By.xpath(add)).click();
            }
        }

    @And("Olia search for assignment id")
    public void oliaSearchForAssignmentId() {
        WebElement we = getDriver().findElement(By.xpath("//td/a"));
        String link = we.getAttribute("href");
        String[] s = link.split("/");
        assignmentId = s[s.length - 1];
        System.out.println(assignmentId);
    }

    @And("Olia click on the assignment with id")
    public void oliaClickOnTheAssignmentWithId() {
        getDriver().findElement(By.xpath("//a[contains(@href, '"+assignmentId+"')]")).click();
    }

    @Then("Olia sees {string} assignment with id is displayed")
    public void oliaSeesAssignmentWithIdIsDisplayed(String status) {
        assertThat(getDriver().findElement(By.xpath("//a[contains(@href, '"+assignmentId+"')]/../..//span[contains(text(),'"+status+"')]")).isDisplayed()).isTrue();
    }

    @And("Olia takes a screenshot")
    public void oliaTakesAScreenshot() throws IOException {
        TakesScreenshot screenshotTaker = (TakesScreenshot) getDriver();
        File screenshot = screenshotTaker.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("screenshot" + System.currentTimeMillis() + ".png"));
    }
}
