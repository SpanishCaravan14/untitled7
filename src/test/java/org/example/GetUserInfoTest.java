package org.example;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetUserInfoTest {

    @Before
    public void setUp(){
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru/";
        RestAssured.requestSpecification = given()
                        .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzNiOTYxMTg0NTQ2MzAwM2RmZTE3MmQiLCJpYXQiOjE3MzIxMjI0MDksImV4cCI6MTczMjcyNzIwOX0.v3qX4EZElkFFsT75oS_Il5i3J0DpVuO7oehWwzB71u4");
    }

    @Test
    public void checkGet(){
       UserResponseCommon userResponseCommon = given().get("api/users/me").as(UserResponseCommon.class);
        System.out.println(userResponseCommon.getData().getName());
    }

}
