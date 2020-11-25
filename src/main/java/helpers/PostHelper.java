package helpers;

import io.restassured.response.Response;
import pojo.Post;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class PostHelper extends BaseHelper{
    private static final String POSTS_URL = "https://jsonplaceholder.typicode.com/posts";
    public static final java.lang.String USERID_QUERY = "?userId=";

    public Response getUserPosts(int userId) {
        return given()
                .when()
                .get(POSTS_URL + USERID_QUERY + userId);
    }

    public ArrayList<Integer> createPostIdsList(ArrayList<Integer> postIds, Post[] foundPosts) {
        for (int i = 0; i < foundPosts.length; i++) {
            postIds.add(foundPosts[i].getId());
        }
        return postIds;
    }
}

