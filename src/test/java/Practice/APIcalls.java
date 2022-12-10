package Practice;

public class APIcalls {

    // Bu class'i, BaseUrl'deki class'lar gibi ve spec methodu gibi kullanacagiz

    public static String GET_USER_WITH_ID= "https://www.gmibank.com/api/tp-customers/";

    public static String POST_USER= "http://dummy.restapiexample.com/api/v1/create";

    // asagidaki method ile Endpoint'in sonuna id eklemek istiyoruz cunku user'i id ile getirmeliyiz
    // bundan dolayi dinamik bir method create ediyoruz
    public static String createGetUserApiCall(int id){
        return GET_USER_WITH_ID + id;
    }

    public static String createPostUserApiCall(){
        return POST_USER;
    }

}
