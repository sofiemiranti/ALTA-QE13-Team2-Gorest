package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;

public class DeleteCommentsStepDef {
    @Steps
    GorestAPI gorestAPI;
    @Given("Delete comments without id")
    public void deleteCommentsWithoutId() {
    }

    @When("Send request delete comments")
    public void sendRequestDeleteComments() {
        SerenityRest.when().delete(GorestAPI.DELETE_COMMENT_WITHOUT_ID);
    }

    @Given("Delete comments with id {string}")
    public void deleteCommentsWithId(String id) {
        gorestAPI.deleteCommentsWithId(id);
    }

    @When("Send request delete comments with id")
    public void sendRequestDeleteCommentsWithId() {
        SerenityRest.when().delete(GorestAPI.DELETE_COMMENT_WITH_ID);
    }

    @Given("Delete comments with unregistered id {string}")
    public void deleteCommentsWithUnregisteredId(String id) {
        gorestAPI.deleteCommentsWithId(id);
    }

}
