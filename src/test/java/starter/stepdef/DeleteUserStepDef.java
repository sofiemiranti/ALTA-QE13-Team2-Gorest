package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;

public class DeleteUserStepDef {
    @Steps
    GorestAPI gorestAPI;

    @Given("Delete user without user id")
    public void deleteUserWithoutUserId() {
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(GorestAPI.DELETE_USER_WITHOUT_ID);
    }

    @Given("Delete user with id {int}")
    public void deleteUserWithId(int id) {
        gorestAPI.deleteUserWithId(id);
    }

    @When("Send request delete user with id")
    public void sendRequestDeleteUserWithId() {
        SerenityRest.when().delete(GorestAPI.UPDATE_USER_WITH_ID);
    }

    @Given("Delete user with id {int} and invalid path")
    public void deleteUserWithIdAndInvalidPath(int id) {
        gorestAPI.deleteUserInvalidPath(id);
    }

    @When("Send request delete user with invalid path")
    public void sendRequestDeleteUserWithInvalidPath() {
        SerenityRest.when().delete(GorestAPI.DELETE_USER_INVALID_PATH);
    }
}
