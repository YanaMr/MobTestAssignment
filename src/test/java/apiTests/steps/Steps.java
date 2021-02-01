package apiTests.steps;

import cucumber.Context;
import cucumber.ScenarioContext;
import helpers.CommentHelper;
import helpers.PostHelper;
import helpers.UserHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.Comment;
import pojo.Post;
import pojo.User;

import java.util.ArrayList;
import java.util.List;

public class Steps {

    UserHelper userHelper = new UserHelper();
    PostHelper postHelper = new PostHelper();
    CommentHelper commentHelper = new CommentHelper();
    ScenarioContext scenarioContext;

    public Steps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    private static final String USERNAME = "Delphine";

    @Given("I sent a request to get user by username and I received response body")
    public void requestUsername() {
        Response searchResp = userHelper.getPersonByUsername(USERNAME);
        User[] foundUsers = searchResp.getBody().as(User[].class);
        scenarioContext.setContext(Context.FOUND_USER_BODY, foundUsers);
    }

    @And("I check that only one user is found")
    public void checkThatOnlyOneUserIsFound() {
        User[] foundUsers = (User[]) scenarioContext.getContext(Context.FOUND_USER_BODY);
        userHelper.checkOnlyOneUserFound(foundUsers);
    }

    @And("I save users ID")
    public void saveUsersID() {
        User[] foundUsers = (User[]) scenarioContext.getContext(Context.FOUND_USER_BODY);
        int userId = foundUsers[0].getId();
        scenarioContext.setContext(Context.USER_ID, userId);
    }

    @And("I sent a request to get posts by user ID")
    public void sentARequestToGetPostsByUserID() {
        int userId = (int) scenarioContext.getContext(Context.USER_ID);
        Response searchPosts = postHelper.getUserPosts(userId);
        scenarioContext.setContext(Context.GET_POSTS, searchPosts);
    }

    @And("I get response body for all Posts")
    public void getResponseBodyForAllPosts() {
        Response searchPosts = (Response) scenarioContext.getContext(Context.GET_POSTS);
        Post[] foundPosts = searchPosts.getBody().as(Post[].class);
        scenarioContext.setContext(Context.FOUND_POSTS, foundPosts);
    }

    @And("I create a list of posts")
    public void createAListOfPosts() {
        Post[] foundPosts = (Post[]) scenarioContext.getContext(Context.FOUND_POSTS);
        ArrayList<Integer> postIds = new ArrayList<>();
        postHelper.createPostIdsList(postIds, foundPosts);
        scenarioContext.setContext(Context.POSTS_ID, postIds);
    }

    @When("I create a list of all comments")
    public void createAListOfAllComments() {
        ArrayList<Integer> postIds = (ArrayList<Integer>) scenarioContext.getContext(Context.POSTS_ID);
        List<Comment> foundComments = new ArrayList<>();
        commentHelper.getCommentsList(postIds, foundComments);
        scenarioContext.setContext(Context.FOUND_COMMENTS, foundComments);
    }

    @And("I received list of emails")
    public void receivedListOfEmails() {
        List<Comment> foundComments = (List<Comment>) scenarioContext.getContext(Context.FOUND_COMMENTS);
        ArrayList<String> emails = new ArrayList<>();
        commentHelper.getEmails(emails, foundComments);
        scenarioContext.setContext(Context.GET_EMAILS, emails);
    }

    @Then("I validate email format")
    public void validateEmailFormat() {
        ArrayList<String> emails = (ArrayList<String>) scenarioContext.getContext(Context.GET_EMAILS);
        commentHelper.checkEmailFormat(emails);
    }
}
