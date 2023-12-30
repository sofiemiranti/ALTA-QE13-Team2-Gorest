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

public class CreateNewPostStepDef {
    @Steps
    GorestAPI gorestAPI;
    @Given("Create new post with valid {string}")
    public void createNewUserWithValid(String json) {
        File jsonCreatePost = new File(Constants.REQ_BODY + json);
        gorestAPI.createNewPost(jsonCreatePost);
    }

    //scenario 1
    @When("Send request post create new post")
    public void sendRequestPostCreateNewPost() {
        SerenityRest.when()
                .post(GorestAPI.CREATE_NEW_POST);
    }

    @And("Response body title was {string} and body was {string}")
    public void responseBodyTitleWasAndBodyWas(String title, String body) {
        SerenityRest.and()
                .body(GorestResponses.TITLE, equalTo(title))
                .body(GorestResponses.BODY, equalTo(body));
    }

    //scenario 2
    @Given("Create new post with invalid {string}")
    public void createNewPostWithInvalid(String json) {
        File jsonCreatePost = new File(Constants.REQ_BODY + json);
        gorestAPI.createNewPost(jsonCreatePost);
    }

    //scenario 3
    @Given("Create new post with empty title {string}")
    public void createNewPostWithEmptyTitle(String json) {
        File jsonCreatePost = new File(Constants.REQ_BODY + json);
        gorestAPI.createNewPost(jsonCreatePost);
    }

    //scenario 4
    @Given("Create new post with empty body {string}")
    public void createNewPostWithEmptyBody(String json) {
        File jsonCreatePost = new File(Constants.REQ_BODY + json);
        gorestAPI.createNewPost(jsonCreatePost);
    }

    //scneario 5
    @Given("Create new post with user id using character {string}")
    public void createNewPostWithUserIdUsingCharacter(String json) {
        File jsonCreatePost = new File(Constants.REQ_BODY + json);
        gorestAPI.createNewPost(jsonCreatePost);
    }


}
