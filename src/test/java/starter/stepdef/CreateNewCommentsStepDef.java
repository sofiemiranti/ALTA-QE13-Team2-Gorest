package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;
import starter.utils.Constants;

import java.io.File;

public class CreateNewCommentsStepDef {
    @Steps
    GorestAPI gorestAPI;
    @Given("Create new comments with valid json {string}")
    public void createNewCommentsWithJson(String json) {
        File jsonCreateNewComments = new File(Constants.REQ_BODY+ json);
        gorestAPI.createNewComments(jsonCreateNewComments);
    }

    @When("Send request post create new comments")
    public void sendRequestPostCreateNewComments() {
        SerenityRest.when()
                .post(GorestAPI.CREATE_NEW_COMMENTS);
    }

    @Given("Create new comments with invalid json {string}")
    public void createNewCommentsWithInvalidJson(String json) {
        File jsonCreateNewComments = new File(Constants.REQ_BODY+json);
        gorestAPI.createNewComments(jsonCreateNewComments);
    }

//    @Given("Create new comments with invalid json {string}")
//    public void createNewCommentsWithEmptyName(String json) {
//        File jsonCreateNewComments = new File(Constants.REQ_BODY+json);
//        gorestAPI.createNewComments(jsonCreateNewComments);
//    }

//    @Given("Create new comments with invalid json {string}")
//    public void createNewComments(String json) {
//        File jsonCreateNewComments = new File(Constants.REQ_BODY+json);
//        gorestAPI.createNewComments(jsonCreateNewComments);
//    }

    @Given("Create new comments with json {string}")
    public void createNewCommentsEmptyBody(String json) {
        File jsonCreateNewComments = new File(Constants.REQ_BODY+ json);
        gorestAPI.createNewComments(jsonCreateNewComments);
    }
}
