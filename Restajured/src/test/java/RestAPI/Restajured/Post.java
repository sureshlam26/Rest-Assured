package RestAPI.Restajured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Post {

	//Registration
		@Test
		public void RegistrationSuccessfull()
		{
			// Spesify base URL
			RestAssured.baseURI="https://reqres.in/api/login";
			//Request Object
			RequestSpecification httprequest=RestAssured.given();
			//JSONObject creation
			//Request payload sending along with post request
			JSONObject requestParams=new JSONObject();
			requestParams.put("email", "eve.holt@reqres.in");
			requestParams.put("password", "cityslicka");
			
			httprequest.header("Content-Type","application/json");
			
			httprequest.body(requestParams.toJSONString());
			
			//Response Object
			Response response=httprequest.request(Method.POST,"/login");
			//Print response in console window
			String responseBody=response.getBody().asString();
			System.out.println("Response body is"+responseBody);
			//Status code validation
			int statuscode=response.getStatusCode();
			System.out.println("status code is"+statuscode);
			Assert.assertEquals(statuscode, 201);
			//Success code validation
		String	token=response.getBody().print();
		System.out.println(token);
		
			/*int token=response.jsonPath().get("token");
			System.out.println(token);
			Assert.assertEquals(token, "QpwL5tke4Pnpja7X4");*/
			
			
			
		}
}
