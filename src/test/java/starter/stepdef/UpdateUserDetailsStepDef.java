package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;
import starter.gorest.GorestResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateUserDetailsStepDef {
    @Steps
    GorestAPI gorestAPI;
    @Given("Update user with json {string} without id parameter")
    public void updateUserWithoutIdParameter(String json) {
        File jsonUpdateUser = new File(Constants.REQ_BODY + json);
        gorestAPI.updateUserWithoutId(jsonUpdateUser);
    }

    @When("Send request update user")
    public void sendRequestUpdateUser() {
        SerenityRest.when().put(GorestAPI.UPDATE_USER_WITHOUT_ID);
    }
    @When("Send request put for update user")
    public void sendRequestPutForUpdateUser() {
        SerenityRest.when().put(GorestAPI.UPDATE_USER_WITH_ID);
    }

    @And("Response body email was {string}, name was {string}, gender was {string}, and status was {string}")
    public void responseBodyEmailWasNameWasGenderWasAndStatusWas(String email, String name, String gender, String status) {
        SerenityRest.and()
                .body(GorestResponses.EMAIL, equalTo(email))
                .body(GorestResponses.NAME, equalTo(name))
                .body(GorestResponses.GENDER, equalTo(gender))
                .body(GorestResponses.STATUS, equalTo(status));
    }

    @Given("Update user with valid id {int} and json {string}")
    public void updateUserWithoutIdParameter(int id, String json) {
        File jsonUpdateUser = new File(Constants.REQ_BODY + json);
        gorestAPI.updateUser(id, jsonUpdateUser);
    }

    @Given("Update user with invalid path and id {int}")
    public void updateUserWithInvalidPathAndId(int id) {
        gorestAPI.updateUserInvalidPath(id);
    }

    @When("Send request put with invalid path")
    public void sendRequestPutWithInvalidPath() {
        SerenityRest.when().put(GorestAPI.UPDATE_USER_INVALID_PATH_WITH_ID);
    }

    @When("Send request patch for modify user")
    public void sendRequestPatchForModifyUser() {
        SerenityRest.when().patch(GorestAPI.UPDATE_USER_WITH_ID);
    }

    @And("Response body gender was {string} and status was {string}")
    public void responseBodyGenderWasAndStatusWas(String gender, String status) {
        SerenityRest.and()
                .body(GorestResponses.GENDER, equalTo(gender))
                .body(GorestResponses.STATUS, equalTo(status));
    }

}
