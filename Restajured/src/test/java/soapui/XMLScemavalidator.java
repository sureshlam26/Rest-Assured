package soapui;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;

public class XMLScemavalidator {
	
	@Test(priority=1)
	public void xmlScemavalidator () throws IOException
	{
		
		File fis=new File(".\\SoapRequests\\Multiplyrequests.xml");
		if(fis.exists())
		{
			System.out.println("File is exist");
		}
		else
		{
			System.out.println("File does not exists");
		}
		FileInputStream file=new FileInputStream(fis);
		String RequestBody=IOUtils.toString(file, "UTF-8");
		RestAssured.baseURI="http://www.dneonline.com/";
		RestAssured.given().contentType("text/xml").accept("xml").
		body(RequestBody).when().post("/calculator.asmx").
		then().statusCode(200).log().all().and().body("//*:MultiplyResult.text()", equalTo("315")).
		and().assertThat().
		body(matchesXsdInClasspath("\\CalculatorMultiply.xsd"));
	    
	}

}
