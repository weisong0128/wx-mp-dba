package com.java.wx.mp.service;

import com.java.wx.mp.model.FpHelp;
import com.java.wx.mp.util.Page;

import java.util.List;

/**
 * @description: 描述
 * @author: ws
 * @time: 2020/8/25 9:21
 */

public interface FpHelpService {
    /**
     * 获取FP报错详情列表
     * @param page
     * @param fpHelp：传参
     * @return
     */
    List<FpHelp> getAllErrorInfo(Page page, FpHelp fpHelp);
}
