package apiTests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailValidationTest {

    private static final String USERS_SEARCH_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String POSTS_SEARCH_URL = "https://jsonplaceholder.typicode.com/posts";
    private static final String COMMENTS_SEARCH_URL = "https://jsonplaceholder.typicode.com/comments";
    private static final String USERNAME = "Delphine";

   @Test
    public void Test() {

       Response personByUsername = getPersonByUsername(USERNAME);
       assertEquals(personByUsername.getStatusCode(), HTTP_OK);

    }
    private Response getPersonByUsername(String username) {
        return given()
                .when()
                .get(USERS_SEARCH_URL + "?username=" + username);
    }

    private Response getUserPosts(int userId) {
        return given()
                .when()
                .get(POSTS_SEARCH_URL + "?userId=" + userId);
    }

    private Response getPostComments(int postId) {
        return given()
                .when()
                .get(COMMENTS_SEARCH_URL + "?postId=" + postId);
    }
}
