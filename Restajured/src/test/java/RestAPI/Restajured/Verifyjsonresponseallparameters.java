package RestAPI.Restajured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Verifyjsonresponseallparameters {

	@Test
	public void Getheadersdetails()
	{
		// Spesify base URL
		RestAssured.baseURI="http://demoqa.com/utilities/weather/city";
		//Request Object
		RequestSpecification httprequest=RestAssured.given();
		//Response Object
		Response response=httprequest.request(Method.GET,"/Hyderabad");
	    JsonPath jsonpath=response.jsonPath();
	  System.out.println(jsonpath.get("City"));
	  System.out.println(jsonpath.get("Temperature"));
	  System.out.println(jsonpath.get("Humidity"));
	  System.out.println(jsonpath.get("WeatherDescription"));
	  System.out.println(jsonpath.get("WindSpeed"));
	  System.out.println(jsonpath.get("WindDirectiondegree"));
	  Assert.assertEquals(jsonpath.get("City"), "Hyderabad");
			
}
}
