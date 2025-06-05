package org.basicApiTestingCode;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.sun.istack.logging.Logger.getLogger;
import static io.restassured.RestAssured.given;

public class TfWebApiCalls {
    Response responseObj;
//    @Test
//    public void schemaid(){
//        RestAssured.baseURI= "http://ingress-gateway.gaiansolutions.com/";
//        String response=given().log().all().
//                header("Content-Type","application/json")
//                .body(payload.SchemaCreation()).when().post("tf-web/v1.0/64199047a1e33a000160b017/schemas")
//                .then().assertThat().statusCode(201).
//                extract().response().asString();
//
//        System.out.println(response);
//        //response keys retriving process
//        JsonPath js=new JsonPath(response); //for parsing Json
//        String schemaId=js.getString("schemaId");
//        System.out.println(schemaId);
//    }
    @Test
    public void email(){
        RestAssured.baseURI= "http://ingress-gateway.gaiansolutions.com/";
        String response=given().log().all().
                header("Content-Type","application/json")
                .body(payload.email("one@gatestautomation.com")).when().post("/iam-service/v1.0/tenants/signup")
                .then().assertThat().statusCode(200).
                extract().response().asString();

        System.out.println(response);
        JsonPath js=new JsonPath(response); //for parsing Json
        String msg=js.getString("msg");
        System.out.println(msg);

    }
    @Test
    public void otp(){
        RestAssured.baseURI= "http://ingress-gateway.gaiansolutions.com/";
        String response=given().log().all().
                header("Content-Type","application/json")
                .body(payload.otp("one@gatestautomation.com",100000)).when().post("/iam-service/v1.0/tenants/otp-verification")
                .then().assertThat().statusCode(200).
                extract().response().asString();

        System.out.println(response);
        JsonPath js=new JsonPath(response); //for parsing Json
        String TenantId=js.getString("tenantId");
        System.out.println(TenantId);
    }

//   @Test
//    public void TenantId(){
//       RestAssured.baseURI= "http://ingress-gateway.gaiansolutions.com/";
//       String response=given().log().all().
//               header("Content-Type","application/x-www-form-urlencoded")
//               .body(payload.otp("oneplus@gatestautomation.com",100000)).when().post("/iam-service/v1.0/tenants/otp-verification")
//               .then().assertThat().statusCode(200).
//               extract().response().asString();
//
//       System.out.println(response);
//       JsonPath js=new JsonPath(response); //for parsing Json
//       String AccessToken=js.getString("access_token");
//       System.out.println(AccessToken);
//
//   }
   @Test
    public void TokenGeneration(){
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
       //accessToke is stored in accessToken variable,we call the variable if we want to print the accessToken
       String accessToken=js1.getString("access_token");
       System.out.println(accessToken);
    }
}