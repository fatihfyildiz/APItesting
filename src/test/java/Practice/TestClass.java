package Practice;

import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Test;

public class TestClass {

    RestApiUtils restApiUtils= new RestApiUtils();

    @Test
    public void verifyUserWithID(){

        // JSONPATH ile dogrulama yapalim
        JsonPath json= restApiUtils.checkUserWithIDget(114351).jsonPath();

        Assert.assertEquals("Della",json.get("firstName"));
        Assert.assertEquals("Heaney",json.get("lastName"));
        Assert.assertEquals("ricardo.larkin@yahoo.com",json.get("email"));
    }

    @Test
    public void createUserTestPost(){
        restApiUtils.postUserApiCall("Fatih","4200","46").prettyPrint();
    }

}
