package stepDefinations;

import TfPojo.Otp;
import TfPojo.otpResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefination extends Utils{
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuild data =new TestDataBuild();

    static String tenantId;
    @Given("create email payload with {string}")
    public void create_email_payload_with(String email) throws IOException {
        res=given().spec(requestSpecification())
                .body(data.emailPayload(email));

    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
        APIResources resourceAPI=APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());

        resspec =new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
        if(method.equalsIgnoreCase("POST"))
            response =res.when().post(resourceAPI.getResource());
        else if(method.equalsIgnoreCase("GET"))
            response =res.when().get(resourceAPI.getResource());

    }

    @Then("the API call got success with status code {int}")
    public void the_API_call_got_success_with_status_code(Integer int1) {

        assertEquals(response.getStatusCode(),200);
    }

    @Then("Then {string} in response body {string}")
    public void then_in_response_body(String keyValue, String Expectedvalue) {
        assertEquals(getJsonPath(response,keyValue),Expectedvalue);
        JsonPath js = response.jsonPath();
        if(response.statusCode()==200) {
            String Message = js.get("msg");
            System.out.println("Message:" + Message);
        }else {
            System.out.println("Fail");
        }
    }

//    @Then("create otp payload with {string} and {string}")
//    public void create_otp_payload_with_and(String email, int otp) throws IOException {
//      res=given().spec(requestSpecification())
//              .body((data.otpPayload(email,otp)));
//    }

    @Given("create otp payload with {string} and {int}")
    public void create_otp_payload_with_and(String email, int otp) throws IOException {
        res=given().spec(requestSpecification())
                .body((data.otpPayload(email,otp)));
    }
    @Then("User calls {string} with {string} http request")
    public void userCallsWithHttpRequest(String resource, String method) {
        APIResources resourceAPI=APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());

        resspec =new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
        if(method.equalsIgnoreCase("POST"))
            response =res.when().post(resourceAPI.getResource());
        else if(method.equalsIgnoreCase("GET"))
            response =res.when().get(resourceAPI.getResource());
    }
    @Then("{string} in response body {string}")
    public void in_response_body(String resource, String method) {
        APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());

        resspec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
        if (method.equalsIgnoreCase("POST"))
            response = res.when().post(resourceAPI.getResource());
        else if (method.equalsIgnoreCase("GET"))
            response = res.when().get(resourceAPI.getResource());
    }


    @And("verify tenantId create using {string}")
    public void verifyTenantIdCreateUsing(String resource) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());
        resspec = new ResponseSpecBuilder().expectStatusCode(200)
                .build();
        //retrive the tenantId from otp response body
//        RequestSpecification reqCon =given().log().all().spec(req);
//        otpResponse Response=res.when().post().
//                then().extract().response().as(otpResponse.class);
//        System.out.println(Response.getId());
//        String id = Response.getId();
//        System.out.println(id);
        JsonPath js = response.jsonPath();
        if(response.statusCode()==200) {
            String tenantId = js.get("tenantId");
            System.out.println("TenantId :" + tenantId);
        }else {
            String status = js.get("status");
            System.out.println("Status:" + status);
        }
//       int responseCode= response.getStatusCode();
//        System.out.println("Response Code:"+responseCode);
//        getJsonPath(response,tenantId);
//        System.out.println("tenantId :" +tenantId);


    }

}
