package Practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class RestApiUtils extends Authentication{

    // APIcalls'daki methodlari kullanmak icin obje uretiyoruz
    static APIcalls apiCalls= new APIcalls();

    static Response checkUserWithIDget(int id){
        Response response= null;

        try{
            response= RestAssured.given().
                                    headers("Content-Type", ContentType.JSON).
                                    header("Authorization","Bearer " + generateToken()).
                                    when().get(APIcalls.createGetUserApiCall(id));
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }

        return response;
    }

    static Response postUserApiCall(String name, String salary, String age){
        Response response= null;

        try{
            response= RestAssured.given().
                    headers("Content-Type", ContentType.JSON).
                    when().get(APIcalls.createPostUserApiCall());

            Assert.assertEquals(response.getStatusCode(),200);

        } catch (Exception e){
            Assert.fail(e.getMessage());
        }

        return response;
    }

}
