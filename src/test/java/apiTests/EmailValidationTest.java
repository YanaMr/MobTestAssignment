package apiTests;

import base.HealthCheck;
import helpers.BaseHelper;
import helpers.CommentHelper;
import helpers.PostHelper;
import helpers.UserHelper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojo.Comment;
import pojo.Post;
import pojo.User;

import java.util.ArrayList;
import java.util.List;

public class EmailValidationTest extends HealthCheck {

    UserHelper userHelper = new UserHelper();
    PostHelper postHelper = new PostHelper();
    CommentHelper commentHelper = new CommentHelper();

    private static final String USERNAME = "Delphine";

    @Test
    public void Test() {

        Response searchResp = userHelper.getPersonByUsername(USERNAME);
        userHelper.checkStatusCodeIsOk(searchResp);

        User[] foundUsers = searchResp.getBody().as(User[].class);
        userHelper.checkOnlyOneUserFound(foundUsers);
        int userId = foundUsers[0].getId();

        Response searchPosts = postHelper.getUserPosts(userId);
        postHelper.checkStatusCodeIsOk(searchPosts);

        Post[] foundPosts = searchPosts.getBody().as(Post[].class);
        ArrayList<Integer> postIds = new ArrayList<>();
        postHelper.createPostIdsList(postIds, foundPosts);

        List<Comment> foundComments = new ArrayList<>();
        commentHelper.getCommentsList(postIds, foundComments);

        ArrayList<String> emails = new ArrayList<>();
        commentHelper.getEmails(emails, foundComments);

        commentHelper.checkEmailFormat(emails);
    }
}
