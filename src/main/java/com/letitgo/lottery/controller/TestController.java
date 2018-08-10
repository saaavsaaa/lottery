package com.letitgo.lottery.controller;

import com.letitgo.lottery.service.spider.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by aaa on 2017/1/28.
 */
@RestController
public class TestController {

    @Autowired
    private SpiderService spiderService;

    @RequestMapping("/test")
    public  @ResponseBody String appAcountExperV6(HttpServletRequest request) throws Exception {
        return spiderService.test();
    }
}
