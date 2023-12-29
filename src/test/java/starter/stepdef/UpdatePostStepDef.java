package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdatePostStepDef {
    @Steps
    GorestAPI gorestAPI;
    @Given("Update post with valid {int} and {string}")
    public void updatePostWithValidAnd(int id, String json) {
        File jsonUpdatePost = new File(Constants.REQ_BODY+json);
        gorestAPI.updatePost(id, jsonUpdatePost);
    }

    @When("Send request put update post")
    public void sendRequestPutUpdatePost() {
        SerenityRest.when()
                .put(GorestAPI.UPDATE_POST);
    }

    @Given("Update post with {int} and invalid {string}")
    public void updatePostWithAndInvalid(int id, String json) {
        File jsonUpdatePost = new File(Constants.REQ_BODY+json);
        gorestAPI.updatePost(id, jsonUpdatePost);
    }

    @Given("Update post with {int} and {string} using character")
    public void updatePostWithAndUsingCharacter(int id, String json) {
        File jsonUpdatePost = new File(Constants.REQ_BODY+json);
        gorestAPI.updatePost(id, jsonUpdatePost);
    }

    @Given("Update post with {int} and {string} using special character")
    public void updatePostWithAndUsingSpecialCharacter(int id, String json) {
        File jsonUpdatePost = new File(Constants.REQ_BODY+json);
        gorestAPI.updatePost(id, jsonUpdatePost);
    }

    @Given("Update post with non exist {int}")
    public void updatePostWithNonExist(int id) {
        gorestAPI.updatePostWithoutJson(id);
    }

    @Given("Modify post with {int} and valid title {string}")
    public void modifyPostWithAndValidTitle(int id, String json) {
        File jsonUpdatePost = new File(Constants.REQ_BODY+json);
        gorestAPI.updatePost(id, jsonUpdatePost);
    }

    @When("Send request patch modify post")
    public void sendRequestPatchModifyPost() {
        SerenityRest.when()
                .put(GorestAPI.UPDATE_POST);
    }

    @Given("Modify post with {int} and valid body {string}")
    public void modifyPostWithAndValidBody(int id, String json) {
        File jsonUpdatePost = new File(Constants.REQ_BODY+json);
        gorestAPI.updatePost(id, jsonUpdatePost);
    }

    @Given("Modify post with {int} and empty title {string}")
    public void modifyPostWithAndEmptyTitle(int id, String json) {
        File jsonUpdatePost = new File(Constants.REQ_BODY+json);
        gorestAPI.updatePost(id, jsonUpdatePost);
    }

    @Given("Modify post with {int} and empty body {string}")
    public void modifyPostWithAndEmptyBody(int id, String json) {
        File jsonUpdatePost = new File(Constants.REQ_BODY+json);
        gorestAPI.updatePost(id, jsonUpdatePost);
    }
}
