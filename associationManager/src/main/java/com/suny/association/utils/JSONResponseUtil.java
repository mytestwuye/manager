package com.suny.association.utils;

/**
 * Comments:   封装自己的返回JSON数据格式
 * Author:   孙建荣
 * Create Date: 2017/03/17 16:01
 */
public class JSONResponseUtil {
    
    //  返回的状态
    private int status;
    //返回的数据
    private Object data;
    //给前端返回的数据
    private String desc;
    
    /**
     *  向客户端返回请求的结果
     * @param data  结果集
     * @return   JSON格式的数据
     */
    public static JSONResponseUtil success(Object data){
        JSONResponseUtil jsonResponseUtil = new JSONResponseUtil();
        jsonResponseUtil.setStatus(1);
        jsonResponseUtil.setData(data);
        return jsonResponseUtil;
    }
    
    /**
     *  向客户端返回请求的结果
     * @param desc  消息内容
     * @return   JSON格式的数据
     */
    public static JSONResponseUtil successMessage(String desc){
        JSONResponseUtil jsonResponseUtil = new JSONResponseUtil();
        jsonResponseUtil.setStatus(1);
        jsonResponseUtil.setDesc(desc);
        return jsonResponseUtil;
    }
    
    /**
     *  向客户端返回错误的信息
     * @param desc   错误的信息
     * @return    出错的原因
     */
    public static JSONResponseUtil error(String desc){
        JSONResponseUtil jsonResponseUtil = new JSONResponseUtil();
        jsonResponseUtil.setStatus(0);
        jsonResponseUtil.setDesc(desc);
        return jsonResponseUtil;
    }
    
    
    
    public JSONResponseUtil() {
    }
    
    public JSONResponseUtil(int status, Object data, String desc) {
        this.status = status;
        this.data = data;
        this.desc = desc;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    @Override
    public String toString() {
        return "JSONResponseUtil{" +
                "status=" + status +
                ", data=" + data +
                ", desc='" + desc + '\'' +
                '}';
    }
}
