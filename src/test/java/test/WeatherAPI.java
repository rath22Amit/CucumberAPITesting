package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import java.util.Map;




public class WeatherAPI {
	
	String key="2a24da980a49b1a48e19b5eb9011266b";
	ValidatableResponse val;
	
	@Test
	public void temp_City() {
		RestAssured.baseURI="http://api.openweathermap.org/data/2.5/weather";
		RequestSpecification httpRequest=RestAssured.given().queryParam("q", "hyderabad").queryParam("appid",key);
		
		Response res=httpRequest.get();
		
		ResponseBody body=res.getBody();
		
		String bodyasString=body.asString();
		System.out.println(bodyasString);
		
	}
	
	@Test
	public void validateCountry() {
		RestAssured.baseURI="http://api.openweathermap.org/data/2.5/weather";
		
		RequestSpecification httpRequest=given().queryParam("q", "bokaro").queryParam("appid", key);
		Response res= httpRequest.get();
		String country=res.then().extract().path("sys.country");
		System.out.println("country is  "+country);
		Assert.assertTrue(country.equals("IN"));
	}
	
	@Test
	public void validateWeather() {
		RestAssured.baseURI="http://api.openweathermap.org/data/2.5/weather";
		
		RequestSpecification httpRequest=given().queryParam("q", "bokaro").queryParam("appid", key);
		Response res= httpRequest.get();
		Map weather_main=res.then().extract().path("weather[0]");
		System.out.println("weather_main is  "+weather_main);
		//Assert.assertTrue(country.equals("IN"));
	}
	
	@Test
	public void validateHeader() {
		RestAssured.baseURI="http://api.openweathermap.org/data/2.5/weather";
		
		RequestSpecification httpRequest=given().queryParam("q", "bokaro").queryParam("appid", key);
		Response res= httpRequest.get();
		
		val=res.then().log().headers();
		String x=val.extract().path("Server");
		System.out.println(x);
		
	}
	
//	@Test
//	public void validateHeaderParameter() {
//		RestAssured.baseURI="http://api.openweathermap.org/data/2.5/weather";
//		
//		RequestSpecification httpRequest=given().queryParam("q", "bokaro").queryParam("appid", key);
//		Response res= httpRequest.get();
//		
//		val=res.then().header("", null)
//		System.out.println("The Server is "+ val);
//		
//		
//	}

}
