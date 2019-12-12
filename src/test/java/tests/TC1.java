package tests;

import framework.utils.PropertiesRead;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.models.Post;
import pageObjects.responses.responsePosts;

import java.util.ArrayList;

public class TC1 {
    static final Logger log = Logger.getLogger(TC1.class);
    private static final String PAGE = PropertiesRead.readFromFrameworkConfig("page");
    private static final int POST_ID = 99;

    @Test
    public void javaScriptPageTest() {
        ArrayList<Post> posts = responsePosts.getPosts(PAGE);
        log.info("Check if Post are ascending");
        Assert.assertTrue(responsePosts.isSorted(posts), "Posts is not correct or not sorted");
        Post testPost = responsePosts.getPost(PAGE, POST_ID);
        Assert.assertNotNull(testPost.getTitle(), "Title or Body is empty");
    }

}
