package com.java.wx.mp.model;

import lombok.Data;

/**
 * @description: 微信通用接口凭证
 * @author: ws
 * @time: 2020/8/21 10:44
 */
@Data
public class AccessToken {
    //获取到的凭证
    private String token;
    //凭证有效时间，单位：秒
    private int expiresIn;

}
