package test.stepDefs;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojoClass.POJO_AddPlace;
import pojoClass.POJO_Location;
import resources.TestDataBuild;

import static io.restassured.RestAssured.given;

public class AddPlaceAPI2 {
	RequestSpecification request;
	Response response;
	@Given("User prepares the payload")
	public void user_prepares_the_payload() {
	    // Write code here that turns the phrase above into concrete actions
	    RestAssured.baseURI="https://rahulshettyacademy.com";
	    
	    TestDataBuild payload=new TestDataBuild();
		
		request=given().queryParam("key", "qaclick123").body(payload.addPlacePayload());
	}

	@When("User POST request")
	public void user_post_request() {
	    // Write code here that turns the phrase above into concrete actions
	    response=request.post("/maps/api/place/add/json");
	    String content_len=response.getHeader("Content-Length");
	    String strResponse=response.asString();
	    System.out.println(strResponse);
	    System.out.println(content_len);
	}

	@Then("User should be able to see statusCode as {int}")
	public void user_should_be_able_to_see_status_code_as(Integer statuscode) {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(statuscode.equals(200));
	}


}
