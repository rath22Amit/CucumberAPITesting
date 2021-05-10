package test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GithubAPITest {
	String api_token="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";
	String url="https://api.github.com";
	
	@Test
	public void verifyRepo() {
		String endpoint=url+"/user/repos";
		int statusCode=given().auth().oauth2(api_token).get(endpoint).getStatusCode();
		System.out.println(statusCode);
	}
}
