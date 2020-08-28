package com.java.wx.mp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 小叮当-FP报错搜索页
 * @author: ws
 * @time: 2020/8/24 15:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FpHelp {
    //错误编码
    private String errCode;
    //错误关键词
    private String errKeyWord;
    //错误原因
    private String errReason;
    //处理方法
    private String solution;
    //标识是否删除（0：可用，1：删除）
    private String isAvailbale;
    //修改时间
    private String updateTime;
    //查询关键字
    private String keyWord;

    public FpHelp(String keyWord) {
        this.keyWord = keyWord;
    }

}
