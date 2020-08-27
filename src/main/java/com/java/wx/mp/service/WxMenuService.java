package com.java.wx.mp.service;

import net.sf.json.JSONObject;

import java.util.Map;

/**
 * @description: 描述
 * @author: ws
 * @time: 2020/8/21 10:27
 */

public interface WxMenuService {
    //查询菜单
    public JSONObject getMenu(String accessToken);
    //创建菜单
    public int createMenu(Map<String, Object> menu, String accessToken);
    //删除菜单
    public int deleteMenu(String accessToken);

}
