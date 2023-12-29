package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;
import starter.gorest.GorestResponses;

import static org.hamcrest.Matchers.equalTo;

public class GetUserDetailsStepDef {
    @Steps
    GorestAPI gorestAPI;

    @Given("Get user details without user id parameter")
    public void getUserDetailsWithoutUserIdParameter() {
    }

    @When("Send request get user details without id parameter")
    public void sendRequestGetUserDetails() {
        SerenityRest.when().get(GorestAPI.GET_USER_DETAILS_WITHOUT_ID);
    }

    @Given("Get user details with user id {int}")
    public void getUserDetailsWithUserId(int id) {
        gorestAPI.getUserDetailsWithId(id);
    }

    @When("Send request get user details with user id")
    public void sendRequestGetUserDetailsWithUserId() {
        SerenityRest.when().get(GorestAPI.GET_USER_DETAILS_WITH_ID);
    }

    @And("Response body message was {string}")
    public void responseBodyMessageWas(String message) {
        SerenityRest.and().body(GorestResponses.MESSAGE_NOT_FOUND, equalTo(message));
    }

    @Given("Get user details with user id {string}")
    public void getUserDetailsWithUserId(String id) {
        gorestAPI.getUserDetailsWithInvalidId(id);
    }

    @When("Send request get user details with invalid user id")
    public void sendRequestGetUserDetailsWithInvalidUserId() {
        SerenityRest.when().get(GorestAPI.GET_USER_DETAILS_WITH_ID);
    }

    @Given("Get user details with parameter name is {string} and gender is {string}")
    public void getUserDetailsWithValidParameterNameIsAndGenderIs(String name, String gender) {
        gorestAPI.getUserDetailsNameGender(name, gender);
    }

    @When("Send request get user details with name and gender parameter")
    public void sendRequestGetUserDetailsWithNameAndGenderParameter() {
        SerenityRest.when().get(GorestAPI.GET_USER_DETAILS_NAME_GENDER);
    }

    @Given("Get user with invalid parameter is {string}")
    public void getUserWithInvalidParameterIs(String invalid_param) {
        gorestAPI.getUserDetailsWithInvalidParam(invalid_param);
    }

    @When("Send request get user details with invalid parameter")
    public void sendRequestGetUserDetailsWithInvalidParameter() {
        SerenityRest.when().get(GorestAPI.GET_USER_DETAILS_INVALID_PARAM);
    }

    @Given("Get user details with parameter email is {string}")
    public void getUserDetailsWithParameterEmailIs(String email) {
        gorestAPI.getUserDetailsWithEmailParam(email);
    }

    @When("Send request get user details with parameter email")
    public void sendRequestGetUserDetailsWithParameterEmail() {
        SerenityRest.when().get(GorestAPI.GET_USER_DETAILS_WITH_EMAIL);
    }
}
