package tests;

import com.google.gson.internal.bind.util.ISO8601Utils;
import framework.utils.APIUtils;
import framework.utils.PropertiesRead;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.models.*;
import pageObjects.responses.responsePosts;
import pageObjects.responses.responseUsers;

import java.util.ArrayList;

public class TC1 {
    static final Logger log = Logger.getLogger(TC1.class);
    private final String PAGE = PropertiesRead.readFromFrameworkConfig("page");
    private final int POST_ID_99 = 99;
    private final int POST_ID_150 = 150;
    private final int USER_ID_5 = 5;
    private final int SUCCESS_STATUS = 200;
    private final int EMPTY = 404;
    private Post examplePost = new Post(1,101,"AlexExample","example_body");
    private User userFive = new User(5,"Chelsey Dietrich", "Kamren", "Lucio_Hettinger@annie.ca",
            new Adresses("Skiles Walks", "Suite 351", "Roscoeview", "33263",
                    new Geos("-31.8129", "62.5342")),"(254)954-1289", "demarco.info",
            new Companies("Keebler LLC", "User-centric fault-tolerant solution", "revolutionize end-to-end systems"));


    @Test
    public void javaScriptPageTest() {
        ArrayList<Post> posts = responsePosts.getPosts(PAGE);
        log.info("Check if Post are ascending");
        Assert.assertEquals(SUCCESS_STATUS,APIUtils.getResponse(PAGE).getStatus(), "Bad request");
        Assert.assertTrue(responsePosts.isSorted(posts), "Posts is not correct or not sorted");
        Post testPost99 = responsePosts.getPost(PAGE, POST_ID_99);
        String title = testPost99.getTitle();
        String body = testPost99.getBody();
        log.info("Check if title and body are not empty");
        Assert.assertEquals(SUCCESS_STATUS,APIUtils.getResponse(PAGE).getStatus(), "Bad request");
        Assert.assertEquals(title.isEmpty(), body.isEmpty(), "Body or title is empty");
        Post testPost150 = responsePosts.getPost(PAGE, POST_ID_150);
        log.info("Check if Post " + POST_ID_150 + " is null");
        //Assert.assertEquals(EMPTY,APIUtils.getResponse(PAGE).getStatus(), "Bad request");
        Assert.assertNull(testPost150, "Post id=" + POST_ID_150 + " exists");
        APIUtils.postPost(PAGE, examplePost);
        Assert.assertEquals(SUCCESS_STATUS,APIUtils.getResponse(PAGE).getStatus(), "Bad request");
        //Assert.assertEquals(examplePost,responsePosts.getPost(PAGE, examplePost.getId()));
        ArrayList<User> users = responseUsers.getUsers(PAGE);
        Assert.assertEquals(SUCCESS_STATUS,APIUtils.getResponse(PAGE).getStatus(), "Bad request");
        User testUser = responseUsers.getUser(PAGE, 4);
        System.out.println(testUser);

        //Assert.assertEquals(userFive,testUser, "The data is different");
    }
}
