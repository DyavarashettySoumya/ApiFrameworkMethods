package contactDemo;

import ContactPojo.AddContact;
import ContactPojo.AddContactResponse;
import ContactPojo.Employer;
import ContactPojo.Location;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class ContactApiTest {
    public static void main(String[] args) {
        RequestSpecification req = new RequestSpecBuilder().setBaseUri("http://3.13.86.142:3000/contacts")
                .setContentType(ContentType.JSON).build();


        AddContact addContact = new AddContact();
        addContact.setFirstName("Jon");
        addContact.setLastName("Smith");
        addContact.setEmail("JamesSmith@gatestautomation.com");

        //nested json list
        //creating an object for nested calss and setting the data
        Location l =new Location();
        l.setCity("NewYork");
        l.setCountry("USA");
        //after that set the data for main class also
        addContact.setLocation(l);

        Employer e = new Employer();
        e.setCompany("Infosys");
        e.setJobTitle("BA");
        addContact.setEmployer(e);


        //retriving the id from response body
        RequestSpecification reqCon =given().log().all().spec(req).body(addContact);
        AddContactResponse addContactResponse=reqCon.when().post().
                then().extract().response().as(AddContactResponse.class);
        System.out.println(addContactResponse.get_id());
        String id = addContactResponse.get_id();
        System.out.println(id);
       // System.out.println(addContactResponse.getEmail());
        //get contact
        RequestSpecification getCon=new RequestSpecBuilder().setBaseUri("http://3.13.86.142:3000/contacts")
                .setContentType(ContentType.JSON).build();
        RequestSpecification getDetails =  given().log().all().spec(getCon).pathParam("_id",id);
        String getDetailsResponse=getDetails.when().get("/{_id}")
                .then().log().all().extract().response().asString();
        JsonPath js=new JsonPath(getDetailsResponse);
        String _id = js.get("_id");

        //update contact
        //Delete Contact
        RequestSpecification delCon= new RequestSpecBuilder().setBaseUri("http://3.13.86.142:3000/contacts")
                .setContentType(ContentType.JSON).build();
        RequestSpecification deleteCon = given().log().all().spec(delCon).pathParam("_id",id);
        String deleteDetailsResponse=deleteCon.when().get("/{_id}")
                .then().log().all().extract().response().asString();
        System.out.println(deleteDetailsResponse);
       // JsonPath js1=new JsonPath(deleteDetailsResponse);
//        Assert.assertEquals("Not Found",js1.get("Not Found"));

        //get contact details
        RequestSpecification getConList=new RequestSpecBuilder().setBaseUri("http://3.13.86.142:3000/contacts")
                .setContentType(ContentType.JSON).build();
        RequestSpecification getContactList =  given().log().all().spec(getConList);
        String getContactListDetails=getContactList.when().get()
                .then().log().all().extract().response().asString();
        JsonPath js2=new JsonPath(getContactListDetails);
        System.out.println(js2);





        //Delete contact details
//        RequestSpecification delContact=new RequestSpecBuilder().setBaseUri("http://3.13.86.142:3000/contacts")
//                .setContentType(ContentType.JSON).build();
//        RequestSpecification delContactlist=given().log().all().spec(delContact).pathParam("_id",id);
//        String deleteContactResponse=delContactlist.when().delete()
//                .then().log().all().extract().response().asString();
//
//        JsonPath js3=new JsonPath(deleteContactResponse);
//        Assert.assertEquals("Not Found",js3.get("Contact details deleted successfully"));

    }
}
