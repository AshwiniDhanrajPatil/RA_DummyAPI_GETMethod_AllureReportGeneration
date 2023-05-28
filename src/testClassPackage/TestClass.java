package testClassPackage;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import SimilarFunctionPackage.API_Common_Function;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import requestRepo.get_Req_Repository;

public class TestClass
{

	@Test
	public static void execute() throws IOException 
	{
		String baseURI= get_Req_Repository.baseURI();
		String resource =get_Req_Repository.resource();	
		int statusCode=API_Common_Function.statusCode(baseURI, resource);
		String responseBody=API_Common_Function.resource(baseURI, resource);
		int id[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		String title[]= {"iPhone 9","iPhone X","Samsung Universe 9","OPPOF19","Huawei P30","MacBook Pro","Samsung Galaxy Book","Microsoft Surface Laptop 4","Infinix INBOOK","HP Pavilion 15-DK1056WM","perfume Oil","Brown Perfume","Fog Scent Xpressio Perfume","Non-Alcoholic Concentrated Perfume Oil","Eau De Perfume Spray","Hyaluronic Acid Serum","Tree Oil 30ml","Oil Free Moisturizer 100ml","Skin Beauty Serum.","Freckle Treatment Cream- 15gm","- Daal Masoor 500 grams","Elbow Macaroni - 400 gm","Orange Essence Food Flavou","cereals muesli fruit nuts","Gulab Powder 50 Gram","Plant Hanger For Home","Flying Wooden Bird","3D Embellishment Art Lamp","Handcraft Chinese style","Key Holder"};
		JsonPath jsp=new JsonPath(responseBody);
		int count=jsp.getList("products").size();
		for(int i=0;i<count;i++)
		{
			int exp_id=id[i];
			String exp_title=title[i];
			int res_id=jsp.getInt("products["+i+"].id");
			String res_title=jsp.getString("products["+i+"].title");
			Assert.assertEquals(statusCode, 200);
			Assert.assertEquals(res_id, exp_id);
			Assert.assertEquals(res_title,exp_title);
			
		}
		
		System.out.println("display the get validation result:"+responseBody);
	}

}


