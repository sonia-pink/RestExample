package com.restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteRequest {

    @Test
    public void deleteData()
    {
        RequestSpecification req = RestAssured.given();
        Response res = req.delete("https://reqres.in/api/users/2");
        int code = res.getStatusCode();
        System.out.println(code);
        Assert.assertEquals(code,204);
    }
}
