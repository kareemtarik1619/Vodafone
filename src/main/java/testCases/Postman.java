package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Postman {

	@Test
	public void GetAllPosts() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET);
		String responseBody = response.getBody().asString();
		int responseCode = response.getStatusCode();
		System.out.println("Response Body is =>  " + responseBody);
		System.out.println("Response Code is =>  " + responseCode);
		Assert.assertEquals(responseCode, 200, "Correct status code returned");
		Assert.assertEquals(responseBody.contains("in quibusdam tempore odit est dolorem"), true,
				"Response body is valid");

	}

	@Test
	public void GetPostsById() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/1");
		String responseBody = response.getBody().asString();
		int responseCode = response.getStatusCode();
		System.out.println("Response Body is =>  " + responseBody);
		System.out.println("Response Code is =>  " + responseCode);
		Assert.assertEquals(responseCode, 200, "Correct status code returned");
		Assert.assertEquals(
				responseBody.contains("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"),
				true, "Response body is valid");

	}

}
