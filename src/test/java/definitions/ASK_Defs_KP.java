package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import okhttp3.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ASK_Components_KP;
import support.Helper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import static support.TestContext.getDriver;

public class ASK_Defs_KP {

    private static String token;
    private static String acctID = "0";

//    Slider defs

    @When("I increase the slider with xpath {string} by value {int}")
    public void iIncreaseSliderWithXpathToValue(String xpath, int slidevalue) {

        WebElement slider = getDriver().findElement(By.xpath(xpath));
        for (int i = 1; i <= slidevalue; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);

        }
    }


    @When("I decrease the slider with xpath {string} by value {int}")
    public void iDecreaseSliderWithXpathToValue(String xpath, int slidevalue) {

        WebElement slider = getDriver().findElement(By.xpath(xpath));
        for (int i = 1; i <= slidevalue; i++) {
            slider.sendKeys(Keys.ARROW_LEFT);

        }
    }


//    Artem's defs

    @And("I type {string} into element {string}")
    public void iTypeIntoElement(String text, String fieldName) {
        getDriver().findElement(By.xpath(ASK_Components_KP.componentFor(fieldName))).sendKeys(text);

    }
//    Element component defs

    @And("I wait for element {string} to be present")
    public void iWaitForElementToBePresent(String fieldName) {
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ASK_Components_KP.componentFor(fieldName))));
    }


    @And("I click on element {string}")
    public void iClickOnElement(String clickElement) {
        getDriver().findElement(By.xpath(ASK_Components_KP.componentFor(clickElement))).click();
    }

    @And("I go back to previous page")
    public void iGoBackToPreviousPage() {
        getDriver().navigate().back();
    }

    @And("I log out")
    public void iLogOut() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
//        new WebDriverWait(getDriver(),1000);
        TimeUnit.MILLISECONDS.sleep(200);
        getDriver().findElement(By.xpath("//button/span[text()='Log Out']")).click();
    }


    @And("I click on Quiz with name {string} and index {int}")
    public void iClickOnQuizWithNameStringAndIndexInt(String quizName, Integer index) {
        getDriver().findElement(By.xpath("//mat-expansion-panel/span/mat-panel-title[text()='" + quizName + "'][" + index + "]")).click();

    }

    @And("I click on Quiz with index {int}")
    public void iClickOnQuizWithIndex(Integer index) {
        getDriver().findElement(By.xpath("//mat-expansion-panel" + "[" + index + "]")).click();
    }

    @And("I click on quiz with unique name {string}")
    public void iClickOnQuizWithUniqueName(String quizName) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizName + "')]")).click();
    }


    //   API defs

    //   Check if Acct exists by email and password, and delete if it exists

    @Given("I Cleanup account by email {string} and password {string}")
    public void iCleanupAccountByEmail(String testAcctEmail, String testAcctPass) throws IOException, ParseException {

        // Logs in as "teacher@gmail.com" to obtain admin token

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n  \"email\": \"teacher@gmail.com\",\r\n  \"password\": \"12345Abc\"\r\n}");
        Request request = new Request.Builder()
                .url("http://ask-stage.portnov.com/api/v1/sign-in")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        JSONParser parser = new JSONParser();
        assert response.body() != null;
        JSONObject resp = (JSONObject)parser.parse(response.body().string());

        System.out.println(resp.get("token"));
        token = resp.get("token").toString();

        System.out.println("Admin token for teacher@gmail.com was obtained");


        // Logs in with specified e-mail to obtain acctID

        System.out.println("Verifying account for "+testAcctEmail);

        String acctID = "0";

        OkHttpClient client2 = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType2 = MediaType.parse("application/json");
        RequestBody body2 = RequestBody.create(mediaType, "{\r\n  \"email\": "+testAcctEmail+",\r\n\r\n  \"password\": "+testAcctPass+"\r\n}");
        Request request2 = new Request.Builder()
                .url("http://ask-stage.portnov.com/api/v1/sign-in")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response2 = client2.newCall(request).execute();

        JSONParser parser2 = new JSONParser();

        assert response2.body() != null;
        JSONObject resp2 = (JSONObject)parser2.parse(response2.body().string());
        System.out.println(resp2);

        String user = resp2.get("user").toString();
        System.out.println(user);

        JSONParser parser3 = new JSONParser();
        JSONObject innerjson = (JSONObject)parser3.parse(String.valueOf(user));
        System.out.println(innerjson.get("id").toString());

//        acctID = innerjson.get("id").toString();
        System.out.println(acctID);



       //  If account is found, deletes account using acctID and admin token

        if (!acctID.equals("0")) {

            System.out.println("Account was found. Deleting.");

            // API DELETE request is sent

            OkHttpClient client3 = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType3 = MediaType.parse("text/plain");
            RequestBody body3 = RequestBody.create(mediaType, "");
            Request request3 = new Request.Builder()
                    .url("http://ask-stage.portnov.com/api/v1/users/"+acctID)
                    .method("DELETE", body)
                    .addHeader("Authorization", token)
                    .build();
            Response response3 = client.newCall(request).execute();

            System.out.println("User "+testAcctEmail+" was deleted.");
        }

        else System.out.println("Account not found in system.");


    }


    @Given("I obtain account ID for email {string}")
    public void iObtainAccountIDForEmail(String acctEmail) throws SQLException {
        System.out.println(Helper.getAccessToken(acctEmail));
        String[] helperToken = (Helper.getAccessToken(acctEmail).split(";"));
        acctID = helperToken[0];

    }

    @Given("I obtain admin token")
    public void iObtainAdminToken() throws IOException, ParseException {

        // Logs in as "teacher@gmail.com" to obtain admin token

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n  \"email\": \"teacher@gmail.com\",\r\n  \"password\": \"12345Abc\"\r\n}");
        Request request = new Request.Builder()
                .url("http://ask-stage.portnov.com/api/v1/sign-in")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        JSONParser parser = new JSONParser();
        assert response.body() != null;
        JSONObject resp = (JSONObject)parser.parse(response.body().string());

        System.out.println(resp.get("token"));
        token = resp.get("token").toString();

        System.out.println("Admin token for teacher@gmail.com was obtained");
    }

    @And("I delete the account if it exists")
    public void iDeleteTheAccountIfItExists() throws IOException {

        if (!acctID.equals("0")) {

            System.out.println("Account was found. Deleting.");

            // API DELETE request is sent

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url("http://ask-stage.portnov.com/api/v1/users/"+acctID)
                    .method("DELETE", body)
                    .addHeader("Authorization", token)
                    .build();
            Response response = client.newCall(request).execute();

            System.out.println("User account deleted.");
        }

        else System.out.println("Account not found in system.");
    }


}