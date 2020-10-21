package com.restAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetRequest {


    @Test
    public void getRequestMethod()
    {
        Response res = RestAssured.get("https://reqres.in/api/users?page=2");
        int statusCode = res.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode,200);

        /*RestAssured.baseURI = "https://reqres.in/";
        String endURL = "/api/users";
        RequestSpecification req = RestAssured.given();
        Response res = req.request(Method.GET,endURL);
        int statusCode = res.statusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode,200);

        String jsonPayload =res.asString();
        System.out.println("Payload " +jsonPayload);*/
        
    }

    @Test
    public void getContentType()
    {
       Response res = RestAssured.get("https://reqres.in/api/users?page=2");
        String contentType = res.contentType();
        System.out.println(contentType);
        Assert.assertEquals(contentType,"application/json; charset=utf-8");
    }
}
