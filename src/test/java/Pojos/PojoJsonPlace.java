package Pojos;

public class PojoJsonPlace {

    // 1) Tum variable’lari  "private" olarak olusturalim
    // 2) Tum variable’lar icin getter() and setter() metodlari olusturalim
    // 3) Tum parametreleri iceren bir constructor olusturalim
    // 4) Default constructor (parametresiz) olusturalim
    // 5) toString() metodu olusturalim

    /*
    Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */

    // 1) Tum variable’lari  "private" olarak olusturalim

    private String title;
    private String body;
    private int userId;
    private int id;


    // 2) Tum variable’lar icin getter() and setter() metodlari olusturalim

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    // 3) Tum parametreleri iceren bir constructor olusturalim

    public PojoJsonPlace(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    // 4) Default constructor (parametresiz) olusturalim

    public PojoJsonPlace() {
    }

    // 5) toString() metodu olusturalim


    @Override
    public String toString() {
        return "PojoJsonPlace{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
