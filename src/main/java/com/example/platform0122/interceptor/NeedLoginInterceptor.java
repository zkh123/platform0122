package com.example.platform0122.interceptor;

import com.example.platform0122.entity.User;
import com.example.platform0122.service.LoginService;
import com.example.platform0122.utils.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huanglijun on 2019/1/30
 */
public class NeedLoginInterceptor implements HandlerInterceptor {

    @Value("${mangeuser.cookiename}")
    private String MANGE_TOKEN;

    @Autowired
    private LoginService loginService;

    /**
     * 方法执行前
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        System.out.println("NeedLoginInterceptor 方法执行前");

        String contextPath = request.getContextPath();
        if (!StringUtils.isBlank(contextPath)){
            System.out.println(contextPath);
        }
        String token = CookieUtils.getCookieValue(request,MANGE_TOKEN);
        if (StringUtils.isBlank(token)){  //未登陆
            response.sendRedirect(request.getContextPath()+"/index.html");
            return false;
        }

        //获取用户数据
        User user = loginService.findUserByToken(token);
        if (user == null){
            //登陆过期
            response.sendRedirect(request.getContextPath() + "/index.html");
            return false;
        }

        //登陆成功，设置过期时间
        loginService.resetKeyTime(token);
        return true;
    }

    /**
     * 方法执行后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("NeedLoginInterceptor 方法执行后");
    }

    /**
     * 页面渲染前
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("NeedLoginInterceptor 页面渲染前");
    }
}
