package RestAPI.Asna.GETRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AsnaTest {
	
	String uri = "https://app.asana.com";
	String token ="0/38d75b5504a78662a2adb04410b9b366";
    
	@Test()
	public void GetAsnaWorkSpaces() {
        RestAssured.baseURI = uri;
        
        
		
		RequestSpecification httpRequest =  RestAssured.given().header("Authorization", "Bearer "+token);
				                            
		Response response = httpRequest.request(Method.GET, "/api/1.0/workspaces/");
		
		String responseBody =response.getBody().asString(); 
		int status = response.getStatusCode();
		
//		String headers = response.headers().toString();
//		
		System.out.println("=== Request Response ===== ");
		System.out.println(responseBody);
		System.out.println("=== Request Response =====");
		System.out.println("Status Code: "+status);
//		System.out.println("=== Request Headers ====");
//		System.out.println(headers );
	}
	
	
	@Test()
	public void GetAsnaProjects() {
        RestAssured.baseURI = uri;
        
        RequestSpecification httpRequest =  RestAssured.given().header("Authorization", "Bearer "+token);
				                            
		Response response = httpRequest.request(Method.GET, "/api/1.0/projects/");
		
		String responseBody =response.getBody().asString(); 
		int status = response.getStatusCode();
		
//		String headers = response.headers().toString();
//		
		System.out.println("=== Request Response ===== ");
		System.out.println(responseBody);
		System.out.println("=== Request Response =====");
		System.out.println("Status Code: "+status);
//		System.out.println("=== Request Headers ====");
//		System.out.println(headers );
	}
	
	
	
	
	
	
	
	
	
	
}
