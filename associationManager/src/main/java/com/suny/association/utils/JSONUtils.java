package com.suny.association.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/08 19:40
 */
public class JSONUtils {
    /**
     * 将对象转换成Json字符串
     *
     * @param src
     * @return
     */
    public static String toJson(Object src) {
        return GSON.toJson(src);
    }

    /**
     * 将Json转换成对象
     *
     * @param json
     * @param classOfT
     * @return
     */
    public static <T> T toEntity(String json, Class<T> classOfT) {
        return GSON.fromJson(json, classOfT);
    }

    /**
     * 将Json转化成Map
     *
     * @param json
     * @return
     */
    public static Map<String, ?> toMap(String json) {
        return GSON.fromJson(json, MAP_TYPE);
    }

    /**
     * 将Json字符串转化成List
     *
     * @param json
     * @param typeOfT
     * @return
     */
    public static <T> List<T> toList(String json, Class<T> typeOfT) {
        List<JsonObject> jsonObjectList = GSON.fromJson(json, JSON_OBJECT_TYPE);
        List<T> list = new ArrayList<T>();
        for (JsonObject jsonObject : jsonObjectList) {
            list.add(toEntity(jsonObject.toString(), typeOfT));
        }
        return list;
    }

    /**
     * Json字符串转JsonObject
     *
     * @param json
     * @return
     */
    public static JsonObject toJsonObject(String json) {
        return JSON_PARSER.parse(json).getAsJsonObject();
    }

    /**
     * 将JsonObject转换成Json字符串
     *
     * @return
     */
    public static String toJson(JsonObject jsonObject) {
        return jsonObject.toString();
    }

    /**
     * 禁止调用无参构造
     *
     * @throws Exception
     */
    private JSONUtils() throws Exception {
        throw new Exception("Error...");
    }

    private static final Gson GSON = new Gson();

    private static final JsonParser JSON_PARSER = new JsonParser();

    private static final Type MAP_TYPE = new TypeToken<Map<String, ?>>() {
    }.getType();

    private static final Type JSON_OBJECT_TYPE = new TypeToken<List<JsonObject>>() {
    }.getType();

}
