package framework.utils;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import org.apache.log4j.Logger;

public class APIUtils {
    static final Logger log = Logger.getLogger(APIUtils.class);
    public static int getJsonNodeSize(String url){
        log.info("getting JSON objects amount");
        HttpResponse<JsonNode> jsonResponse = Unirest.get(url).asJson();
        return jsonResponse.getBody().getArray().length();
    }

    public static JSONArray getJsonArray(String url){
        log.info("getting JSON objects array");
        HttpResponse<JsonNode> jsonResponse = Unirest.get(url).asJson();
        return jsonResponse.getBody().getArray();
    }
}
