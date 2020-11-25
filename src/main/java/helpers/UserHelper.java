package helpers;

import io.restassured.response.Response;
import pojo.User;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserHelper extends BaseHelper{
    private static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";
    public static final java.lang.String USERNAME_QUERY = "?username=";

    public Response getPersonByUsername(String username) {
        return given()
                .when()
                .get(USERS_SEARCH_URL + USERNAME_QUERY + username);
    }

    public void checkOnlyOneUserFound(User[] foundUsers) {
        assertEquals(foundUsers.length, 1);
    }
}
