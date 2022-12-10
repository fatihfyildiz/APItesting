package Practice;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {

    // Web sitelerinin guvenligi acisindan developer'lar otomatik olarak saat basi veya belli bir periyotta degisen
    // sifreleme create ederler. Buna TOKEN denir...
    // Asagidaki method ile ise token'i otomatik olarak almak ve code'a implement etmek icin olusturuyoruz
    public static String generateToken(){
        String username= "BATCH44Api";
        String password= "Batch44+";

        Map<String,Object> map= new HashMap<>();

        map.put("username",username);
        map.put("password",password);

        String endPoint= "https://www.gmibank.com/api/authenticate";

        Response response= given().contentType(ContentType.JSON).when().post(endPoint);

        JsonPath token= response.jsonPath();

        return token.getString("id_token");
        // id_token endPoint'ten gelmekte olup token'in basindaki path text'i de diyebiliriz
    }

    public static void main(String[] args) {
        System.out.println("Generate edilen Token : " + generateToken());
    }

}
