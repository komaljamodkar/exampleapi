package exercise;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloadclassfile.Payloadstring;
import payloadclassfile.Reusablemethods;

import static io.restassured.RestAssured.*;

//import static hamcrest pkg for assertion
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class BasicsPayloadValidation2 {

	public static void main(String[] args) {
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String resp=given().log().all().queryParams("key","qaclick123").headers("Content-Type", "application/json")
		.body(Payloadstring.addpayload()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("resp :"+resp);
		//Add place -> update place with ID-> validate woth GET api
		JsonPath jp=new JsonPath(resp);
		String placeId=jp.get("place_id");
		System.out.println("place id -"+placeId);
		
		//update place
		String newAddress="summer walk, AUS";
		given().log().all().queryParams("key","qaclick123").headers("Content-Type", "application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").when().put("maps/api/place/update/json")
		.then().log().all().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		
		//get place API
		String resp1=given().log().all().queryParams("key","qaclick123").queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().log().all().assertThat().log().all().statusCode(200).extract().response().asString();
		System.out.println(resp1);
		
		JsonPath jp1=Reusablemethods.rawToJson(resp1);
		String address=jp1.get("address");
		System.out.println("address -"+address);
		
		Assert.assertEquals(newAddress,address);
	}

}
