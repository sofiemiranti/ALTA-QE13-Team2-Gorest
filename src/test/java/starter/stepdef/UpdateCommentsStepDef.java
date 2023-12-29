package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdateCommentsStepDef {
    @Steps
    GorestAPI gorestAPI;
    @Given("Update comments details without id {string}")
    public void updateCommentsDetailsWithoutId(String id) {
        gorestAPI.updateCommentsWithoutJson(id);
    }
    @When("Send request put update comments")
    public void sendRequestPutUpdateComments() {
        SerenityRest.when()
                .put(GorestAPI.UPDATE_COMMENT);
    }

    @Given("Update comments details with valid data {string}")
    public void updateCommentsDetailsWithValidData(String id) {
        gorestAPI.updateCommentsWithoutJson(id);
    }

    @Given("Update comments details with invalid json {string}")
    public void updateCommentsDetailsWithInvalidJson(String email) {
        gorestAPI.updateCommentsWithoutJson(email);
    }

    @Given("Modify comments details with valid json {string}")
    public void modifyCommentsDetailsWithValidJson(String name) {
        gorestAPI.modifyCommentsWithJson(name);
    }

    @When("Send request patch modify comments")
    public void sendRequestPatchModifyComments() {
        SerenityRest.when()
                .patch(GorestAPI.MODIFY_COMMENTS);
    }

    @Given("Modify comments details with invalid json {string}")
    public void modifyCommentsDetailsWithInvalidJson(String email) {
        gorestAPI.modifyCommentsWithJson(email);
    }
}
