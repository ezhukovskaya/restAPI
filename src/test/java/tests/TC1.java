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

    @Test
    public void javaScriptPageTest() {
        ArrayList <Post> posts = responsePosts.getUsers(PAGE);
        log.info("Check if Post are ascending");
        Assert.assertTrue(responsePosts.isSorted(posts));
    }

}
