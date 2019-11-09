package com.example.nigma;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {
    JSONObject parse (String result){
        try {
            return new JSONObject(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
