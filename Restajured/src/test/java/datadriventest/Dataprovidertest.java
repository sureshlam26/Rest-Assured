package datadriventest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Dataprovidertest {
	@Test(dataProvider="empdataprovider")
	public void CreateEmploydetails(String ename,String esalary,String eage)
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequest=RestAssured.given();
		//createjsonobject
		JSONObject requestParams=new JSONObject();
		requestParams.put("Name","ename");
		requestParams.put("salary","esalary");
		requestParams.put("age","eage");
		//requestParams.put("Dept","edept");
		//Add header stating  the request body is json
		httprequest.header("Content-Type","application/json");
		//Add the json to the body request
		httprequest.body(requestParams.toJSONString());
		//POST Request
		Response response=httprequest.request(Method.POST,"/create");
		// capture response body to perform validations
		String responsebody=response.getBody().asString();
		System.out.println("responsebody is:"+responsebody);
		AssertJUnit.assertEquals(responsebody.contains("ename"),true);
		AssertJUnit.assertEquals(responsebody.contains("esalary"),true);
		AssertJUnit.assertEquals(responsebody.contains("eage"),true);
		//Assert.assertEquals(responsebody.contains("edept"),true);
		int statuscode=response.getStatusCode();
		System.out.println("Status code is:"+statuscode);
		AssertJUnit.assertEquals(statuscode, 200);
		
		
	}
	
	@DataProvider(name="empdataprovider")
	public String [][] Getdata()
	{
		
		
		String data[][]= {{"abcd06","50000","33"},{"XYZS5","40000","39"},{"ABCD6","90000","30"}};
		return data;
	}
	
	
	/*@DataProvider
	public Object[][] getempdata()
	{
		Object[][] data=new Object[3][3];
		//0th row
		data[0][0]="xyz13";
		data[0][1]="59888";
		data[0][2]="27";
		//1st row
		data[1][0]="test12";
		data[1][1]="80050";
		data[1][2]= "25";
		
		data[2][0]="sample12";
		data[2][1]="78000";
		data[2][2]= "26";
		
		return data;
	}
	*/


}
