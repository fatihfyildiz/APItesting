package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {
        /*
        https://restful-booker.herokuapp.com/booking/256884 url’ine bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
         */

    @Test
    public void get01(){

        // 1- Request icin Url ve Body hazirlanir

        String url= "https://restful-booker.herokuapp.com/booking/256884";

        // 2- Expected Data hazirlanir
        // bu soruda expected data yok, bilgilerin hepsi yukarida

        // 3- Response'u kaydet
        Response response= given().when().get(url);
        response.prettyPrint(); // tum body getirir

        System.out.println("Status Code : " + response.getStatusCode()); // sadece Status Code dondurur/getirir ==> Status Code : 200
        System.out.println("Content Type : " + response.getContentType()); // Content Type : application/json; charset=utf-8
        System.out.println("Server Header'in deger : " + response.getHeader("Server")); // Postman'da Headers altindaki Server ==> Cowboy
        System.out.println("Status Line : " + response.getStatusLine()); // Status Line : 1255
        System.out.println("Response suresi : " + response.getTime()); // 1707 ==> (milisaniye, ms)

        // 4- Assertion ==> ama su anda degil, ileriki asamalarda yapacagiz...

    }

}
