package com.restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BDD_Put {

    @Test
    public void putData()
    {
        JSONObject json = new JSONObject();
        json.put("name","Abc");
        json.put("job","DDD");
        System.out.println(json.toJSONString());

                given()
                    .header("content-type","Application/json")
                    .body(json.toJSONString())
                .when()
                    .put("https://reqres.in/api/users/2")
                .then()
                    .statusCode(200).log().all();
    }
}
