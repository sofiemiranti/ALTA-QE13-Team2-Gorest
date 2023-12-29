package starter.gorest;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class GorestAPI {

    public static String CREATE_NEW_USER = Constants.BASE_URL + "/public/v2/users";
    public static String CREATE_NEW_POST = Constants.BASE_URL+"/public/v2/posts";

    @Step ("Create new user")
    public void createNewUser (File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer f44b82b9d89a01d93f5719b21ab257dfccd8c682be8774052489c68211fd9eab")
                .contentType(ContentType.JSON).body(json);
    }
    @Step("Create new post")
    public void createNewPost (File json){
        SerenityRest.given()
                .header("Authorization","Bearer f44b82b9d89a01d93f5719b21ab257dfccd8c682be8774052489c68211fd9eab")
                .contentType(ContentType.JSON).body(json);
    }
}
