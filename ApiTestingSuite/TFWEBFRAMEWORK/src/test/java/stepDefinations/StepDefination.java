package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import static org.junit.Assert.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data =new TestDataBuild();

	static String _id;
	

	@Given("Add Place Payload with {string},{string},{string}")
	public void addPlacePayloadWith(String firstName, String lastName, String email) throws IOException {
		res=given().spec(requestSpecification())
				.body(data.addContactPayLoad(firstName,lastName,email));
	}

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
//constructor will be called with value of resource which you pass
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
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
	  
	 assertEquals(getJsonPath(response,keyValue),Expectedvalue);
	}
	@Then("verify contact_Id created maps to {string} using {string}")
	public void verify_contact_Id_created_maps_to_using(String resource) throws IOException {
	
	   // requestSpec
	     _id=getJsonPath(response,"_id");
		 res=given().spec(requestSpecification()).queryParam("_id",_id);
		 user_calls_with_http_request(resource,"GET");
		  String contactId=getJsonPath(response,"_id");
		System.out.println(contactId);
}

	@Given("create email payload with {string}")
	public void createEmailPayloadWith(String email) throws IOException {
		res=given().spec(requestSpecification())
				.body(data.emailPayload(email));
	}

	@Then("{string} in response body {string}")
	public void inResponseBody(String keyValue, String Expectedvalue) {
		assertEquals(getJsonPath(response,keyValue),Expectedvalue);
	}

	@And("otp payload with {string} and {string}")
	public void otpPayloadWithAnd(String email, int otp) throws IOException {
		res=given().spec(requestSpecification())
				.body((Object) data.emailPayload(email), (ObjectMapper) data.otpPayload(otp));
	}


@Given("DeletePlace Payload")
public void deleteplace_Payload() throws IOException {
    // Write code here that turns the phrase above into concrete actions

	res =given().spec(requestSpecification()).queryParam("_id",_id);
//			.body(data.deleteContactPayload(_id));
}
}
