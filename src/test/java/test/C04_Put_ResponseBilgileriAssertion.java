package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C04_Put_ResponseBilgileriAssertion {

    /*
        https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki
        Json formatindaki body ile bir PUT request gonderdigimizde
                {
                "title":"Cemile",
                "body":"Bardak",
                "userId":3,
                "id":1
                }
        donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve Server isimli Header’in degerinin cloudflare,
            ve status Line’in HTTP/1.1 200 OK
     */

    @Test
    public void put01(){

        // 1 - Request icin Url ve Body hazirlayalim

        String url= "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject requestBody= new JSONObject();

        requestBody.put("title","Cemile");
        requestBody.put("body","Bardak");
        requestBody.put("userId", 3);
        requestBody.put("id",1);

        System.out.println(requestBody);


        // 2- Expected Data hazirlanir
        // bu soruda expected data yok, bilgilerin hepsi yukarida

        // 3- Response'u kaydet
        Response response= given().
                                    contentType(ContentType.JSON).
                            when().
                                    body(requestBody.toString()).
                                    put(url);

        response.prettyPrint();

        // 4 - Assertion

        response.then().assertThat().statusCode(200).
                                    contentType("application/json; charset=utf-8").
                                    header("Server","cloudflare").
                                    statusLine("HTTP/1.1 200 OK");

    }

}
