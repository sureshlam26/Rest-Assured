package RestAPI;

import static io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDelete {

	@Test(priority=2)
	public void TestPut()
	{
	
		
		baseURI="https://reqres.in/api/";
		JSONObject request=new JSONObject();
		request.put("Name", "suresh2");
		request.put("Job", "Testing2");
		System.out.println(request.toJSONString());
		given().body(request.toJSONString()).header("Content-Type","application/json").
		contentType(ContentType.JSON)
		.accept(ContentType.JSON).
		when().put("/users/2").
		then().statusCode(200).statusLine("HTTP/1.1 200 OK").log().all();
		
	}
	
	@Test(priority=1)
	public void TestPatch()
	{
	
		baseURI="https://reqres.in/api/";
		JSONObject request=new JSONObject();
		request.put("Name", "suresh2");
		request.put("Job", "Dev");
		System.out.println(request.toJSONString());
		given().body(request.toJSONString()).header("Content-Type","application/json").
		contentType(ContentType.JSON)
		.accept(ContentType.JSON).
		when().patch("/users/2").
		then().statusCode(200).log().all();
		
	}
	
	@Test(priority=3)
	public void TestDelete()
	{
	
		
		baseURI="https://reqres.in/api/";
		
		when().delete("/users/2").
		then().statusCode(204).log().all();
		
	}
}

