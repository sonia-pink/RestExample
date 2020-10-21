package com.restAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BDD_BasicAuth {

    @Test
    public void test2()
    {
        given()
                .auth()
                .preemptive()
                .basic("postman","password")
        .when()
              .get("https://postman-echo.com/basic-auth")
        .then()
        .assertThat().statusCode(200);
    }
}
