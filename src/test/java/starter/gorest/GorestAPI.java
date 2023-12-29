package starter.gorest;

import io.restassured.http.ContentType;
import net.serenitybdd.cucumber.suiteslicing.SerenityTags;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class GorestAPI {

    public static String CREATE_NEW_USER = Constants.BASE_URL + "/public/v2/users";
    public static String CREATE_NEW_POST = Constants.BASE_URL+"/public/v2/posts";
    public static String CREATE_NEW_COMMENTS = Constants.BASE_URL+"/public/v2/comments";
    public static String GET_USER_DETAILS_WITHOUT_ID = Constants.BASE_URL + "/public/v2/users";
    public static String GET_USER_DETAILS_WITH_ID = Constants.BASE_URL + "/public/v2/users/{id}";
    public static String GET_USER_DETAILS_NAME_GENDER = Constants.BASE_URL + "/public/v2/users?name={name}&gender={gender}";
    public static String GET_USER_DETAILS_INVALID_PARAM = Constants.BASE_URL + "/public/v2/users?invalid_param={invalid_param}";
    public static String GET_LIST_POST = Constants.BASE_URL+ "/public/v2/posts?page={page}";
    public static String GET_SINGLE_POST = Constants.BASE_URL+ "/public/v2/posts/{id}";
    public static String GET_USER_DETAILS_WITH_EMAIL = Constants.BASE_URL + "/public/v2/users?email={email}";
    public static String GET_COMMENTS_DETAILS_WITHOUT_ID = Constants.BASE_URL+ "/public/v2/comments";
    public static String GET_COMMENTS_DETAILS_WITH_ID = Constants.BASE_URL+ "/public/v2/comments/{id}";
    public static String GET_COMMENTS_DETAILS_NAME_PARAM = Constants.BASE_URL+"/public/v2/comments?name={name}";
    public static String GET_COMMENTS_DETAILS_INVALID_PARAM = Constants.BASE_URL+"/public/v2/comments?invalid_param={invalid_param}";
    public static String UPDATE_POST = Constants.BASE_URL+"/public/v2/posts/{id}";

    public static String UPDATE_USER_WITHOUT_ID = Constants.BASE_URL + "/public/v2/users";
    public static String UPDATE_USER_WITH_ID = Constants.BASE_URL + "/public/v2/users/{id}";
    public static String UPDATE_USER_INVALID_PATH_WITH_ID = Constants.BASE_URL + "/publiccc/v2/users/{id}";
    public static String DELETE_POST = Constants.BASE_URL + "/public/v2/posts/{id}";
    public static String DELETE_USER_WITHOUT_ID = Constants.BASE_URL + "/public/v2/users";
    public static String DELETE_USER_WITH_ID = Constants.BASE_URL + "/public/v2/users/{id}";
    public static String DELETE_USER_INVALID_PATH = Constants.BASE_URL + "/publiccc/v2/users/{id}";

    public static String UPDATE_COMMENT = Constants.BASE_URL+"/public/v2/comments/{id}";
    public static String MODIFY_COMMENTS = Constants.BASE_URL+"/public/v2/comment/name={page}";

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
    @Step("Create new comments")
    public void createNewComments (File json){
        SerenityRest.given()
                .header("Authorization","Bearer f44b82b9d89a01d93f5719b21ab257dfccd8c682be8774052489c68211fd9eab")
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Get user details with id")
    public void getUserDetailsWithId (int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get user details with invalid id")
    public void getUserDetailsWithInvalidId (String id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get user details with valid name and gender param")
    public void getUserDetailsNameGender (String name, String gender) {
        SerenityRest.given().pathParam("name", name).pathParam("gender", gender);
    }

    @Step("Get user details with invalid param")
    public void getUserDetailsWithInvalidParam (String invalid_param) {
        SerenityRest.given().pathParam("invalid_param", invalid_param);
    }
    @Step("Get list post")
    public void getListPost(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Get list post invalid page")
    public void getListPostInvalid(String page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Get single post")
    public void getSinglePost(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Get single post invalid id")
    public void getSinglePostInvalid(String id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step("Get user details with email")
    public void getUserDetailsWithEmailParam (String email) {
        SerenityRest.given().pathParam("email", email );
    }
    @Step("Update post")
    public void updatePost (int id, File json){
        SerenityRest.given()
                .header("Authorization","Bearer f44b82b9d89a01d93f5719b21ab257dfccd8c682be8774052489c68211fd9eab")
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Update post without json")
    public void updatePostWithoutJson (int id){
        SerenityRest.given()
                .header("Authorization","Bearer f44b82b9d89a01d93f5719b21ab257dfccd8c682be8774052489c68211fd9eab")
                .pathParam("id", id);
    }
    @Step("Get comments details with id")
    public void getCommentsDetails (String id) {
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get comments details with name parameter")
    public void getCommentNameParam(String name){
        SerenityRest.given().pathParam("name", name);
    }
    @Step("Get user details with invalid param")
    public void getCommentsDetailsWithInvalidParam (String invalid_param) {
        SerenityRest.given().pathParam("invalid_param", invalid_param);
    }
    @Step("Update comments without json")
    public void updateCommentsWithoutJson (String id){
        SerenityRest.given()
                .header("Authorization","Bearer f44b82b9d89a01d93f5719b21ab257dfccd8c682be8774052489c68211fd9eab")
                .pathParam("id", id);
    }
    @Step("Modify comments with json")
    public void modifyCommentsWithJson (String page){
        SerenityRest.given()
                .header("Authorization","Bearer f44b82b9d89a01d93f5719b21ab257dfccd8c682be8774052489c68211fd9eab")
                .pathParam("page", page);
    }

    @Step ("Update user without id")
    public void updateUserWithoutId (File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer f44b82b9d89a01d93f5719b21ab257dfccd8c682be8774052489c68211fd9eab")
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Update user")
    public void updateUser (int id, File json){
        SerenityRest.given()
                .header("Authorization", "Bearer f44b82b9d89a01d93f5719b21ab257dfccd8c682be8774052489c68211fd9eab")
                .pathParam("id", id)
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Update user invalid path")
    public void updateUserInvalidPath (int id){
        SerenityRest.given()
                .header("Authorization", "Bearer f44b82b9d89a01d93f5719b21ab257dfccd8c682be8774052489c68211fd9eab")
                .pathParam("id", id);
    }
    @Step("Delete post")
    public void deletePost (int id){
        SerenityRest.given()
                .header("Authorization", "Bearer f44b82b9d89a01d93f5719b21ab257dfccd8c682be8774052489c68211fd9eab")
                .pathParam("id", id);
    }
    @Step("Delete post invalid id")
    public void deletePostInvalid (String id){
        SerenityRest.given()
                .header("Authorization", "Bearer f44b82b9d89a01d93f5719b21ab257dfccd8c682be8774052489c68211fd9eab")
                .pathParam("id", id);
    }

    @Step("Delete user with id")
    public void deleteUserWithId (int id) {
        SerenityRest.given()
                .header("Authorization", "Bearer f44b82b9d89a01d93f5719b21ab257dfccd8c682be8774052489c68211fd9eab")
                .pathParam("id", id);
    }

    @Step("Delete user with invalid path")
    public void deleteUserInvalidPath (int id) {
        SerenityRest.given()
                .header("Authorization", "Bearer f44b82b9d89a01d93f5719b21ab257dfccd8c682be8774052489c68211fd9eab")
                .pathParam("id", id);
    }

}
