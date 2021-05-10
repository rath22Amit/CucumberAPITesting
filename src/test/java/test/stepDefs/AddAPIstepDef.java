package test.stepDefs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



import static io.restassured.RestAssured.given;

public class AddAPIstepDef {
	RequestSpecification request;
	Response response;

    @Given("User sets the request using following parameter {int},{string},{string},{string},{string},{string},{double},{double}")
	public void user_sets_the_request_using_following_parameter(int accuracy, String name, String phone_number, String address, String website, String language, double lat, double lng) {
	    // Write code here that turns the phrase above into concrete actions
	    RestAssured.baseURI="https://rahulshettyacademy.com";
	    
	    Map<Object,Object> location=new HashMap<Object, Object>();
        location.put("lat",lat);
        location.put("lng",lng);

        ArrayList<Object> types=new ArrayList<Object>();
        types.add("shoe park");
        types.add("shop");

        Map<Object,Object> body=new HashMap<Object, Object>();
        body.put("accuracy",accuracy);
        body.put("name",name);
        body.put("phone_number",phone_number);
        body.put("address",address);
        body.put("website",website);
        body.put("language",language);
        body.put("location",location);
        body.put("types",types);
        
        request= given().contentType("application/json").body(body);
	    
	}

	@When("User sends the POST request with {string}")
	public void user_sends_the_post_request_with(String endpoint) {
	    // Write code here that turns the phrase above into concrete actions
	    response=request.when().post(endpoint);
	    System.out.println(response.then().log().all());
	}

	@Then("User Validates responseCode as {int}")
	public void user_validates_response_code_as(int code) {
		Assert.assertTrue(code==200);
	}

}
