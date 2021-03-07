package RestAPI.Restajured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class HeadersvalidationwithForloop {

	@Test
	public void Getheadersdetails()
	{
		// Spesify base URL
		RestAssured.baseURI="https://reqres.in/api/users";
		//Request Object
		RequestSpecification httprequest=RestAssured.given();
		//Response Object
		Response response=httprequest.request(Method.GET,"/2");
		//Print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response body is"+responseBody);
		//Status code validation
		int statuscode=response.getStatusCode();
		System.out.println("status code is"+statuscode);
		Assert.assertEquals(statuscode, 200);
		//Status line verification
		String statusline=response.getStatusLine();
		System.out.println(statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		//Validate Headers details
		Headers allheaders= response.headers();
		for(Header header:allheaders)
		{
			System.out.println(header.getName()+"  "+header.getValue());
		}
}
	
}
