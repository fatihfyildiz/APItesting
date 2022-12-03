package testData;

import org.json.JSONObject;

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

}
