package com.java.wx.mp.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 描述
 * @author: ws
 * @time: 2020/8/20 16:21
 */

public interface WxProtalService {
    //校验wx服务器传参是否一致
//    public boolean checkSignature(String var1, String var2, String var3);

    //处理请求
    public String processRequest(HttpServletRequest request) ;
}
