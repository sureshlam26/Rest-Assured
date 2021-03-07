package datadriventest;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class XLUtils {

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
			String Path=System.getProperty("user.dir")+"/src/test/java/datadriventest/Empdetails.xlsx";
			int rownum = XLUtils.getRowCount(Path, "Sheet1");
		    int colcount=XLUtils.getCellCount(Path, "Sheet1",1 );
		    
			
			//String data[][]= {{"abcd05","50000","33"},{"XYZS15","40000","39"},{"ABCD16","90000","30"}};
			String empdata[][]=new String[rownum][colcount];
			for(int i=1;i<=rownum;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					empdata[i-1][j]=XLUtils.getCellData(Path,"Sheet1",i,j);
				}
			}
		    	    
		    return empdata;
		}

		public static int getCellCount(String path, String string, int i) {
			// TODO Auto-generated method stub
			return 0;
		}

		public static int getRowCount(String path, String string) {
			// TODO Auto-generated method stub
			return 0;
		}

		public static String getCellData(String path, String string, int i, int j) {
			// TODO Auto-generated method stub
			return null;
		}
	

	

	
}
