package org.example;


import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PatchUserDataRestTest {

    @Before
    public void setUp(){
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru/";
        RestAssured.requestSpecification = given()
                .header("Content-type", "application/json")
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzNiOTYxMTg0NTQ2MzAwM2RmZTE3MmQiLCJpYXQiOjE3MzIxMjI0MDksImV4cCI6MTczMjcyNzIwOX0.v3qX4EZElkFFsT75oS_Il5i3J0DpVuO7oehWwzB71u4");
    }

    @Test
    public void testUserInfoPatchResponse200NameAndAboutAssert(){
        String expectedName = "Залупекс";
        String expectedDescription = "Никчемыш";
        UserInfo userInfo = new UserInfo(expectedName, expectedDescription);

        Response response = pushUserInfo(userInfo);
        ValidatableResponse validatableResponse = checkStatusCode(response);
        checkUserDataAssertion(validatableResponse, expectedName, expectedDescription);

    }


    @Step("Изменить данные о пользователе")
    public Response pushUserInfo(UserInfo userInfo){
        return given().body(userInfo).patch("api/users/me");
    }
    @Step("Проверить статус-код")
    public ValidatableResponse checkStatusCode(Response response){
        return response.then().statusCode(200);
    }
    @Step("Проверить данные на соответствие ожидаемым")
        public void checkUserDataAssertion(ValidatableResponse response, String expectedName, String expectedDescription){
        response.body("data.name", equalTo(expectedName)).and()
                .body("data.about", equalTo(expectedDescription));
    }
}
