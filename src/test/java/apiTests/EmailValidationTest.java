package apiTests;

import helpers.Base;
import helpers.Comments;
import helpers.Posts;
import helpers.Users;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojo.Comment;
import pojo.Post;
import pojo.User;

import java.util.ArrayList;
import java.util.List;

public class EmailValidationTest {

    Base base = new Base();
    Users users = new Users();
    Posts posts = new Posts();
    Comments comments = new Comments();

    private static final String USERNAME = "Delphine";

    @Test
    public void Test() {

        Response searchResp = users.getPersonByUsername(USERNAME);
        base.checkStatusCode(searchResp);

        User[] foundUsers = searchResp.getBody().as(User[].class);
        users.checkOnlyOneUserFound(foundUsers);
        int userId = foundUsers[0].getId();

        Response searchPosts = posts.getUserPosts(userId);
        base.checkStatusCode(searchPosts);

        Post[] foundPosts = searchPosts.getBody().as(Post[].class);
        ArrayList<Integer> postIds = new ArrayList<>();
        posts.createPostIdsList(postIds, foundPosts);

        List<Comment> foundComments = new ArrayList<>();
        comments.getCommentsList(postIds, foundComments);

        ArrayList<String> emails = new ArrayList<>();
        comments.getEmails(emails, foundComments);

        comments.checkEmailFormat(emails);
    }
}
