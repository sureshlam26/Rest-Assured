package RestAPI;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAndPost {

	@Test
	public void data()
	{
		baseURI="https://reqres.in/api/";
		given().get("/users?page=2").
		then().statusCode(200).
		body("data[4].first_name",equalTo("George")).body("data.first_name", hasItems("George","Rachel"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void TestPost()
	{
		Map<String, Object> map=new HashMap<String,Object>();
//		map.put("Name", "suresh");
//		map.put("Job", "Testing");
//		System.out.println(map);
		
		baseURI="https://reqres.in/api/";
		JSONObject request=new JSONObject();
		request.put("Name", "suresh1");
		request.put("Job", "Testing1");
		System.out.println(request.toJSONString());
		given().body(request.toJSONString()).header("Content-Type","application/json").
		contentType(ContentType.JSON)
		.accept(ContentType.JSON).
		when().post("/users").
		then().statusCode(201).log().all();
		
	}
}
