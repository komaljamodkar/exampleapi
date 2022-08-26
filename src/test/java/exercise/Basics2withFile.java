package exercise;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Basics2withFile {

	public static void main(String[] args) throws IOException {
		String filepath=".//resources//payload.json";
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
	String str=	new String(Files.readAllBytes(Paths.get(filepath)));
	str=str.replace("50", "200");
		
		
//		given().log().all().queryParams("key","qaclick123").headers("Content-Type", "application/json")
//		.body(file).when().post("maps/api/place/add/json")
//		.then().log().all().assertThat().statusCode(200);
		
		
		given().log().all().queryParams("key","qaclick123").headers("Content-Type", "application/json")
		.body(str).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);

	}

}
