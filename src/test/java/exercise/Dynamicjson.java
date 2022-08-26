package exercise;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloadclassfile.Payloadstring;
import payloadclassfile.Reusablemethods;

public class Dynamicjson {

	@Test
	public void updatevabook() {
		try {
			String filepath=".//resources//libPayload.json";
			RestAssured.baseURI="https://rahulshettyacademy.com";

			String str=	new String(Files.readAllBytes(Paths.get(filepath)));
			str=str.replace("$name", "abc");

			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Test(dataProvider = "bookData" )
	public void addbook(String val1,String val2) {
		System.out.println(val1+ "   =="+val2);
		String bookId=val1+val2;
		RestAssured.baseURI="http://216.10.245.166";

		String resp=given().log().all().headers("Content-Type", "application/json")
				.body(Payloadstring.addBook(val1,val2)).when().post("Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();

		JsonPath js= Reusablemethods.rawToJson(resp);

		String id=js.get("ID");

		Assert.assertEquals(id, bookId);
		System.out.println(id);	

		//delete ID

		String resp1=given().log().all().headers("Content-Type", "application/json")
				.body("{\r\n"
						+ "    \"ID\": \""+id+"\"\r\n"
						+ "}").when().delete("Library/DeleteBook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString(); 

		System.out.println("resp1 :"+resp1);
	}



	@DataProvider(name="bookData")
	public Object[][] getData() {
		//		Object [][]data=new Object[1][2];
		//		data[0][0]="awe";
		//		data[0][1]="3434";
		//		return data;

		return new Object[][] {{"aqqw","4522"},{"fegf","6825"},{"ryt","3146"}};

	}
}
