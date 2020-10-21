package com.restAssured;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class BasicAuth {

    @Test
    public void post_Data_Auth()
    {
        RestAssured.baseURI= "https://postman-echo.com/basic-auth";

        PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
        //using this class we can pass user name and password
        authscheme.setUserName("postman");
        authscheme.setPassword("password");

        RestAssured.authentication = authscheme; // adding what type of authentication
        RequestSpecification req = RestAssured.given();
        Response response = req.request(Method.GET,"/"); //no parameters
        int code = response.getStatusCode();
        System.out.println(code);
        String data = response.getBody().asString();
        System.out.println(data);
    }
}


//output
//200
//{"authenticated":true}