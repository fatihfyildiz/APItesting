package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {

    @Test
    public void jsonObje(){
    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.

    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
     */

        JSONObject ilkJSONObje = new JSONObject();

        ilkJSONObje.put("title","Ahmet");
        ilkJSONObje.put("body","Merhaba");
        ilkJSONObje.put("userId",1);

        System.out.println(ilkJSONObje);

    }

    @Test
    public void jsonObje2(){

        /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */

        JSONObject innerJson = new JSONObject();

        innerJson.put("checkin","2018-01-01");
        innerJson.put("checkout","2019-01-01");

        JSONObject bodyJson = new JSONObject();

        bodyJson.put("firstname","Jim");
        bodyJson.put("additionalneeds","Breakfast");
        bodyJson.put("bookingdates",innerJson);
        bodyJson.put("totalprice",111);
        bodyJson.put("depositpaid",true);
        bodyJson.put("lastname", "Brown");

        System.out.println(bodyJson);


    }

}
