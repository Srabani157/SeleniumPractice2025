package com.apiAutomation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqResAutomation {

    @Test
    public void getReq(){
        RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
        String response = given()
                .when()
                .get("BookStore/v1/Books")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body().asPrettyString();
        System.out.println(response);

        JsonPath jsonPath = new JsonPath(response);
        String error = jsonPath.getString("error");
        String howTo = jsonPath.getString("how_to_get_one");
        System.out.println(error+ ".... " +howTo);
    }


}
