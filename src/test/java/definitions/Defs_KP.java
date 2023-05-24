package definitions;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static support.TestContext.getDriver;

public class Defs_KP {


//    Slider defs

    @When("I increase the slider with xpath {string} by value {int}")
    public void iIncreaseSliderWithXpathToValue(String xpath, int slidevalue) {

        WebElement slider = getDriver().findElement(By.xpath(xpath));
        for (int i = 1; i <= slidevalue; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);

        }
    }

}
