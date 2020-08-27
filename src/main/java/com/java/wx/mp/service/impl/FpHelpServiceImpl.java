package com.java.wx.mp.service.impl;

import com.java.wx.mp.dao.FpHelpDao;
import com.java.wx.mp.model.FpHelp;
import com.java.wx.mp.service.FpHelpService;
import com.java.wx.mp.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 描述
 * @author: ws
 * @time: 2020/8/25 9:27
 */
@Service
public class FpHelpServiceImpl implements FpHelpService {
    @Autowired
    private FpHelpDao fpHelpDao;

    @Override
    public List<FpHelp> getAllErrorInfo(Page page, FpHelp fpHelp) {
        return fpHelpDao.getAllErrorInfo(page, fpHelp);
    }
}
