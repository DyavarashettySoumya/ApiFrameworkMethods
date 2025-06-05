package org.basicApiTestingCode;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiCode {
    public static void main(String[] args) {

        // TODO Auto-generated method stub
// validate if Add Place API is workimg as expected
        //Add place-> Update Place with New Address -> Get Place to validate if New address is present in response

        //given - all input details
        //when - Submit the API -resource,http method
        //Then - validate the response
//        RestAssured.baseURI= "https://rahulshettyacademy.com";
//        String response=given().log().all().queryParam("key", "qaclick123").
//                header("Content-Type","application/json")
//                .body(payload.AddPlace()).when().post("maps/api/place/add/json")
//                .then().assertThat().statusCode(200).
//                body("scope", equalTo("APP"))
//                .header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
//
//        System.out.println(response);
//        //response keys retriving process
//        JsonPath js=new JsonPath(response); //for parsing Json
//        String placeId=js.getString("place_id");
//
//        System.out.println(placeId);
//
////        //Update Place
//        String newAddress = "Summer Walk, Africa";
//
//        given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
//                .body("{\r\n" +
//                        "\"place_id\":\""+placeId+"\",\r\n" +
//                        "\"address\":\""+newAddress+"\",\r\n" +
//                        "\"key\":\"qaclick123\"\r\n" +
//                        "}").
//                when().put("maps/api/place/update/json")
//                .then().assertThat().log().all().statusCode(200).
//                body("msg", equalTo("Address successfully updated"));


        //Get Place

//        String getPlaceResponse=	given().log().all().queryParam("key", "qaclick123")
//                .queryParam("place_id",placeId)
//                .when().get("maps/api/place/get/json")
//                .then().assertThat().log().all().statusCode(200).extract().response().asString();
//        JsonPath js1=ReUsableMethods.rawToJson(getPlaceResponse);
//        String actualAddress =js1.getString("address");
//        System.out.println(actualAddress);
//        Assert.assertEquals(actualAddress, "Pacific ocean");
//        //Cucumber Junit, Testng

        //TokenGeneration
        String accessTokenResponse = given()
                .queryParams("username","tfwebservice@gatestautomation.com")
                .queryParams("password","Gaian@123")
                .queryParams("grant_type","password")
                .queryParams("checkB2B","true")
                .queryParams("clientId","gaian")
                .queryParams("provider","other")
                .queryParams("productId","604789eb42b7dc00017a8341")
                .when().log().all().post("http://ingress-gateway.gaiansolutions.com/iam-service/oauth/token")
                .asString();
        JsonPath js1= new JsonPath(accessTokenResponse);
        String accessToken=js1.getString("access_token");
        System.out.println(accessToken);


    }
}