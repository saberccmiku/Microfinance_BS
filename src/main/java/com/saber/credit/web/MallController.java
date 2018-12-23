package com.saber.credit.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商城管理
 * Created by saber on 2018/12/13
 */
@Controller
@RequestMapping("mall")
public class MallController  {

    @RequestMapping("/goodsList")
    public String listPage() {
        return "mall/goodsList";
    }

}
