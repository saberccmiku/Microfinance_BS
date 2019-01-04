package com.saber.credit.web;

import com.saber.credit.bean.UserInfo;
import com.saber.credit.util.JsonHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by saber on 2018/12/27
 */
@Controller
@RequestMapping("purview")
public class PurviewController {
    @RequestMapping("/employeeList")
    public ModelAndView listPage() {
        ModelAndView modelAndView = new ModelAndView("purview/employeeList");
        Map<String,Object> map = new HashMap<>();
        UserInfo userInfo = new UserInfo();
        userInfo.setName("测试");
        map.put("user", JsonHelper.toJsonString(userInfo));
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping("/dialog")
    public ModelAndView OpenDialog() {
        return new ModelAndView("purview/dialog");
    }

}
