package RestAPI.RestAPITesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class APIGetTest {
	
	String uri = "https://api.openweathermap.org";
	
	@Test()
	public void TestWeatherByCityName() {
		RestAssured.baseURI = uri;
		
		RequestSpecification httpRequest =  RestAssured.given();
				                            
		Response response = httpRequest.request(Method.GET, "/data/2.5/weather?q=Delhi&appid=eec65f8966686eb7c89609f36eb92cff");
		
		String responseBody =response.getBody().asString(); 
		int status = response.getStatusCode();
		String headers = response.headers().toString();
		
		System.out.println("=== Request Response ===== ");
		System.out.println(responseBody);
		System.out.println("=== Request Response =====");
		System.out.println("Status Code: "+status);
		System.out.println("=== Request Headers ====");
		System.out.println(headers );
	}
    
    @Test(dataProvider="CityNames")
    public void TestWeatherByCityAndCountry_Name(String city) {
RestAssured.baseURI = uri;
		
		RequestSpecification httpRequest =  RestAssured.given();
				                            
		Response response = httpRequest.request(Method.GET, "/data/2.5/weather?q="+city+"i&appid=eec65f8966686eb7c89609f36eb92cff");
		
		String responseBody =response.getBody().asString(); 
		int status = response.getStatusCode();
		String headers = response.headers().toString();
		System.out.println("======="+city+"========");
		System.out.println("=== Request Response ===== ");
		System.out.println(responseBody);
		System.out.println("=== Request Response =====");
		System.out.println("Status Code: "+status);
		System.out.println("=== Request Headers ====");
		System.out.println(headers );
		System.out.println("=========================");
    }

    
    @DataProvider(name="CityNames")
    public Object [][] cityNameProvider(){
    	String[][] cities= { 
    			             {"London"},
    			             {"Delhi"}
    			           };
    	return cities;
    }

}
