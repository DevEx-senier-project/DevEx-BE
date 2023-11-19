package com.DevEx.DevExBE.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Convertor {

    public static JsonObject stringToJsonObject(String contentAsString) {
        return (JsonObject) JsonParser.parseString(contentAsString);
    }

    public static String getCode(JsonObject jsonObject) {
        return jsonObject.get("code").getAsString();
    }

}
