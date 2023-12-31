package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;
import starter.gorest.GorestResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateNewUserStepDef {
    @Steps
    GorestAPI gorestAPI;

    @Given("Create new user with json {string}")
    public void createNewUserWithJson(String json) {
        File jsonCreateUser = new File(Constants.REQ_BODY + json);
        gorestAPI.createNewUser(jsonCreateUser);
    }

    @When("Send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(GorestAPI.CREATE_NEW_USER);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate json schema {string}")
    public void validateJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+ json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Response body field was {string} and message was {string}")
    public void responseBodyFieldWasAndMessageWas(String field, String message) {
        SerenityRest.and()
                .body(GorestResponses.FIELD, equalTo(field))
                .body(GorestResponses.MESSAGE, equalTo(message));
    }

    @And("Response body second field was {string} and message was {string}")
    public void responseBodySecondFieldWasAndMessageWas(String field, String message) {
        SerenityRest.and()
                .body(GorestResponses.FIELD_2, equalTo(field))
                .body(GorestResponses.MESSAGE_2, equalTo(message));
    }
}
