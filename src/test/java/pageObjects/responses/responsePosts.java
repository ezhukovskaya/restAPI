package pageObjects.responses;

import com.fasterxml.jackson.databind.ObjectMapper;
import framework.utils.APIUtils;
import pageObjects.models.Post;

import java.util.ArrayList;

public class responsePosts {
    private static final String POSTS = "posts/";

    public static ArrayList<Post> getUsers(String url) {
        url += POSTS;
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Post> posts = new ArrayList<Post>();
        for (int i = 0; i < APIUtils.getJsonNodeSize(url); i++) {
            try {
                posts.add(objectMapper.readValue(APIUtils.getJsonArray(url).getJSONObject(i).toString(), Post.class));
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return posts;
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
