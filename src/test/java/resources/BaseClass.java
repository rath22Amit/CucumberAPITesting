package resources;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	public RequestSpecification request;
	public Response response;
	public String content_len;
    public String strResponse;

}
