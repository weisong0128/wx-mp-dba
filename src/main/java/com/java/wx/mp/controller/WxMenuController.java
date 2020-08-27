package com.java.wx.mp.controller;

import com.java.wx.mp.model.menu.Menu;
import com.java.wx.mp.service.WxMenuService;
import com.java.wx.mp.thread.AccessTokenThread;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: wx菜单接口
 * @author: ws
 * @time: 2020/8/21 10:24
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("wx/menu/")
public class WxMenuController {
    @Autowired
    private WxMenuService wxMenuService;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String getMenu() {
        //调用接口获取access_token
        String accessToken = AccessTokenThread.getToken();
        JSONObject jsonObject = null;
        if (null != accessToken) {
            //调用接口查询菜单
            jsonObject = wxMenuService.getMenu(accessToken);
            //判断菜单创建结果
            return String.valueOf(jsonObject);
        }

        log.info("accessToken值为：{}", accessToken);
        return "无数据";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public int createMenu() {
        //调用接口获取access_token
        String accessToken = AccessTokenThread.getToken();
        int result = 0;
        if (null != accessToken) {
            //调用接口创建菜单
            result = wxMenuService.createMenu(getFirstMenu(), accessToken);
            //判断菜单创建结果
            if (0 == result) {
                log.info("菜单创建成功！");
            } else {
                log.info("菜单创建失败，错误码：" + result);
            }
        }
        return result;
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public int deleteMenu() {
        //调用接口获取access_token
        String accessToken = AccessTokenThread.getToken();
        int result = 0;
        if (null != accessToken) {
            //删除菜单
            result = wxMenuService.deleteMenu(accessToken);
            //判断菜单删除结果
            if (0 == result) {
                log.info("菜单删除成功");
            } else {
                log.info("菜单删除失败，错误码：" + result);
            }
        }
        return result;
    }

    /**
     * 组装菜单数据
     */
    public static Map<String, Object> getFirstMenu(){
        //第一栏菜单
        Menu menu1=new Menu();
        menu1.setId("1");
        menu1.setName("信息类");
        menu1.setType("click");
        menu1.setKey("1");

        Menu menu11=new Menu();
        menu11.setId("11");
        menu11.setName("安装包获取方式");
        menu11.setType("click");
        menu11.setKey("11");

        Menu menu12=new Menu();
        menu12.setId("12");
        menu12.setName("相关文档");
        menu12.setType("click");
        menu12.setKey("12");

        Menu menu13=new Menu();
        menu13.setId("13");
        menu13.setName("工具包获取方式");
        menu13.setType("click");
        menu13.setKey("13");

        //第二栏
        Menu menu2=new Menu();
        menu2.setId("2");
        menu2.setName("工单类");
        menu2.setType("click");
        menu2.setKey("2");

        Menu menu21=new Menu();
        menu21.setId("21");
        menu21.setName("需求单");
        menu21.setType("click");
        menu21.setKey("21");

        Menu menu22=new Menu();
        menu22.setId("22");
        menu22.setName("运维工单");
        menu22.setType("click");
        menu22.setKey("22");

        Menu menu23=new Menu();
        menu23.setId("23");
        menu23.setName("问题反馈");
        menu23.setType("click");
        menu23.setKey("23");

        //第二栏
        Menu menu3=new Menu();
        menu3.setId("3");
        menu3.setName("咨询类");
        menu3.setType("click");
        menu3.setKey("3");

        Menu menu31=new Menu();
        menu31.setId("31");
        menu31.setName("DBMS & NoSQL");
        menu31.setType("view");
        menu31.setUrl("http://www.baidu.com");
        menu31.setKey("31");

        Menu menu32=new Menu();
        menu32.setId("32");
        menu32.setName("F-Pointer");
        menu32.setType("click");
        menu32.setKey("32");

        Menu menu33=new Menu();
        menu33.setId("33");
        menu33.setName("联系方式");
        menu33.setType("click");
        menu33.setKey("33");

        //最外一层大括号
        Map<String, Object> wechatMenuMap = new HashMap<String, Object>();

        //包装button的List
        List<Map<String, Object>> wechatMenuMapList = new ArrayList<Map<String, Object>>();

        //包装第一栏
        Map<String, Object> menuMap1 = new HashMap<String, Object>();
        Map<String, Object> menuMap11 = new HashMap<String, Object>();
        Map<String, Object> menuMap12 = new HashMap<String, Object>();
        Map<String, Object> menuMap13 = new HashMap<String, Object>();
        List<Map<String, Object>> subMenuMapList1 = new ArrayList<Map<String, Object>>();


        //第一栏第一个
        menuMap11.put("name",menu11.getName());
        menuMap11.put("type",menu11.getType());
        menuMap11.put("key",menu11.getKey());
        subMenuMapList1.add(menuMap11);

        //第一栏第二个
        menuMap12.put("name",menu12.getName());
        menuMap12.put("type",menu12.getType());
        menuMap12.put("key",menu12.getKey());
        subMenuMapList1.add(menuMap12);

        //第一栏第三个
        menuMap13.put("name",menu13.getName());
        menuMap13.put("type",menu13.getType());
        menuMap13.put("key",menu13.getKey());
        subMenuMapList1.add(menuMap13);

        menuMap1.put("name",menu1.getName());
        menuMap1.put("sub_button",subMenuMapList1);

        //包装第二栏
        Map<String, Object> menuMap2 = new HashMap<String, Object>();
        Map<String, Object> menuMap21 = new HashMap<String, Object>();
        Map<String, Object> menuMap22 = new HashMap<String, Object>();
        Map<String, Object> menuMap23 = new HashMap<String, Object>();
        List<Map<String, Object>> subMenuMapList2 = new ArrayList<Map<String, Object>>();

        //第二栏第一个
        menuMap21.put("name",menu21.getName());
        menuMap21.put("type",menu21.getType());
        menuMap21.put("key",menu21.getKey());
        subMenuMapList2.add(menuMap21);

        menuMap22.put("name",menu22.getName());
        menuMap22.put("type",menu22.getType());
        menuMap22.put("key",menu22.getKey());
        subMenuMapList2.add(menuMap22);

        menuMap23.put("name",menu23.getName());
        menuMap23.put("type",menu23.getType());
        menuMap23.put("key",menu23.getKey());
        subMenuMapList2.add(menuMap23);

        menuMap2.put("name",menu2.getName());
        menuMap2.put("sub_button",subMenuMapList2);

        //包装第三栏
        Map<String, Object> menuMap3 = new HashMap<String, Object>();
        Map<String, Object> menuMap31 = new HashMap<String, Object>();
        Map<String, Object> menuMap32 = new HashMap<String, Object>();
        Map<String, Object> menuMap33 = new HashMap<String, Object>();
        List<Map<String, Object>> subMenuMapList3 = new ArrayList<Map<String, Object>>();

        menuMap31.put("name",menu31.getName());
        menuMap31.put("type",menu31.getType());
        menuMap31.put("key",menu31.getKey());
        menuMap31.put("url",menu31.getUrl());
        subMenuMapList3.add(menuMap31);

        menuMap32.put("name",menu32.getName());
        menuMap32.put("type",menu32.getType());
        menuMap32.put("key",menu32.getKey());
        subMenuMapList3.add(menuMap32);

        menuMap33.put("name",menu33.getName());
        menuMap33.put("type",menu33.getType());
        menuMap33.put("key",menu33.getKey());
        subMenuMapList3.add(menuMap33);

        menuMap3.put("name",menu3.getName());
        menuMap3.put("sub_button",subMenuMapList3);

        wechatMenuMapList.add(menuMap1);
        wechatMenuMapList.add(menuMap2);
        wechatMenuMapList.add(menuMap3);
        wechatMenuMap.put("button",wechatMenuMapList);
        return  wechatMenuMap;
    }

}
