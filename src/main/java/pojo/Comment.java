package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class Comment {

    @JsonProperty("name")
    private String name;
    @JsonProperty("postId")
    private int postId;
    @JsonProperty("id")
    private int id;
    @JsonProperty("body")
    private String body;
    @JsonProperty("email")
    private String email;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getPostId() {
//        return postId;
//    }
//
//    public void setPostId(int postId) {
//        this.postId = postId;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    @Override
//    public String toString() {
//        return "ClassPojo [name = " + name + ", postId = " + postId + ", id = " + id + ", body = " + body + ", email = " + email + "]";
//    }
}

