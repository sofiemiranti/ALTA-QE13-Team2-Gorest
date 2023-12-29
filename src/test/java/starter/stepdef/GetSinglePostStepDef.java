package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;
import starter.gorest.GorestResponses;

import static org.hamcrest.Matchers.equalTo;

public class GetSinglePostStepDef {
    @Steps
    GorestAPI gorestAPI;

    //scenario 1
    @Given("Get single post with valid {int}")
    public void getSinglePostWithValid(int id) {
        gorestAPI.getSinglePost(id);
    }

    @When("Send request get single post")
    public void sendRequestGetSinglePost() {
        SerenityRest.when().
                get(GorestAPI.GET_SINGLE_POST);
    }

    @And("Response body id was {int}")
    public void responseBodyIdWas(int id) {
        SerenityRest.and()
                .body(GorestResponses.ID, equalTo(id));
    }

    //scenario 2
    @Given("Get single post with {string} using character")
    public void getSinglePostWithUsingCharacter(String id) {
        gorestAPI.getSinglePostInvalid(id);
    }

    //scenario 3
    @Given("Get single post with {string} using special character")
    public void getSinglePostWithUsingSpecialCharacter(String id) {
        gorestAPI.getSinglePostInvalid(id);
    }

    //scenario 4
    @Given("Get single post with non exist {int}")
    public void getSinglePostWithNonExist(int id) {
        gorestAPI.getSinglePost(id);
    }
}
