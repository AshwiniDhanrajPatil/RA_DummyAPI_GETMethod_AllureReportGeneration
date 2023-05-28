package requestRepo;

import org.testng.annotations.BeforeTest;

public class get_Req_Repository {
	@BeforeTest
	public static String baseURI() {
		String baseURI="https://dummyjson.com/";
		return baseURI;
	}
    public static String resource() {
    	String resource="/products";
    	return resource;
    }
}

