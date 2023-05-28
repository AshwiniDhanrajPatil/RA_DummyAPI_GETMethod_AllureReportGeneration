package SimilarFunctionPackage;
import io.restassured.response.Response;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;

public class API_Common_Function {
@BeforeTest
public static int statusCode(String baseURI,String resource)
{
RestAssured.baseURI=baseURI;
int statusCode=given().header("Content-Type","application/json").when().get(resource).then().extract().statusCode();
return statusCode;
}
public static String resource (String baseURI,String resource)
{
RestAssured.baseURI=baseURI;
String responseBody=given().header("Content-Type","application/json").when().get(resource).then().extract().response().asString();
return responseBody;
}

}