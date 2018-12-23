package com.saber.credit.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by saber on 2018/11/22
 */
@Controller
@RequestMapping("/console")
public class ConsoleController {

    @RequestMapping("/index")
    public String console() {
        return "console/console";
    }


}
