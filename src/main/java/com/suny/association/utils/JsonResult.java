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
 * Comments:   封装自己的返回JSON数据格式
 * Author:   孙建荣
 * Create Date: 2017/03/17 16:01
 */
public class JsonResult {
    
    private static final Gson GSON = new Gson();
    
    private static final JsonParser JSON_PARSER = new JsonParser();
    
    private static final Type MAP_TYPE = new TypeToken<Map<String, ?>>() {
    }.getType();
    
    private static final Type JSON_OBJECT_TYPE = new TypeToken<List<JsonObject>>() {
    }.getType();
    
    
    //  返回的状态
    private int status;
    
    //给前端返回的内容
    private String message;
    
    //返回给前端的数据
    private Object data;
    
    /**
     * 发送成功的结果还有返回数据
     *
     * @param enumObject 传过来的枚举值
     * @param resultData 返回的数据
     * @return 结果与及数据
     */
    public static JsonResult successResultAndData(Object enumObject, Object resultData) {
        JsonResult jsonResult = setStatusAndMessage(enumObject);
        jsonResult.setData(resultData);
        return jsonResult;
    }
    
    /**
     * 就返回一个成功的结果
     *
     * @param enumObject 传过来的枚举值
     * @return 仅仅只有成功的结果
     */
    public static JsonResult successResult(Object enumObject) {
        return setStatusAndMessage(enumObject);
    }
    
    /**
     * 就返回一个成功的结果
     *
     * @param enumObject 传过来的枚举值
     * @return 仅仅只有成功的结果
     */
    public static JsonResult failResult(Object enumObject) {
        return setStatusAndMessage(enumObject);
    }
    
    
    /**
     * 一个抽取出来的公共操作方法，用于设置响应的status跟message
     *
     * @param enumObject 传过来的枚举值
     * @return JSONResponseUtil实体
     */
    private static JsonResult setStatusAndMessage(Object enumObject) {
        JsonResult jsonResult = new JsonResult();
        //获取枚举值的toString方法后的字符值
        String errorMessage = enumObject.toString();
        
        // 返回的toString字符值中有一个状态码，下面把这个状态码抓取出来返回给前端
        int afterErrorCode = errorMessage.lastIndexOf(',');
        String errorCodeString = errorMessage.substring(5, afterErrorCode);
        int errorCodeNumber = Integer.parseInt(errorCodeString);
        
        // 设置返回给前端的状态码与及消息
        jsonResult.setStatus(errorCodeNumber);
        jsonResult.setMessage(errorMessage);
        return jsonResult;
    }
    
    
    /**
     * 将对象转换成Json字符串
     */
    public static String toJson(Object src) {
        return GSON.toJson(src);
    }
    
    /**
     * 将Json转换成对象
     */
    private static <T> T toEntity(String json, Class<T> classOfT) {
        return GSON.fromJson(json, classOfT);
    }
    
    /**
     * 将Json转化成Map
     */
    public static Map<String, ?> toMap(String json) {
        return GSON.fromJson(json, MAP_TYPE);
    }
    
    /**
     * 将Json字符串转化成List
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
     */
    public static JsonObject toJsonObject(String json) {
        return JSON_PARSER.parse(json).getAsJsonObject();
    }

    
    
    private JsonResult() {
    }
    
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }
}
