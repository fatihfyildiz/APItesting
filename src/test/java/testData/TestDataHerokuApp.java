package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataHerokuApp {

    public int StatusCode= 200;

    public JSONObject innerBodyOlusturJson(){

        JSONObject innerBody= new JSONObject();

        innerBody.put("checkin","2021-06-01");
        innerBody.put("checkout","2021-06-10");

        return innerBody;
    }

    public JSONObject requestBodyOlusturJson(){

        JSONObject reqBody= new JSONObject();

        reqBody.put("firstname","Ali");
        reqBody.put("lastname","Bak");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",innerBodyOlusturJson());
        reqBody.put("additionalneeds","wi-fi");

        return reqBody;
    }

    public JSONObject expectedBodyOlusturJson(){

        JSONObject expBody= new JSONObject();

        expBody.put("bookingid",24);
        expBody.put("booking",requestBodyOlusturJson());

        return expBody;
    }

    /*
    "firstname" : "Ali",
        "lastname" : "Bak",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
                 "checkin" : "2021-06-01",
                 "checkout" : "2021-06-10"
                          },
        "additionalneeds" : "wi-fi"
     */

    public HashMap innerBodyOlusturMap(){

        HashMap<String,Object> innerBody= new HashMap<>();

        innerBody.put("checkin","2021-06-01");
        innerBody.put("checkout","2021-06-10");

        return innerBody;
    }

    public HashMap requestBodyOlusturMap(){

        HashMap<String,Object> reqBody= new HashMap<>();

        reqBody.put("firstname","Ali");
        reqBody.put("lastname","Bak");
        reqBody.put("totalprice",500.0);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",innerBodyOlusturMap());
        reqBody.put("additionalneeds","wi-fi");

        return reqBody;
    }

    public HashMap expectedBodyOlusturMap(){

        HashMap<String,Object> expBody= new HashMap<>();

        expBody.put("bookingid",24.0);
        expBody.put("booking",requestBodyOlusturMap());

        return expBody;
    }

}
