package RestAPI.Restajured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class POST_Register {
	//Registration
	@Test
	public void RegistrationSuccessfull()
	{
		// Spesify base URL
		RestAssured.baseURI="http://demoqa.com/customer";
		//Request Object
		RequestSpecification httprequest=RestAssured.given();
		//JSONObject creation
		//Request payload sending along with post request
		JSONObject requestParams=new JSONObject();
		requestParams.put("FirstName", "Johnse");
		requestParams.put("LastName", "Joo");
		requestParams.put("UserName", "Johnse");
		requestParams.put("PassWord", "Johnse1234");
		requestParams.put("Eail", "Johnse@xyz.com");
		httprequest.header("Content-Type","application/json");
		
		httprequest.body(requestParams.toJSONString());
		
		//Response Object
		Response response=httprequest.request(Method.POST,"/register");
		//Print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response body is"+responseBody);
		//Status code validation
		int statuscode=response.getStatusCode();
		System.out.println("status code is"+statuscode);
		Assert.assertEquals(statuscode, 201);
		//Success code validation
		String successcode=response.jsonPath().get("SuccessCode");
		System.out.println(successcode);
		Assert.assertEquals(successcode, "OPERATION_SUCCESS");
		
		
		
	}


}
