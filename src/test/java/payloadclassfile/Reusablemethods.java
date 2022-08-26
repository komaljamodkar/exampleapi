package payloadclassfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.path.json.JsonPath;

public class Reusablemethods {

	public static JsonPath rawToJson(String response) {
		JsonPath jp=new JsonPath(response);
		return jp;
	}

	public static JsonPath rawFileToJson(String file) {
		JsonPath jp=null;
		try {
			String resp=new String(Files.readAllBytes(Paths.get(file)));
			jp = new JsonPath(resp);
		
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return jp;	
	}
}
