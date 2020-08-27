package com.java.wx.mp.thread;

import com.java.wx.mp.model.AccessToken;
import com.java.wx.mp.util.WeixinUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description: 定时获取wx全局接口调用凭据access_token
 * @author: ws
 * @time: 2020/8/21 11:03
 */
@Slf4j
@Component
public class AccessTokenThread {

    //第三方用户唯一凭证
    public static String appid = "wxa1af19f510ca27bc";
    //第三方用户唯一凭证密钥
    public static String appsecret = "2913c9da9f638cb731c9fe88f4446cc8";
    //封装access_token
    public static AccessToken accessToken = null;

    @Scheduled(fixedDelay = 2*3600*1000)    //7200秒执行一次
    public static String getToken() {
        accessToken = WeixinUtil.getAccessToken(appid, appsecret);
        if (null != accessToken) {
            log.info("获取成功，accessToken:" + accessToken.getToken());
        } else {
            log.error("获取token失败");
        }

        return accessToken.getToken();

    }

}
