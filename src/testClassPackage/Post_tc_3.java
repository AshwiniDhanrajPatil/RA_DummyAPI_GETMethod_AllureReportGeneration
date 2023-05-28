package testClassPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctionPackage.API_Common_Function;
import commonFunctionPackage.Utility_Common_Functions;
import io.restassured.path.json.JsonPath;
import requestRepositoryPackage.Post_req_repository;

public class Post_tc_3 {
	@Test
	public static void execute() throws IOException 
	{
		for(int i=0;i<5;i++)
		{
			
	    int res_statuscode=API_Common_Function.response_statusCode(Post_req_repository.base_URI(),Post_req_repository.post_resource(),Post_req_repository.post_req_tc3());
	    if( res_statuscode == 201 ) 
	    {
    	String res_responseBody=API_Common_Function.responseBody(Post_req_repository.base_URI(),Post_req_repository.post_resource(),Post_req_repository.post_req_tc3());	
	    Post_tc_3.validator(res_responseBody, res_statuscode);
	    Utility_Common_Functions.evedenceFileCreator("Post_tc_3",Post_req_repository.post_req_tc3(),res_responseBody);
	    break;
	    }
	    else
	    {
	    	System.out.println("Correct status code is not found hence retrying the API");
	    }
		}
		
	}		
		
	public static void validator(String res_responseBody,int res_statuscode) throws IOException 
	{
		//parse	the response body
		JsonPath jsp=new JsonPath(res_responseBody);
		String res_name=jsp.getString("name");
		String res_job=jsp.getString("job");
	//	String res_id=jsp.getString("id");
	//	String res_createdAt=jsp.getString("createdAt");
		//System.out.println(res_name);
		System.out.println(res_name);
		System.out.println(res_job);
	//	System.out.println(res_id);
	//	System.out.println(res_createdAt);

		//request body
		JsonPath jspreq=new JsonPath(Post_req_repository.post_req_tc3());
		String req_name=jspreq.getString("name");
		String req_job=jspreq.getString("job");
				//validate response body 
		Assert.assertEquals(res_statuscode,201);
		Assert.assertEquals(res_name,req_name);
		Assert.assertEquals(res_job,req_job);
//		Assert.assertNotNull(res_id,"15");
//		Assert.assertNotNull(res_createdAt,"2023-05-05T08:28:13.425Z");

	}

}
