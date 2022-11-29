package test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class C11_Get_ExpectedDataOlusturma {
    /*
  https://jsonplaceholder.typicode.com/posts/22 url'ine
  bir GET request yolladigimizda donen response body’sinin
  asagida verilen ile ayni oldugunu test ediniz
 Response body :
{
"userId":3,
"id":22,
"title":"dolor sint quo a velit explicabo quia nam",
"body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
   */
    @Test
    public void get01(){
        // 1 - Request URL ve body hazirla
        String url = " https://jsonplaceholder.typicode.com/posts/22";

        // 2 - Expected Data hazirla
        JSONObject expBody = new JSONObject();

        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        // 3 - Response'u kaydet
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4 - Assertion
        // Oncelikle yapilmasi gereken sey Response'u JsonPath objesine cevirmek

        JsonPath respJSPath = response.jsonPath();

        assertEquals(expBody.get("userId"),respJSPath.getInt("userId")); // bastaki Assert. kismini silerek import ettik...
        assertEquals(expBody.get("id"),respJSPath.getInt("id"));
        assertEquals(expBody.get("title"),respJSPath.getString("title"));
        assertEquals(expBody.get("body"),respJSPath.getString("body"));
    }
}
