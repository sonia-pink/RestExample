package com.restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BDD_Delete {

   @Test
    public void deleteData()
    {
        given()
        .when()
            .delete("https://reqres.in/api/users/2")
            .then()
            .assertThat().statusCode(204)
             .log().all();
    }
}
