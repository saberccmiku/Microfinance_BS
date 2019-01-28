package com.saber.credit.web;

import com.saber.credit.bean.UserInfo;
import com.saber.credit.dao.UserInfoDao;
import com.saber.credit.util.MD5Helper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2019/1/16
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private UserInfoDao userInfoDao;
    @RequestMapping("/login")
    public String login(UserInfo user, Model model, HttpSession session) throws Exception {
        //获取用户名和密码
        String userId = user.getUserId();
        String password = user.getPassword();
        //从数据库中获取对用户名和密码后进行判断
        UserInfo userInfo = userInfoDao.queryByUserId(userId);
        if (userInfo!=null) {
            if (userInfo.getPassword().equals(MD5Helper.MD5Digest(password))) {
                //将用户对象添加到Session中
                session.setAttribute("USER_SESSION", user);
                //重定向到主页面的跳转方法
                return "redirect:/main/index";
            }
        }
        model.addAttribute("msg", "用户名或密码错误，请重新登录！");
        return "/login/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //清除session
        session.invalidate();
        //重定向到登录页面的跳转方法
       // return "redirect:login";
        return "/login/login";
    }

}
