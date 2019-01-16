package com.saber.credit.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interceptor
 * Created by Administrator on 2019/1/16
 */
public class CommonInterceptor implements HandlerInterceptor {
    Logger logger = Logger.getLogger(CommonInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //对浏览器的请求进行放行处理
        Object sessionObj = httpServletRequest.getSession().getAttribute("adminSession");
        if (sessionObj!=null){
            return true;
        }else {
            httpServletRequest.getRequestDispatcher("login/login").forward(httpServletRequest, httpServletResponse);
            httpServletRequest.getSession().setAttribute("adminSession","adminSession");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
