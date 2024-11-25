package org.example;

import io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class RestTest {
    @Before
    public void setUp(){
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru/";
        RestAssured.requestSpecification = given()
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzNiOTYxMTg0NTQ2MzAwM2RmZTE3MmQiLCJpYXQiOjE3MzIxMjI0MDksImV4cCI6MTczMjcyNzIwOX0.v3qX4EZElkFFsT75oS_Il5i3J0DpVuO7oehWwzB71u4");
    }

    @Test
    public void testApiCardsResponse200(){
        given().when().get("api/cards").then().assertThat().statusCode(200);
    }
    @Test
    public void testApiUserDescriptionCorrect(){
        String expected = "Самый крутой исследователь";
        Response response = given().get("api/users/me");
        response.then().body("data.about", equalTo(expected));
    }
    @Test
    public void testApiUserDescriptionSchangeResponse200NameSame(){
        String json = "{\"name\": \"Василий Васильев\", \"about\": \"Самый крутой исследователь\"}";
        Response response = given().header("Content-type", "application/json").body(json).patch("api/users/me");
        response.then().assertThat().statusCode(200).and().body("data.name", equalTo("Василий Васильев"));
    }
}
