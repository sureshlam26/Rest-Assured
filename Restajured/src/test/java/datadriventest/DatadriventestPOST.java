package datadriventest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DatadriventestPOST {
	
	@Test
	public void CreateEmploydetails()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequest=RestAssured.given();
		//createjsonobject
		JSONObject requestParams=new JSONObject();
		requestParams.put("Name","Ramxyz1");
		requestParams.put("salary","70000");
		requestParams.put("age","27");
		requestParams.put("Dept","Testing");
		//Add header stating  the request body is json
		httprequest.header("Content-Type","application/json");
		//Add the json to the body request
		httprequest.body(requestParams.toJSONString());
		//POST Request
		Response response=httprequest.request(Method.POST,"/create");
		// capture response body to perform validations
		String responsebody=response.getBody().asString();
		Assert.assertEquals(responsebody.contains("Ramxyz1"),true);
		Assert.assertEquals(responsebody.contains("70000"),true);
		Assert.assertEquals(responsebody.contains("27"),true);
		Assert.assertEquals(responsebody.contains("Testing"),true);
		int statuscode=response.getStatusCode();
		System.out.println("Status code is:"+statuscode);
		Assert.assertEquals(statuscode, 200);
		
		
	}

}
