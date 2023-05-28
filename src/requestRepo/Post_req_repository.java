package requestRepositoryPackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeTest;

import commonFunctionPackage.Utility_Common_Functions;

public class Post_req_repository {
	@BeforeTest
	public static String base_URI()
	{
		String baseURI="https://reqres.in/";
		return baseURI;
		
	}

public static String post_resource()
{
	String resource="/api/users";
	return resource;
}
	
public static String post_req_tc1() throws IOException 
{
	ArrayList<String> data=Utility_Common_Functions.readDataExcel("Post_Test_Data","Post_TC_1");//"post_data","Post_TC_1"
	String requestBody="{\r\n"
			+ "    \"name\": \"morpheus\",\r\n"
			+ "    \"job\": \"leader\"\r\n"
			+ "}";
	return requestBody;
}
public static String post_req_tc2() throws IOException 
{
	ArrayList<String> data=Utility_Common_Functions.readDataExcel("Post_Test_Data","Post_TC_2");//"post_data","Post_TC_2"
	String requestBody="{\r\n"
			+ "    \"name\": \"amadeus\",\r\n"
			+ "    \"job\": \"mgr\"\r\n"
			+ "}";
	return requestBody;}


public static String post_req_tc3() throws IOException
{
	ArrayList<String> data=Utility_Common_Functions.readDataExcel("Post_Test_Data","Post_TC_3");//"post_data","Post_TC_1"
	String requestBody="{\r\n"
			+ "    \"name\": \"Ashwini\",\r\n"
			+ "    \"job\": \"qa\"\r\n"
			+ "}";
	return requestBody;

}
public static String post_req_tc4() throws IOException {
	ArrayList<String> data=Utility_Common_Functions.readDataExcel("Post_Test_Data","Post_TC_4");//"post_data","Post_TC_1"
	String requestBody="{\r\n"
			+ "    \"name\": \"Dhanaraj\",\r\n"
			+ "    \"job\": \"dev\"\r\n"
			+ "}";
	return requestBody;
}


}
