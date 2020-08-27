package com.java.wx.mp.dao;

import com.java.wx.mp.model.FpHelp;
import com.java.wx.mp.util.Page;

import java.util.List;

/**
 * @description: 描述
 * @author: ws
 * @time: 2020/8/25 9:26
 */

public interface FpHelpDao {
    /**
     * 获取FP报错详情列表
     * @param page
     * @param fpHelp
     * @return
     */
    List<FpHelp> getAllErrorInfo(Page page, FpHelp fpHelp);
}
