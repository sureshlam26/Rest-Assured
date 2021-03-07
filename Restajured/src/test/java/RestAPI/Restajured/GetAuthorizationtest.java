package RestAPI.Restajured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetAuthorizationtest {
	
	@Test
	public void GetAuthorization()
	{
	// Spesify base URL
			RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
			
			//Basic Authentication
			PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme();
			authscheme.setUserName("ToolsQA");
			authscheme.setPassword("TestPassword");
			RestAssured.authentication=authscheme;
			
			//Request Object
			RequestSpecification httprequest=RestAssured.given();
			
			//Response Object
			Response response=httprequest.request(Method.GET,"/");
			
			//Status code validation
			int statuscode=response.getStatusCode();
			System.out.println("status code is"+statuscode);
			Assert.assertEquals(statuscode, 200);
			//Status line verification
			String statusline=response.getStatusLine();
			System.out.println(statusline);
			Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}
}
