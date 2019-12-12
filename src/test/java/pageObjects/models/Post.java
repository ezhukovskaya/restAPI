package pageObjects.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

public class Post {
    static final Logger log = Logger.getLogger(Post.class);
    @JsonProperty("userId")
    @Getter
    @Setter
    private int userId;
    @JsonProperty("id")
    @Getter
    @Setter
    private int id;
    @JsonProperty("title")
    @Getter
    @Setter
    private String title;
    @JsonProperty("body")
    @Getter
    @Setter
    private String body;

    public Post() {
    }

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        log.info("creating String from JSON object");
        return "User[userID:" + userId + ", ID: " + id + ", Title: " + title + ", Body: " + body;
    }
}
