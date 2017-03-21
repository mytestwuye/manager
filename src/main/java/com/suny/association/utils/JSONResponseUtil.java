package com.suny.association.utils;

/**
 * Comments:   封装自己的返回JSON数据格式
 * Author:   孙建荣
 * Create Date: 2017/03/17 16:01
 */
public class JSONResponseUtil {
    
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
    public static JSONResponseUtil responseSuccessResultAndResultData(Object enumObject, Object resultData) {
        JSONResponseUtil jsonResponseUtil = setStatusAndMessage(enumObject);
        jsonResponseUtil.setData(resultData);
        return jsonResponseUtil;
    }
    
    /**
     * 就返回一个成功的结果
     *
     * @param enumObject 传过来的枚举值
     * @return 仅仅只有成功的结果
     */
    public static JSONResponseUtil responseSuccessResult(Object enumObject) {
        return setStatusAndMessage(enumObject);
    }
    
    /**
     * 就返回一个成功的结果
     *
     * @param enumObject 传过来的枚举值
     * @return 仅仅只有成功的结果
     */
    public static JSONResponseUtil responseFailResult(Object enumObject) {
        return setStatusAndMessage(enumObject);
    }
    
    
    /**
     * 一个抽取出来的公共操作方法，用于设置响应的status跟message
     *
     * @param enumObject 传过来的枚举值
     * @return JSONResponseUtil实体
     */
    private static JSONResponseUtil setStatusAndMessage(Object enumObject) {
        JSONResponseUtil jsonResponseUtil = new JSONResponseUtil();
        //获取枚举值的toString方法后的字符值
        String errorMessage = enumObject.toString();
        
        // 返回的toString字符值中有一个状态码，下面把这个状态码抓取出来返回给前端
        int afterErrorCode = errorMessage.lastIndexOf(',');
        String errorCodeString = errorMessage.substring(5, afterErrorCode);
        int errorCodeNumber = Integer.parseInt(errorCodeString);
        
        // 设置返回给前端的状态码与及消息
        jsonResponseUtil.setStatus(errorCodeNumber);
        jsonResponseUtil.setMessage(errorMessage);
        return jsonResponseUtil;
    }
    
    
    private JSONResponseUtil() {
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
