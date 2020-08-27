package com.java.wx.mp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @description: spring web启动入口
 * @author: ws
 * @time: 2020/4/21 15:13
 */
//@EnableScheduling   //启动时执行定时任务一次
@SpringBootApplication
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}
