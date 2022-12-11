package test;

import Pojos.PojoHerokuappBooking;
import Pojos.PojoHerokuappBookingDates;
import Pojos.PojoHerokuappExpectedBody;
import baseURL.HerokuAppBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_Post_Pojo extends HerokuAppBaseURL {

    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.

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

                        Response Body = Expected Data
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
                        ,
                        "additionalneeds":"wi-fi"
                    }
     */

    /* tek tek yapmak istersek; C27 gibi:
    // 1) Tum variable’lari (key'ler)  "private" olarak olusturalim
    // 2) Tum variable’lar icin getter() and setter() metodlari olusturalim --sag tus--Generate-- Getter and Setter--hepsini sec--ok
    // 3) Tum parametreleri iceren bir constructor olusturalim ---sag tus--Generate-- Constructor--hepsini sec--ok
    // 4) Default constructor (parametresiz) olusturalim--sag tus--Generate-- Constructor-seciliolan--Select None tikla
    // 5) toString() metodu olusturalim--sag tus--Generate-- toString-hepsini sec--ok
     */

    @Test
    public void post01(){

        // 1 - Request icin URL ve Body hazirlanir

        specHerokuApp.pathParam("pp1","booking");

        // Pojo class'i olusturalim
        PojoHerokuappBookingDates pojoHerokuappBookingDates= new PojoHerokuappBookingDates("2021-06-10","2021-06-10");

        PojoHerokuappBooking reqBody= new PojoHerokuappBooking
                ("Ahmet","Bulut",500,false,pojoHerokuappBookingDates,"wi-fi");

        // 2 - Expected Data hazirlanir

        PojoHerokuappExpectedBody expData= new PojoHerokuappExpectedBody(24,reqBody);

        // 3 - Response'u kaydet

        Response response= given().
                                    spec(specHerokuApp).contentType(ContentType.JSON).
                            when().
                                    body(reqBody).post("/{pp1}");

        // 4 - Assertion

        PojoHerokuappExpectedBody respPojo= response.as(PojoHerokuappExpectedBody.class);

        assertEquals(expData.getBooking().getFirstname(),respPojo.getBooking().getFirstname());
        assertEquals(expData.getBooking().getLastname(),respPojo.getBooking().getLastname());
        assertEquals(expData.getBooking().getTotalprice(),respPojo.getBooking().getTotalprice());
        assertEquals(expData.getBooking().isDepositpaid(),respPojo.getBooking().isDepositpaid()); // depositpaid Booelan oldugu icin is ile cikar
        assertEquals(expData.getBooking().getBookingdates().getCheckin(),respPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expData.getBooking().getBookingdates().getCheckout(),respPojo.getBooking().getBookingdates().getCheckout());
        assertEquals(expData.getBooking().getAdditionalneeds(),respPojo.getBooking().getAdditionalneeds());

    }

}
