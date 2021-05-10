package test.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class GitHubAPI {
	
	RequestSpecification request;
	Response response;
	
	@Given("^User sets the base API$")
	public void user_sets_the_base_api() {
	    RestAssured.baseURI="https://api.github.com";
	    
	    }

	@Given("User authenticates the API req with {string}")
	public void user_authenticates_the_api_req_with(String token) {
	    // Write code here that turns the phrase above into concrete actions
	    request=given().auth().oauth2(token);
	}

	@When("User send the API request to get all the repositories with {string}")
	public void user_send_the_api_request_to_get_all_the_repositories_with(String endpoint) {
	    // Write code here that turns the phrase above into concrete actions
	    response=request.when().get(endpoint).then().extract().response();
	    System.out.println(response);
	}

	@Then("User Validates resposeCode as {int}")
	public void user_validates_respose_code_as(int code) {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(code, response.getStatusCode());
	}

}
