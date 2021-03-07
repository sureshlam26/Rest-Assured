package localdatajsonserver;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestonLocalAPI {
	
	@Test(priority=2)
	public void Getdata()
	{
		baseURI="http://localhost:3000/";
		given().get("/users?id=4").then().statusCode(200).log().all();
	}

	/*@Test(priority=2)
	public void Postdata()
	{
		baseURI="http://localhost:3000/";
		JSONObject request=new JSONObject();
		request.put("firstName", "Sandy");
		request.put("lastNameName", "Valapa");
		request.put("subjectid", "4");
		request.put("id", "4");
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().post("/users").then().statusCode(201).log().all();
	}*/
	
	/*@Test(priority=1)
	public void Put()
	{
		baseURI="http://localhost:3000/";
		JSONObject request=new JSONObject();
		request.put("firstName", "Sandy");
		request.put("lastNameName", "Lam");
		request.put("subjectid", "4");
		request.put("id", "4");
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().put("/users/4").then().statusCode(200).log().all();
		
	}*/
	
	
	/*@Test(priority=1)
	public void Patch()
	{
		baseURI="http://localhost:3000/";
		JSONObject request=new JSONObject();
		
		request.put("lastNameName", "L");
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().patch("/users/4").then().statusCode(200).log().all();
		
	}*/
	
	//@Test()
	public void Delete()
	{
		baseURI="http://localhost:3000/";
		when().delete("/users/4").then().
		statusCode(200).log().all();
	}
}

