package com.saber.credit.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by saber on 2018/11/22
 */
@Controller
@RequestMapping("main")
public class MainController {
    @RequestMapping("index")
    public String index() {
        return "main/index";
    }

}
