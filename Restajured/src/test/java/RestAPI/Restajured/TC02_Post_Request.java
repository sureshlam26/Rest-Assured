package RestAPI.Restajured;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC02_Post_Request {

    @Test
	public void RegistrationSuccessful()
	{ 
	 RestAssured.baseURI ="https://restapi.demoqa.com/customer";
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams = new JSONObject();	 
	 requestParams.put("FirstName","Virender"); 
	 requestParams.put("LastName","Singh");
	 requestParams.put("UserName","sdimpleuser2dd2011");
	 requestParams.put("Password", "password1"); 
	 requestParams.put("Email","sample2ee26d9@gmail.com");
	 request.body(requestParams.toJSONString());
	 Response response = request.get("register");
	 
	int statusCode = response.getStatusCode();
	 System.out.println("The status code recieved: "+statusCode);
	 Assert.assertEquals(statusCode, 201);
	 
	 System.out.println("Response body: "+response.body().asString());
	}
}

