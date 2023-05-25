/*
 * Created by Artem Oganesyan on 24.05.2023
 */

package definitions;

import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static support.TestContext.getDriver;

public class OganesyanStepDefs {
    private static String assignmentId = "33478";

    @And("I click on last element containing {string}")
    public void iClickOnLastElementContaining(String searchPattern) {
        List<WebElement> we = getDriver().findElements(By.xpath("//text()[contains(.,'"+searchPattern+"')]/.."));

        we.get(we.size() - 1).click();
    }

    @And("I search for assignment id")
    public void iSearchForAssignmentId() {
        WebElement we = getDriver().findElement(By.xpath("//td/a"));
        String link = we.getAttribute("href");
        String[] s = link.split("/");
        //assignmentId = s[s.length - 1];
    }

    @And("I click on the assignment with id")
    public void iClickOnTheAssignmentWithId() {
        getDriver().findElement(By.xpath("//a[contains(@href, '"+assignmentId+"')]")).click();
    }
}
