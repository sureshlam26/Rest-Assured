package localdatajsonserver;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.response.Response;

public class JsonSchemaValidator {

	@Test
	public void data()
	{
		baseURI="https://reqres.in/api/";
		given().get("/users?page=2").
		then().assertThat().body(matchesJsonSchemaInClasspath("schema.json")).statusCode(200);
	}

	
	}

