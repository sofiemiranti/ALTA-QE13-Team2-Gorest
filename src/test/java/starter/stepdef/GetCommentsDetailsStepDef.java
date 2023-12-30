package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;

public class GetCommentsDetailsStepDef {
    @Steps
    GorestAPI gorestAPI;
    //Scenario 1
    @Given("Get comments details without id")
    public void getCommentDetailsWithoutId() {
    }

    //Scenario 2
    @Given("Get comments details with valid id {int}")
    public void getCommentsDetailsWithValidId(int id) {
        gorestAPI.getCommentsDetails(id);
    }

    @When("Send request get comments details with valid id")
    public void sendRequestGetCommentsDetailsWithValidId() {
        SerenityRest.when().get(GorestAPI.GET_COMMENTS_DETAILS_WITH_ID);
    }
    //Scenario 3
    @Given("Get comments details with invalid id {string}")
    public void getCommentsDetailsWithInvalidId(String id) {
        gorestAPI.getCommentsDetailss(id);
    }

    @When("Send request get comments details with invalid id")
    public void sendRequestGetCommentsDetailsWithInvalidId() {
        SerenityRest.when().get(GorestAPI.GET_COMMENTS_DETAILS_WITH_ID);
    }

    //Scenario 4
    @Given("Get comments details with alphabet id {string}")
    public void getCommentsDetailsWithAlphabetId(String id) {
        gorestAPI.getCommentsDetailss(id);
    }

    @When("Send request get comments details with alphabet id")
    public void sendRequestGetCommentsDetailsWithAlphabetId() {
        SerenityRest.when().get(GorestAPI.GET_COMMENTS_DETAILS_WITH_ID);
    }

    //Scenario 5
    @Given("Get comments details with special character id {string}")
    public void getCommentsDetailsWithSpecialCharacterId(String id) {
        gorestAPI.getCommentsDetailss(id);
    }

    @When("Send request get comments details with special character id")
    public void sendRequestGetCommentsDetailsWithSpecialCharacterId() {
        SerenityRest.when().get(GorestAPI.GET_COMMENTS_DETAILS_WITH_ID);
    }

    //Scenario 6
    @Given("Get comments details with valid parameter name is {string}")
    public void getCommentsDetailsWithValidParameterNameIs(String name) {
        gorestAPI.getCommentNameParam(name);
    }

    @When("Send request get comments details with name parameter")
    public void sendRequestGetCommentsDetailsWithNameParameter() {
        SerenityRest.when().get(GorestAPI.GET_COMMENTS_DETAILS_NAME_PARAM);
    }

    //Scenario 7
    @Given("Get comments details with parameter name is {string}")
    public void getCommentsDetailsWithParameterNameIs(String name) {
        gorestAPI.getCommentNameParam(name);
    }

    @When("Send request get comments details")
    public void sendRequestGetCommentsDetails() {
        SerenityRest.when().get(GorestAPI.GET_COMMENTS_DETAILS_NAME_PARAM);
    }

    @Given("Get commants with invalid parameter is {string}")
    public void getCommantsWithInvalidParameterIs(String invalid_param) {
        gorestAPI.getCommentsDetailsWithInvalidParam(invalid_param);
    }

    @When("Send request get comments details with invalid parameter")
    public void sendRequestGetCommentsDetailsWithInvalidParameter() {
        SerenityRest.when().get(GorestAPI.GET_COMMENTS_DETAILS_INVALID_PARAM);
    }
}
