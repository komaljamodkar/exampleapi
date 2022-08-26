package pojoclassforSerializeSet;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

//set values in payload
public class TestCaseSetValues {

	public static void main(String[] args) throws IOException {
		
		AddPlace p =new AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName("Frontline house");
		List<String> myList =new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		p.setTypes(myList);
		Location l =new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);

		p.setLocation(l);		
		RestAssured.baseURI="https://rahulshettyacademy.com";

		String resp=given().log().all().queryParams("key","qaclick123").headers("Content-Type", "application/json")
		.body(p)
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(resp);
	}

}
