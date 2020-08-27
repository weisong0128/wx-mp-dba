package com.java.wx.mp.util;

import lombok.Data;

/**
 * @description: 以JSON数据格式响应Http请求
 * @author: ws
 * @time: 2020/8/24 16:10
 */
@Data
public class Response {
    private static final int CODE_SUCCESS = 0;
    private static final int CODE_ERROR = -1;
    private static final String MSG_SUCCESS = "操作成功";
    private static final String MSG_ERROR = "操作失败";

    private int code = CODE_SUCCESS;
    private String msg;
    private Object data;
    private Page page;

    private Response() {}

    private Response(int code, String msg, Object data, Page page) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.page = page;
    }

    //成功接口
    public static Response ok() {
        return new Response(CODE_SUCCESS, MSG_SUCCESS, null, null);
    }

    public static Response ok(Object data) {
        return new Response(CODE_SUCCESS, MSG_SUCCESS, data, null);
    }

    public static Response ok(Object data, Page page) {
        return new Response(CODE_SUCCESS, MSG_SUCCESS, data, page);
    }

    public static Response ok(String message, Object data, Page page) {
        return new Response(CODE_SUCCESS, message, data, page);
    }

    //失败接口
    public static Response error() { return new Response(CODE_ERROR, MSG_ERROR, null, null); }

    public static Response error(Object data) { return new Response(CODE_ERROR, MSG_ERROR, data, null); }

    public static Response error(Object data, Page page) { return new Response(CODE_ERROR, MSG_ERROR, data, page); }

    public static Response error(String message, Object data, Page page) {
        return new Response(CODE_ERROR, message, data, page);
    }

}
