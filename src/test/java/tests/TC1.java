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
    private static final int POST_ID_99 = 99;
    private static final int POST_ID_150 = 150;

    @Test
    public void javaScriptPageTest() {
        ArrayList<Post> posts = responsePosts.getPosts(PAGE);
        log.info("Check if Post are ascending");
        Assert.assertTrue(responsePosts.isSorted(posts), "Posts is not correct or not sorted");
        Post testPost99 = responsePosts.getPost(PAGE, POST_ID_99);
        String title = testPost99.getTitle();
        String body = testPost99.getBody();
        log.info("Check if title and body are not empty");
        Assert.assertEquals(title.isEmpty(), body.isEmpty(), "Body or title is empty");
        Post testPost150 = responsePosts.getPost(PAGE, POST_ID_150);
        log.info("Check if Post " + POST_ID_150 + " is null");
        Assert.assertNull(testPost150, "Post id=" + POST_ID_150 + " exists");
    }
}
