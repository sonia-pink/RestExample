package com.restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BDD_DataProvider {

    @DataProvider(name="postData")
    public Object[][] post_Data()
    {
        Object[][] data = new Object[2][2] ;
        data[0][0] = "John";
        data[0][1] = "Teacher";
        data[1][0] = "Mary";
        data[1][1] = "Engineer";
        return data;
        
        /*return new Object[][]{
        {"aaa","bbb"},
        {"ccc","ddd"} };*/
    }

    @Test(dataProvider = "postData")
    public void multiple_data(String name, String job)
    {
        JSONObject json = new JSONObject();
        json.put("name",name);
        json.put("job",job);
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
