package test;

import baseURL.DummyBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataDummy;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C20_Get_TestDataKullanimi extends DummyBaseURL {

    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un status code’unun 200,
    content Type’inin application/json ve body’sinin asagidaki gibi oldugunu test edin.

    Expected Body
        {
        "status":"success",
        "data": {
                "id": 3,
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

        // 1 - Request URL Ve Body hazirlanir
        specDummy.pathParams("pp1","employee","pp2",3);

        // 2 - Expected Data hazirlanir
        TestDataDummy testDataDummy= new TestDataDummy();

        JSONObject expData= testDataDummy.expectedDataBodyOlustur();

        // System.out.println(expData); ==> yazdirara kda gorebiliriz, eger istersek

        // 3 - Response'u kaydet

        Response response= given().spec(specDummy).when().get("/{pp1}/{pp2}");

        // 4 - Assertion

        JsonPath resJP= response.jsonPath();

        assertEquals(testDataDummy.StatusCode,response.getStatusCode());
        assertEquals(testDataDummy.contentyType,response.contentType());
        assertEquals(expData.get("status"),resJP.get("status"));
        assertEquals(expData.get("message"),resJP.get("message"));
        assertEquals(expData.getJSONObject("data").get("id"),resJP.get("data.id"));
        assertEquals(expData.getJSONObject("data").get("employee_name"),resJP.get("data.employee_name"));
        assertEquals(expData.getJSONObject("data").get("employee_salary"),resJP.get("data.employee_salary"));
        assertEquals(expData.getJSONObject("data").get("employee_age"),resJP.get("data.employee_age"));
        assertEquals(expData.getJSONObject("data").get("profile_image"),resJP.get("data.profile_image"));

    }

}
