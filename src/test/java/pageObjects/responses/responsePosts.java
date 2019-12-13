package pageObjects.responses;

import com.fasterxml.jackson.databind.ObjectMapper;
import framework.utils.APIUtils;
import org.apache.log4j.Logger;
import pageObjects.models.Post;

import java.util.ArrayList;

public class responsePosts {
    private static final String POSTS = "posts/";
    static final Logger log = Logger.getLogger(responsePosts.class);

    public static ArrayList<Post> getPosts(String url) {
        url += POSTS;
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Post> posts = new ArrayList<Post>();
        log.info("Adding JSON objects into the array");
        for (int i = 0; i < APIUtils.getResponse(url).getBody().getArray().length(); i++) {
            try {
                posts.add(objectMapper.readValue(APIUtils.getResponse(url).getBody().getArray().getJSONObject(i).toString(), Post.class));
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return posts;
    }

    public static Post getPost(String url, int id) {
        url += POSTS;
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("Taking " + id + " JSON object");
        try {
            return objectMapper.readValue(APIUtils.getResponse(url).getBody().getArray().getJSONObject(id).toString(), Post.class);
        }catch(Exception e) {
            e.getMessage();
        }
        return null;
    }

    public static boolean isSorted(ArrayList<Post> posts) {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId() < posts.get(i + 1).getId()) {
                return true;
            }
        }
        return false;
    }
}
