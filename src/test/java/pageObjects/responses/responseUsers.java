package pageObjects.responses;

import com.fasterxml.jackson.databind.ObjectMapper;
import framework.utils.APIUtils;
import org.apache.log4j.Logger;
import pageObjects.models.Post;
import pageObjects.models.User;

import java.util.ArrayList;

public class responseUsers {
    private static final String USERS = "users/";
    static final Logger log = Logger.getLogger(responseUsers.class);

    public static ArrayList<User> getUsers(String url) {
        url += USERS;
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<User> posts = new ArrayList<User>();
        log.info("Adding JSON objects into the array");
        for (int i = 0; i < APIUtils.getResponse(url).getBody().getArray().length(); i++) {
            try {
                posts.add(objectMapper.readValue(APIUtils.getResponse(url).getBody().getArray().getJSONObject(i).toString(), User.class));
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return posts;
    }

    public static User getUser(String url, int id) {
        url += USERS;
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("Taking " + id + " JSON object");
        try {
            return objectMapper.readValue(APIUtils.getResponse(url).getBody().getArray().getJSONObject(id).toString(), User.class);
        }catch(Exception e) {
            e.getMessage();
        }
        return null;
    }
}
