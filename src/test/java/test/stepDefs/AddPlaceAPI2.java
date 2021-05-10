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
import static io.restassured.RestAssured.given;

public class AddPlaceAPI2 {
	RequestSpecification request;
	Response response;
	@Given("User prepares the payload")
	public void user_prepares_the_payload() {
	    // Write code here that turns the phrase above into concrete actions
	    RestAssured.baseURI="https://rahulshettyacademy.com";
	    
	    POJO_AddPlace p =new POJO_AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName("Frontline house");
		List<String> myList =new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		p.setTypes(myList);
		POJO_Location l =new POJO_Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);

		p.setLocation(l);
		
		request=given().queryParam("key", "qaclick123").body(p);
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
