package RestAPI.Restajured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUT_UPDATE {

	@Test
	public void UpdateRecord(){
		 int id = 2;
		 
		 RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
		 RequestSpecification request = RestAssured.given();
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("email", "janet.weaver@reqres.in"); // Cast
		 requestParams.put("first_name", "Janet");
		 requestParams.put("last_name", "Test1");
		 requestParams.put("avatar", "https://reqres.in/img/faces/2-image.jpg");
		 		 
		 request.body(requestParams.toJSONString());
		 Response response = request.put("/update/"+ id);
		 
		 int statusCode = response.getStatusCode();
		 System.out.println("statusCode"+statusCode);
		 System.out.println(response.asString());
		 Assert.assertEquals(statusCode, 200); 
		 //Validate Headers details
		/*String contenttype= response.header("Content-Type");
		System.out.println(contenttype);
		Assert.assertEquals(contenttype, "application/json");*/
		
		/*String AcceptEncoding= response.header("Accept-Encoding");
		System.out.println(AcceptEncoding);
		Assert.assertEquals(AcceptEncoding, "deflate","br");
		 */
		//Validate Headers details
				Headers allheaders= response.headers();
				for(Header header:allheaders)
				{
					System.out.println(header.getName()+"  "+header.getValue());
				}
		 }
}
