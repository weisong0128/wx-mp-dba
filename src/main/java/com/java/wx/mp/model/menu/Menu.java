package com.java.wx.mp.model.menu;

import lombok.Data;

import java.security.Timestamp;

/**
 * @description: 描述
 * @author: ws
 * @time: 2020/8/21 11:20
 */
@Data
public class Menu {
    private String id;

    private String accountId;

    private String parentId;

    private String parentName;

    private String name;

    private String type;

    private String key;

    private String url;

    private Integer sort;

    private String createdBy;

    private Timestamp createdTime;

}
