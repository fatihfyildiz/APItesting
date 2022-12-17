package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {

    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */

    @Test
    public void get01(){

        // 1 - Request URL hazirla (GET oldugu icin Body'e gerek yok)
        String url= "http://dummy.restapiexample.com/api/v1/employee/3";

        // 2 - Expected Data hazirla
        JSONObject data= new JSONObject();
        JSONObject expBody= new JSONObject();

        data.put("id",3);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        expBody.put("status","success");
        expBody.put("data",data);
        expBody.put("message","Successfully! Record has been fetched.");

        System.out.println("Expected Body : " + expBody);

        // 3 - Response'u kaydet
        Response response = given().when().get(url); // GET oldugu icin contentType(ContentType.JSON) kismina gerek yok

        response.prettyPrint();

        // 4 - Assertion

        JsonPath respJP = response.jsonPath();

        SoftAssert softAssert= new SoftAssert();

        softAssert.assertEquals(respJP.get("status"),expBody.get("status"));
        softAssert.assertEquals(respJP.get("data.id"),expBody.getJSONObject("data").get("id"));
        softAssert.assertEquals(respJP.get("data.employee_name"),expBody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(respJP.get("data.employee_salary"),expBody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(respJP.get("data.employee_age"),expBody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(respJP.get("data.profile_image"),expBody.getJSONObject("data").get("profile_image"));
        softAssert.assertEquals(respJP.get("message"),expBody.get("message"));

        softAssert.assertAll();

    }

}
