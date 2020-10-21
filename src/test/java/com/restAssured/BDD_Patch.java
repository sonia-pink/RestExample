package com.restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BDD_Patch {

    @Test
    public void patchData()
    {

        JSONObject json = new JSONObject();
        json.put("name","Abc");
        json.put("job","DDD");
        System.out.println(json.toJSONString());

        given()
                .header("content-type","Application/json")
                .body(json.toJSONString())
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(200).log().all();
    }
}
