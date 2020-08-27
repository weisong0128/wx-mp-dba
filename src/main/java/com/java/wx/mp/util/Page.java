package com.java.wx.mp.util;

import lombok.Data;

/**
 * @description: 分页实体类
 * @author: ws
 * @time: 2020/8/24 15:59
 */
@Data
public class Page {
    private static final long serialVersionUID = 1L;
    //总数据条数
    private int totalRows;
    //每页条数
    private int pageSize;
    //页码
    private int pageNo;
    private static final int NUMBER_20 = 20;

    public Page() {
        this.totalRows = 0;
        this.pageSize = NUMBER_20;
        this.pageNo = 1;    //默认查询第一页，即首页
    }

    public Page(int pn, int ps) {
        this.totalRows = 0;
        this.pageSize = ps;
        this.pageNo = pn;
    }

    public Page(int pn, int ps, int tr) {
        this.totalRows = tr;
        this.pageSize = ps;
        this.pageNo = pn;
    }

}
