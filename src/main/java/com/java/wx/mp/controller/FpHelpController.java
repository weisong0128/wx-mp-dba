package com.java.wx.mp.controller;

import com.java.wx.mp.model.FpHelp;
import com.java.wx.mp.service.FpHelpService;
import com.java.wx.mp.util.Page;
import com.java.wx.mp.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: FP咨询接口
 * @author: ws
 * @time: 2020/8/24 15:53
 */
@Slf4j
@RestController
@RequestMapping("/wx/help/")
public class FpHelpController {
    @Autowired
    private FpHelpService fpHelpService;

    @GetMapping("getAllErrorInfo")
    public Response getAllErrorInfo(Page page, String keyWord) {
        FpHelp fp = new FpHelp(keyWord);
        return Response.ok(fpHelpService.getAllErrorInfo(page, fp), page);
    }

}
