package apiTests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojo.Comment;
import pojo.Post;
import pojo.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidationTest {

    private static final String USERS_SEARCH_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String POSTS_SEARCH_URL = "https://jsonplaceholder.typicode.com/posts";
    private static final String COMMENTS_SEARCH_URL = "https://jsonplaceholder.typicode.com/comments";
    private static final String USERNAME = "Delphine";
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Test
    public void Test() {

        Response personByUsername = getPersonByUsername(USERNAME);
        assertEquals(personByUsername.getStatusCode(), HTTP_OK);

        User[] foundUsers = personByUsername.getBody().as(User[].class);
        assertEquals(foundUsers.length, 1);
        int userId = foundUsers[0].getId();

        Response searchPosts = getUserPosts(userId);
        assertEquals(personByUsername.getStatusCode(), HTTP_OK);

        Post[] foundPosts = searchPosts.getBody().as(Post[].class);
        ArrayList<Integer> postIds = new ArrayList<>();
        for (int i = 0; i < foundPosts.length; i++) {
            postIds.add(foundPosts[i].getId());
        }

        List<Comment> foundComments = new ArrayList<>();
        for (int postId : postIds) {
            foundComments.addAll(Arrays.asList(getPostComments(postId).getBody().as(Comment[].class)));
        }

        ArrayList<String> emails = new ArrayList<>();
        for (int i = 0; i < foundComments.size(); i++) {
            emails.add(foundComments.get(i).getEmail());
        }

        for (String value : emails) {
            assertTrue(EMAIL_REGEX.matcher(value).matches());
        }

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
