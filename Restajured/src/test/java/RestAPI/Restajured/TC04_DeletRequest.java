package RestAPI.Restajured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC04_DeletRequest {

	@Test
	public void deleteEmpRecord() {
	 
	 int empid = 15410;
	 
	 RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
	 RequestSpecification request = RestAssured.given(); 
	 
	 // Add a header stating the Request body is a JSON
	 request.header("Content-Type", "application/json"); 
	 
	       // Delete the request and check the response
	 Response response = request.delete("/delete/"+ empid); 
	 
	 int statusCode = response.getStatusCode();
	 System.out.println(response.asString());
	 Assert.assertEquals(statusCode, 204);
	 
	 String jsonString =response.asString();
	 Assert.assertEquals(jsonString.contains("successfully! deleted Records"), true);
	 }
}
