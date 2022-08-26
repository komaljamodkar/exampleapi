

package oAuth;

import static io.restassured.RestAssured.given;

import java.util.stream.Stream;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import payloadclassfile.Payloadstring;

public class ClientCred {

	public static void main(String[] args) {
		
		String response =

				given() 

				.urlEncodingEnabled(false)

			//	.queryParams("code",code)



				.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")

				.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

				.queryParams("grant_type", "authorization_code")

				.queryParams("state", "verifyfjdss")

				.queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")

				// .queryParam("scope", "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")



				.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")

				.when().log().all()

				.post("https://www.googleapis.com/oauth2/v4/token").asString();

		// System.out.println(response);

		JsonPath jsonPath = new JsonPath(response);

		String accessToken = jsonPath.getString("access_token");

		System.out.println(accessToken);

		String r2=    given().contentType("application/json").

				queryParams("access_token", accessToken).expect().defaultParser(Parser.JSON)

				.when()

				.get("https://rahulshettyacademy.com/getCourse.php")

				.asString();

		System.out.println(r2);



	}
}
