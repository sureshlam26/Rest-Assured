package soapui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

public class SoapXMLrequest {
	/*@Test
	public void SoaprequestAdd() throws IOException
	{
		
		File fis=new File(".\\SoapRequests\\Addrequests.xml");
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
		then().statusCode(200).log().all();
	    
	}*/
	
	@Test(priority=2)
	public void Soaprequestdivide() throws IOException
	{
		
		File fis=new File(".\\SoapRequests\\Dividerequests.xml");
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
		then().statusCode(200).log().all().and().body("//*:DivideResult.text()", equalTo("41"));
	    
	}
	
	@Test(priority=1)
	public void Soaprequestmultiply() throws IOException
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
		then().statusCode(200).log().all().and().body("//*:MultiplyResult.text()", equalTo("315"));;
	    
	}
}
