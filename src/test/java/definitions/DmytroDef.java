package definitions;

import cucumber.api.java.en.And;
import org.openqa.selenium.By;

public class DmytroDef {
    @And("I click on last element containing {string}")
    public void iClickOnLastElementContaining(String searchPattern) {
        List<WebElement> we = getDriver().findElements(By.xpath("//text()[contains(.,'"+searchPattern+"')]/.."));

        we.get(we.size() - 1).click();
    }

    private By getDriver() {
    }
}
