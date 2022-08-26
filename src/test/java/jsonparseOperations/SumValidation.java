package jsonparseOperations;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import payloadclassfile.Reusablemethods;

public class SumValidation {
	String file=".//resources//payload2.json";

	JsonPath js=Reusablemethods.rawFileToJson(file);

	@Test
	public void Validatesum() {
		int count=js.getInt("courses.size()");
int sum=0;
		for(int i=0;i<count;i++)
		{
			String courseTitles=js.get("courses["+i+"].title");
			int price=js.get("courses["+i+"].price");
			int copies=js.get("courses["+i+"].copies");
			sum+=price*copies;
			
		}
		
		int totalAmount= js.getInt("dashboard.purchaseAmount");
		Assert.assertTrue(sum==totalAmount);
		Assert.assertEquals(sum,totalAmount);
	}

}
