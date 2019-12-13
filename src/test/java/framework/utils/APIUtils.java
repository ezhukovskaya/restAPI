package framework.utils;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.apache.log4j.Logger;
import pageObjects.models.Post;

public class APIUtils {
    private static final String CREATE = "create/";
    static final Logger log = Logger.getLogger(APIUtils.class);
    public static int getJsonNodeSize(String url){
        log.info("getting JSON objects amount");
        HttpResponse<JsonNode> jsonResponse = Unirest.get(url).asJson();
        return jsonResponse.getBody().getArray().length();
    }

    public static HttpResponse<JsonNode> getResponse(String url){
        System.out.println(Unirest.get(url).asJson().getBody().toString());
        return Unirest.get(url).asJson();
    }

    public static void postPost(String url, Post post){
        url+=CREATE;
        Unirest.post(url).body(post.toString()).asJson();
    }
}
