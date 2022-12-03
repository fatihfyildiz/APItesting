package test;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseURL {

    /*
    C18_Get_TestDataClassKullanimi

      https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
      request yolladigimizda donen response’in status kodunun 200 ve
      response body’sinin asagida verilen ile ayni oldugunutest ediniz


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

        // 1 - Request URL ve Body hazirlanir (GET methodu'u icin Body'e gerek yok)
        specJsonPlace.pathParams("pp1","posts","pp2",22);

        // 2 - Expected Data hazirlanir

        TestDataJsonPlaceHolder testDataJsonPlaceHolder= new TestDataJsonPlaceHolder();
        JSONObject expData= testDataJsonPlaceHolder.expectedDataOlustur();

        System.out.println(expData);

        // 3 - Response'u kaydet
        Response response= given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4 - Assertion

        JsonPath resJP = response.jsonPath();

        assertEquals(200,response.getStatusCode());
        assertEquals(expData.get("userId"),resJP.get("userId"));
        assertEquals(expData.get("id"),resJP.get("id"));
        assertEquals(expData.get("title"),resJP.get("title"));
        assertEquals(expData.get("body"),resJP.get("body"));


    }


}
