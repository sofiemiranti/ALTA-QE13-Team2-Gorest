package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;

public class DeletePostStepDef {
    @Steps
    GorestAPI gorestAPI;
    @Given("Delete post with valid {int}")
    public void deletePostWithValid(int id) {
        gorestAPI.deletePost(id);
    }

    @When("Send request delete posts")
    public void sendRequestDeletePosts() {
        SerenityRest.when().delete(GorestAPI.DELETE_POST);
    }

    @Given("Delete post with non exist {int}")
    public void deletePostWithNonExist(int id) {
        gorestAPI.deletePost(id);
    }

    @Given("Delete post with invalid {string}")
    public void deletePostWithInvalid(String id) {
        gorestAPI.deletePostInvalid(id);
    }
}
