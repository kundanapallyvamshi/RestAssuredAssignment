import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestTesting {
	
	@Test
	public void test_post_register() {
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		JSONObject requestParam = new JSONObject();
		requestParam.put("email", "abcd@gmail.com");
		requestParam.put("password", "hello@1");
		request.body(requestParam.toJSONString()).log().all();
		Response response = request.put("api/register");
		assertEquals(response.statusCode(),200);
		System.out.println("#####################################");
		System.out.println(request.put("api/register").getStatusLine());
		System.out.println("#####################################");


	}
	@Test
	public void test_post_login() {
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		JSONObject requestParam = new JSONObject();
		requestParam.put("email", "abcd@gmail.com");
		requestParam.put("password", "hello@1");
		request.body(requestParam.toJSONString()).log().all();
		Response response = request.put("api/login");
		System.out.println(response.asString());
		assertEquals(response.statusCode(),200);

	}
	
	@Test
	public void test_get_usersList() {
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getBody());
		System.out.println(response.getContentType());
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		System.out.println(response.getStatusLine());
		Assert.assertEquals(statusCode, 200);

	}

	@Test
	public void test_get_02() {
		System.out.println("----------------------------------------");
		given().get("https://reqres.in/api/users?page=1").then().statusCode(200).log().all();
	}
	

	@Test
	public void test_get_03() {
		System.out.println("-----------------------------------------");
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.last_name",
				hasItems("Funke"));
	}

	@Test
	public void test_post_create() {
		System.out.println("-----------------------------------------");

		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		JSONObject requestParam = new JSONObject();
		requestParam.put("name", "Ram2");
		requestParam.put("job", "QA");
		request.body(requestParam.toJSONString()).log().all();
		Response response = request.post("api/users");
		assertEquals(response.statusCode(),201);

	}
	
	@Test
	public void test_delete_01() {
		System.out.println("-----------------------------------------");

		when()
  		.delete("https://reqres.in/api/users/2")
  			.then()
  				.assertThat()
  					.statusCode(204).log().all();
	}

	@Test
	public void test_put_update() {
		System.out.println("-----------------------------------------");

		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		JSONObject requestParam = new JSONObject();
		requestParam.put("name", "Vamshi");
		requestParam.put("job", "SDET");
		request.body(requestParam.toJSONString()).log().all();
		Response response = request.put("api/users/2");
		assertEquals(response.statusCode(),200);


	}
	
	@Test
	public void test_post_01() {
		RestAssured.baseURI="https://reqres.in/api/userspage=2";
        
		  RequestSpecification httpRequest=RestAssured.given();
		  JSONObject requestParams=new JSONObject();
		                  
		 requestParams.put("id",13);
		 requestParams.put("email","Vamshi.k@reqres.in");
		 requestParams.put("first_name","Vamshi");
		 requestParams.put("last_name","K");        
		 requestParams.put("avatar","https://reqres.in/img/faces/7-image.jpg");
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());                       
		 Response response=httpRequest.request(Method.POST);
		                  
		  String responseBody=response.getBody().asString();
		 System.out.println("Response Body is:"+responseBody);
		 int statusCode=response.getStatusCode();
		  System.out.println("Status code is: "+statusCode);
		 Assert.assertEquals(statusCode, 201);    
	}
	
	
	@Test
	public void test_get_01() {
		RestAssured.baseURI="https://reqres.in/api/users?page=1";
				    RequestSpecification httpRequest=RestAssured.given();
				 Response response=httpRequest.request(Method.GET);
				                  
				  String responseBody=response.getBody().asString();
				   System.out.println("Response Body is:" +responseBody);
				int statusCode=response.getStatusCode();

				 System.out.println("Status code is: "+statusCode);
				   Assert.assertEquals(statusCode, 200);
				  String statusLine=response.getStatusLine();
				  System.out.println("Status line is:"+statusLine);
				  Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
				  
					System.out.println("-----------------------------------------");
					given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.last_name",
							hasItems("Lawson"));


	}
	
	@Test
	public void test_patch_01() {
		System.out.println("-----------------------------------------");

		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		JSONObject requestParam = new JSONObject();
		requestParam.put("name", "Vamshi");
		requestParam.put("job", "SDET");
		request.body(requestParam.toJSONString()).log().all();
		Response response = request.put("api/users/2");
		assertEquals(response.statusCode(),200);

		
	}
}
