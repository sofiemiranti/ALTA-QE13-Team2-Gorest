package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;

public class GetListPostStepDef {
    @Steps
    GorestAPI gorestAPI;

    //scenario 1
    @Given("Get list post with valid param {int}")
    public void getListPostWithValidParam(int page) {
        gorestAPI.getListPost(page);
    }

    @When("Send request get list post")
    public void sendRequestGetListPost() {
        SerenityRest.when()
                .get(GorestAPI.GET_LIST_POST);
    }

    //scenario 2
    @Given("Get list post with invalid param {string}")
    public void getListPostWithInvalidParam(String page) {
        gorestAPI.getListPostInvalid(page);
    }

    //scenario 3
    @Given("Get list post with non exist {int}")
    public void getListPostWithNonExist(int page) {
        gorestAPI.getListPost(page);
    }
}
