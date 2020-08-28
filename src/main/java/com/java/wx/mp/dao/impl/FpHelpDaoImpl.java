package com.java.wx.mp.dao.impl;

import com.java.wx.mp.dao.FpHelpDao;
import com.java.wx.mp.model.FpHelp;
import com.java.wx.mp.util.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 描述
 * @author: ws
 * @time: 2020/8/25 9:29
 */
@Slf4j
@Repository
public class FpHelpDaoImpl implements FpHelpDao {
    @Resource
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<FpHelp> getAllErrorInfo(Page page, FpHelp fpHelp) {
        StringBuilder sql = new StringBuilder("select * from fp_help where 1=1 and is_available != '1'");
        Map<String, Object> parames = null; //用于具名函数调用sql
        Map<String, Object> map = concatSql(sql, fpHelp);
        sql = (StringBuilder) map.get("sql");   //得到带模糊检索的sql

        //先确定数据总条数、总页数
        Map<String, Object> countMap = null;

        List<FpHelp> query = namedParameterJdbcTemplate.query(sql.toString(), parames, new BeanPropertyRowMapper<>(FpHelp.class));
        return query;
    }

    private Map<String, Object> concatSql(StringBuilder sql, FpHelp fpHelp) {
        Map<String, Object> resultMap = new HashMap<>();
        if (StringUtils.isNotBlank(fpHelp.getKeyWord())) {
            sql.append(" and (errcode like '%" + fpHelp.getKeyWord() + "%' or errkeyword like '%" + fpHelp.getKeyWord() +
                "%' or errreason like '%" + fpHelp.getKeyWord() + "%' or solution like '%" + fpHelp.getKeyWord() + "%')");
        }
        resultMap.put("sql", sql);
        log.info("sql:{}", sql.toString());
        return resultMap;
    }
}
