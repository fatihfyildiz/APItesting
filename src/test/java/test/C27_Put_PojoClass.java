package test;

import Pojos.PojoJsonPlace;
import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_Put_PojoClass extends JsonPlaceHolderBaseURL {

    /*
    C27_Put_PojoClass
     https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
     body’e sahip bir PUT request yolladigimizda donen response’in
     response body’sinin asagida verilen ile ayni oldugunu test ediniz

     Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }

    Expected Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */

    @Test
    public void put01(){

        // 1 - Request icin URL ve Body hazirlanir

        specJsonPlace.pathParams("pp1","posts","pp2",70);

        /*
        Request Body icin Pojo Class olusturduk PojoJsonPlace'de
         */

        PojoJsonPlace reqBody= new PojoJsonPlace("Ahmet","Merhaba",10,70);

        System.out.println("reqBody : " + reqBody); // reqBody : PojoJsonPlace{title='Ahmet', body='Merhaba', userId=10, id=70}

        // 2 - Expected Data hazirlanir (eger soru'da istenmis ise)

        PojoJsonPlace expData= new PojoJsonPlace("Ahmet","Merhaba",10,70);

        System.out.println("expData : " + expData); // expData : PojoJsonPlace{title='Ahmet', body='Merhaba', userId=10, id=70}

        // 3 - Response'u kaydet

        Response response= given().
                                    spec(specJsonPlace).contentType(ContentType.JSON).
                            when().
                                    body(reqBody).
                                    put("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4 - Assertion

        PojoJsonPlace respPojo= response.as(PojoJsonPlace.class);

        assertEquals(expData.getBody(),respPojo.getBody());
        assertEquals(expData.getTitle(),respPojo.getTitle());
        assertEquals(expData.getUserId(),respPojo.getUserId());
        assertEquals(expData.getId(),respPojo.getId());

    }


}
