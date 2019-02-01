package com.saber.credit.web;

import com.saber.credit.bean.UserInfo;
import com.saber.credit.dao.UserInfoDao;
import com.saber.credit.util.Constant;
import com.saber.credit.util.JsonHelper;
import com.saber.credit.util.MD5Helper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
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
        List<UserInfo> userInfoList = userInfoDao.queryList();
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
    public Integer addUser(UserInfo user, Model model, HttpSession session) {
        logger.info("user:" + JsonHelper.toJsonString(user));
        logger.info("session:" + JsonHelper.toJsonString(session));
        return null;
    }

    @RequestMapping(value = "app/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object>  register(UserInfo user, Model model, HttpServletRequest request) throws NoSuchAlgorithmException {
        logger.info("user------------------------------:" + JsonHelper.toJsonString(user));
        user.setCreateDate(new Date());
        user.setCreateUser(user.getUserId());
        user.setPassword(MD5Helper.MD5Digest(user.getPassword()));
        Map<String,Object> map = new HashMap<>();
        int statusCode;
        try {
            if (userInfoDao.queryByUserId(user.getUserId())!=null){
                statusCode = Constant.dbCode;
                map.put("msg","该用户已存在");
            }else {
                if (userInfoDao.insert(user)>0){
                    statusCode = Constant.successCode;
                    map.put("msg","注册成功");
                }else {
                    statusCode = Constant.dbCode;
                    map.put("msg","注册失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            statusCode =3;
            map.put("msg",e.getMessage());
        }
        map.put("statusCode",statusCode);
        return map;
    }

    @RequestMapping("/updateUser")
    public Integer Update(UserInfo user) {
        return null;

    }


}
