package org.basicApiTestingCode;

import io.restassured.RestAssured;

public class TfWeb {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://ingress-gateway.gaiansolutions.com";

    }
}
