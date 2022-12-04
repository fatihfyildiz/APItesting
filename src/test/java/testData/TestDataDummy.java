package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataDummy {

    public int StatusCode= 200;
    public String contentyType= "application/json";

    public JSONObject innerDataJsonBodyOlustur(){

        JSONObject innerDataBodyJSON= new JSONObject();

        innerDataBodyJSON.put("id",3);
        innerDataBodyJSON.put("employee_name","Ashton Cox");
        innerDataBodyJSON.put("employee_salary",86000);
        innerDataBodyJSON.put("employee_age",66);
        innerDataBodyJSON.put("profile_image","");

        return innerDataBodyJSON;
    }

    public JSONObject expectedDataBodyOlustur(){

        JSONObject expDataJSON= new JSONObject();

        expDataJSON.put("status","success");
        expDataJSON.put("data",innerDataJsonBodyOlustur());
        expDataJSON.put("message","Successfully! Record has been fetched.");

        return expDataJSON;
    }

    public HashMap expectedDataOlusturMap(){

        HashMap<String,Object> innerMap= new HashMap<>();

        innerMap.put("id",3.0);
        innerMap.put("employee_name","Ashton Cox");
        innerMap.put("employee_salary",86000.0);
        innerMap.put("employee_age",66.0);
        innerMap.put("profile_image","");

        HashMap<String,Object> expMap= new HashMap<>();

        expMap.put("status","success");
        expMap.put("data",innerMap);
        expMap.put("message","Successfully! Record has been fetched.");


        return expMap;
    }

}
