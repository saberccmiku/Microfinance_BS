package com.saber.credit.web;

import com.saber.credit.bean.UserInfo;
import com.saber.credit.dao.UserInfoDao;
import com.saber.credit.util.JsonHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by saber on 2018/12/27
 */
@Controller
@RequestMapping("purview")
public class PurviewController {

    Logger logger = Logger.getLogger(PurviewController.class);

    @Autowired
    private UserInfoDao userInfoDao;

    @RequestMapping("/employeeList")
    public ModelAndView listPage() throws Exception {
        ModelAndView modelAndView = new ModelAndView("purview/employeeList");
        List<UserInfo> userInfoList =userInfoDao.queryList();
        Map<String, Object> map = new HashMap<>();
        map.put("users", JsonHelper.toJsonString(userInfoList));
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping("/dialog")
    public ModelAndView OpenDialog() {
        return new ModelAndView("purview/dialog");
    }

    @RequestMapping("/addUser")
    public Integer addUser(UserInfo user, Model model, HttpSession session){
        logger.info("user:"+JsonHelper.toJsonString(user));
        logger.info("session:"+JsonHelper.toJsonString(session));
        return null;
    }

    @RequestMapping("/updateUser")
    public Integer Update(UserInfo user){
        return null;

    }

    //请求的路径，方式
    @RequestMapping(value = "v1.0/new/{teamname}", method = RequestMethod.POST)
    @ResponseBody
    public List<UserInfo> userInfoList(@PathVariable String teamname, HttpServletRequest request) throws Exception {
        //可以使用teamname获取url路径分隔
        //获取请求的参数
        String id = request.getParameter("id");
        request.getSession().setAttribute("USER_SESSION","admin");
        return userInfoDao.queryList();
    }

}
