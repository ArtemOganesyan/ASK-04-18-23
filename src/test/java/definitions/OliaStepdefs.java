package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import support.OliaComponents;

import static support.TestContext.getDriver;

public class OliaStepdefs {
    @And("Olia type {string} into element {string}")
    public void oliaTypeIntoElement(String text, String fieldName) {
        getDriver().findElement(By.xpath(OliaComponents.componentFor(fieldName))).sendKeys(text);
    }

    @When("I add {int} poins to question by xpath {string}")
    public void iAddPoinsToQuestionByXpath(int points, String add) {
            for(int i = 0; i < points; i++) {
                getDriver().findElement(By.xpath(add)).click();
            }
        }
    }
