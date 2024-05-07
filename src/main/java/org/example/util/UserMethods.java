package org.example.util;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.example.pojo.User;

import static org.example.constants.Handle.*;
import static io.restassured.RestAssured.given;

public class UserMethods {
    @Step("Создание пользователя")
    public Response createUser(User user) {
        return given().spec(BaseHttpClient.baseRequestSpec())
                .body(user)
                .when()
                .post(CREATE_USER);
    }

    @Step("Логин пользователя")
    public Response loginUser(User user) {
        return given().spec(BaseHttpClient.baseRequestSpec())
                .body(user)
                .when()
                .post(LOGIN_USER);
    }

    @Step("Удалить пользователя")
    public ValidatableResponse deleteUser(String accessToken) {
        return given().spec(BaseHttpClient.baseRequestSpec())
                .header("Authorization", accessToken)
                .when()
                .delete(DELETE_USER)
                .then()
                .assertThat()
                .statusCode(202);
    }
}
