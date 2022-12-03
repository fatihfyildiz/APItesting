package test;

import baseURL.HerokuAppBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataHerokuApp;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C21_Post_TestDataKullanimi extends HerokuAppBaseURL {

/*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip
    bir POST request gonderdigimizde donen response’un id haric body'sinin asagidaki gibi oldugunu test edin.
    Request body
          {
          "firstname" : "Ahmet",
          "lastname" : “Bulut",
          "totalprice" : 500,
          "depositpaid" : false,
          "bookingdates" : {
                      "checkin" : "2021-06-01",
                      "checkout" : "2021-06-10"
                        },
          "additionalneeds" : "wi-fi"
           }
    Expected Body
    {
    "bookingid":24,
    "booking":{
            "firstname":"Ahmet",
            "lastname":"Bulut",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                            },
            "additionalneeds":"wi-fi"
               }
    }
     */

    @Test
    public void post01(){

        // 1 - Request URL Ve Body hazirlanir
        specHerokuApp.pathParam("pp1","booking");

        TestDataHerokuApp testDataHerokuApp= new TestDataHerokuApp();

        JSONObject reqBody= testDataHerokuApp.requestBodyOlusturJson();


        // 2 - Expected Data hazirlanir

        JSONObject expData= testDataHerokuApp.expectedBodyOlusturJson();

        // 3 - Response'u kaydet

        Response response= given().
                                    spec(specHerokuApp).
                                    contentType(ContentType.JSON).
                            when().
                                    body(reqBody.toString()).
                                    post("/{pp1}");

        // 4 - Assertion

        JsonPath respJP= response.jsonPath();

        assertEquals(testDataHerokuApp.StatusCode,response.statusCode());
        assertEquals(expData.getJSONObject("booking").get("firstname"),respJP.get("booking.firstname"));
        assertEquals(expData.getJSONObject("booking").get("lastname"),respJP.get("booking.lastname"));
        assertEquals(expData.getJSONObject("booking").get("totalprice"),respJP.get("booking.totalprice"));
        assertEquals(expData.getJSONObject("booking").get("depositpaid"),respJP.get("booking.depositpaid"));
        assertEquals(expData.getJSONObject("booking").get("additionalneeds"),respJP.get("booking.additionalneeds"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),respJP.get("booking.bookingdates.checkin"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),respJP.get("booking.bookingdates.checkout"));

    }

}
