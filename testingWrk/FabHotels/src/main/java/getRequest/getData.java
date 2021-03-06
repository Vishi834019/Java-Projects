package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getData 
{
   public void TestResponseCode()
   {
	   
	  Response resp = RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	  
	  int code =  resp.getStatusCode();
	  System.out.println("Status code is "+code);
	  
	  Assert.assertEquals(code, 200);
   }
   
   @Test
   public void Testbody()
   {
	   
		  Response resp = RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		  
		 String data = resp.asString();
		 System.out.println("Data is "+data);
		 System.out.println("Response time "+resp.getTime());
		 Assert.assertTrue(data.contains("London"));
	   
   }
}
