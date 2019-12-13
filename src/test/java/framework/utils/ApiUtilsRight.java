package framework.utils;

import com.google.gson.JsonArray;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;

public class ApiUtilsRight {
    public static JSONArray getResponse(String url){
        System.out.println(Unirest.get(url).asJson().getBody().toString());
        HttpResponse <JsonNode> jsonResponse =  Unirest.get(url).asJson();
        return jsonResponse.getBody().getArray();
    }
}
