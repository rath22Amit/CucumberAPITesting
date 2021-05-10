package test;
import org.junit.Assert;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class BitcoinAPI {

	@Test
	public void verifyStatusCode200() {
		given().when().get("https://api.coindesk.com/v1/bpi/currentprice.json").then().statusCode(200);
	}
	
	@Test
	public void getStatusCode() {
		int statusCode=given().when().get("https://api.coindesk.com/v1/bpi/currentprice.json").getStatusCode();
		System.out.println("statusCode is" +statusCode);
		Assert.assertTrue(statusCode==200);
	}
	
	@Test
	public void getResponseBody() {
		given().when().get("https://api.coindesk.com/v1/bpi/currentprice.json").then().log().body();
		
	}

}
