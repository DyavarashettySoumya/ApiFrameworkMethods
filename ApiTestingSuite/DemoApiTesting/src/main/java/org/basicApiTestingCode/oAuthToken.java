package org.basicApiTestingCode;

import static io.restassured.RestAssured.given;

public class oAuthToken {

    public static void main(String[] args) {

    String response=given().queryParam("access_token","")
            .when()
            .get("https://rahulshettyacademy.com/getCourse.php").asString();
        System.out.println(response);
    }
}
