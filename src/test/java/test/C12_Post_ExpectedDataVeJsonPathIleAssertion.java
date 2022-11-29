package test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import java.util.ResourceBundle;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class C12_Post_ExpectedDataVeJsonPathIleAssertion {
    /*
   https://restful-booker.herokuapp.com/booking url’ine
   asagidaki body'ye sahip bir POST request gonderdigimizde
   donen response’un id disinda asagidaki gibi oldugunu test edin.
                       Request body
                  {
                       "firstname" : "Ali",
                       "lastname" : “Bak",
                       "totalprice" : 500,
                       "depositpaid" : false,
                       "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                                         },
                       "additionalneeds" : "wi-fi"
                   }
                       Response Body
                  {
                   "bookingid":24,
                   "booking":{
                       "firstname":"Ali",
                       "lastname":"Bak",
                       "totalprice":500,
                       "depositpaid":false,
                       "bookingdates":{
                           "checkin":"2021-06-01",
                           "checkout":"2021-06-10"
                                       }
                       ,
                       "additionalneeds":"wi-fi"
                            }
                   }
        */
    @Test
    public void post01(){
        // 1 - Request URL ve Body hazirla
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject innerBody = new JSONObject();
        JSONObject reqBody = new JSONObject();

        innerBody.put("checkin","2021-06-01");
        innerBody.put("checkout","2021-06-10");

        reqBody.put("firstname" , "Ali");
        reqBody.put("lastname" , "Bak");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" ,false);
        reqBody.put("bookingdates" , innerBody);
        reqBody.put("additionalneeds" , "wi-fi");

        // 2 - Expected Data hazirla
        JSONObject bookingdates = new JSONObject();
        JSONObject booking = new JSONObject();
        JSONObject expBody = new JSONObject();

        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");

        booking.put("firstname" , "Ali");
        booking.put("lastname" , "Bak");
        booking.put("totalprice" , 500);
        booking.put("depositpaid" ,false);
        booking.put("bookingdates" , innerBody);
        booking.put("additionalneeds" , "wi-fi");

        expBody.put("bookingid",24);
        expBody.put("booking",booking);

        // 3 - Response ' u kaydet
        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);
        response.prettyPrint();

        // 4 - Assertion
        JsonPath resJS = response.jsonPath();

        assertEquals(expBody.getJSONObject("booking").get("firstname"),resJS.get("booking.firstname"));
        assertEquals(expBody.getJSONObject("booking").get("lastname"),resJS.get("booking.lastname"));
        assertEquals(expBody.getJSONObject("booking").get("totalprice"),resJS.get("booking.totalprice"));
        assertEquals(expBody.getJSONObject("booking").get("depositpaid"),resJS.get("booking.depositpaid"));
        assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),resJS.get("booking.additionalneeds"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),resJS.get("booking.bookingdates.checkin"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),resJS.get("booking.bookingdates.checkout"));

    }
}