package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_Get_ResponseBilgileriAssertion {

        /*
        https://restful-booker.herokuapp.com/booking/233827 url’ine bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK

        oldugunu test edin
         */

    @Test
    public void get02(){

        // 1- Request icin Url ve Body hazirlanir (GET oldugu icin Body'e gerek yok)
        String url= "https://restful-booker.herokuapp.com/booking/233827";

        // 2- Expected Data hazirlanir
        // bu soruda expected data yok, bilgilerin hepsi yukarida

        // 3- Response'u kaydet
        Response response= given().when().get(url);
        response.prettyPrint();

        // 4- Assertion
        response.then().assertThat().statusCode(200).
                                    contentType("application/json; charset=utf-8").
                                    header("Server", "Cowboy").
                                    statusLine("HTTP/1.1 200 OK");

    }

}
