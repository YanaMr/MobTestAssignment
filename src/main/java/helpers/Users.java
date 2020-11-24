package helpers;

import io.restassured.response.Response;
import pojo.User;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Users {
    private static final String USERS_SEARCH_URL = "https://jsonplaceholder.typicode.com/users";

    public Response getPersonByUsername(String username) {
        return given()
                .when()
                .get(USERS_SEARCH_URL + "?username=" + username);
    }

    public void checkOnlyOneUserFound(User[] foundUsers) {
        assertEquals(foundUsers.length, 1);
    }
}
