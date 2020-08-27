package com.java.wx.mp.controller;

import com.java.wx.mp.service.WxProtalService;
import com.java.wx.mp.util.MessageUtil;
import com.java.wx.mp.util.SignUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description: wx token验证、接收消息接口
 * @author: ws
 * @time: 2020/8/20 16:19
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/wx/portal/{appid}")
public class WxProtalController {
    @Autowired
    private WxProtalService wxProtalService;

    //验证是否来自微信服务器的消息
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String authGet(@PathVariable String appid,
                          @RequestParam(name = "signature", required = false) String signature,
                          @RequestParam(name = "timestamp", required = false) String timestamp,
                          @RequestParam(name = "nonce", required = false) String nonce,
                          @RequestParam(name = "echostr", required = false) String echostr) {

        log.info("接收到来自微信服务器的认证消息：[{}, {}, {}, {}, {}]",
                appid, signature, timestamp, nonce, echostr);
        if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
            throw new IllegalArgumentException("请求参数非法，请核实！");
        }

        /*if (!this.wxService.switchover(appid)) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appid));
        }*/

        //连接wx验证token
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            log.info("验证通过");
            return echostr;
        }

        log.error("验证失败");
        return "token错误，请求失败";
    }

    /**
     * 处理接收到的请求
     * @param req
     * @return 返回xml格式数据
     */
    @PostMapping(produces = "application/xml; charset=UTF-8")
    public String post(HttpServletRequest req) {

        // 解析得到的xml请求
        /*try {
            Map<String, String> requestMap = MessageUtil.parseXml(req);
            String content = requestMap.get("Content");
            log.info("content=" + content);

        } catch (Exception e) {
            e.printStackTrace();
        }*/

        String respMessage = wxProtalService.processRequest(req);
        log.info("respMessage=\n" + respMessage);
        return respMessage;
    }

}
