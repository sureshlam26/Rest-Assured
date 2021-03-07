package RestAPI;

import org.testng.annotations.Test;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.ResponseOptions;
import junit.framework.Assert;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Getdata {
	@Test
	public void GetTest()
	{
		//ResponseOptions response=RestAssured.get("http://demoqa.com/utilities/weather/city/Hyderabad");
		ResponseOptions response=get("https://reqres.in/api/users?page=2");
		//System.out.println(response.getStatusCode());
		int statuscode=response.getStatusCode();
		System.out.println("status code is"+statuscode);
		Assert.assertEquals(statuscode, 200);
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody());
		System.out.println(response.getContentType());
		System.out.println(response.getHeaders());
	}
	
	@Test
	public void Test2()
	{
		baseURI="https://reqres.in/api/";
		given().get("/users?page=2").then().statusCode(200).body("data[1].id",equalTo(8)).
		log().all();
		//body("x.books[1].isbn", equalTo[]);
	}

}
