package apiTests;


import helpers.JsonValidator;
import org.junit.jupiter.api.Test;

public class HealthCheck {
    JsonValidator jsonValidator = new JsonValidator();

    private static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String POSTS_URL = "https://jsonplaceholder.typicode.com/posts";
    private static final String COMMENTS_URL = "https://jsonplaceholder.typicode.com/comments";
    private static final String USERS_JSON_PATH = "users.json";
    private static final String POSTS_JSON_PATH = "posts.json";
    private static final String COMMENTS_JSON_PATH = "comments.json";

    @Test
    public void Test() {
        jsonValidator.validateJsonSchema(USERS_URL, USERS_JSON_PATH);
        jsonValidator.validateJsonSchema(POSTS_URL, POSTS_JSON_PATH);
        jsonValidator.validateJsonSchema(COMMENTS_URL, COMMENTS_JSON_PATH);
    }
}

