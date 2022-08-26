package exercise;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloadclassfile.Payloadstring;
import payloadclassfile.Reusablemethods;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import org.testng.Assert;

public class Basics2withJsonMapAPI2 {

	public static void main(String[] args) throws IOException {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		//location have internal 2 param
		
	HashMap<String,Object>hm=new HashMap<>();
	hm.put("name","abcde");
	hm.put("isbn","bbd");
	hm.put("aisle","277");
	hm.put("author","John foe");
	
	HashMap<String,Object>hm2=new HashMap<>();
	hm2.put("lat","22");
	hm2.put("lng","45");
	hm.put("location", hm2);
	
	
		
	String resp=given().log().all().headers("Content-Type", "application/json")
			.body(hm).when().post("Library/Addbook.php")
			.then().log().all().assertThat().statusCode(200).extract().response().asString();

	
	System.out.println(resp);	


	}

}
