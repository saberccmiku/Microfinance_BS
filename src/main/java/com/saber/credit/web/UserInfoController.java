package com.saber.credit.web;


import com.saber.credit.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by saber on 2018/11/22
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Resource
    private UserInfoService service;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/console")
    public String console() {
        return "console";
    }


}
