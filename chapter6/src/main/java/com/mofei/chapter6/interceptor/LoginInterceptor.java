package com.mofei.chapter6.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mofei
 * @date 2018/10/23 10:22
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        final String  loginUrI = "/user/login";
        final String  loginViewUrI = "/user/login_view";
        if (loginUrI.equals(httpServletRequest.getRequestURI())||loginViewUrI.equals(httpServletRequest.getRequestURI())){
            return true;
        }
        System.out.println("httpServletRequest.getRequestURI() = " + httpServletRequest.getRequestURI());
        System.out.println("httpServletRequest.getRequestURL() = " + httpServletRequest.getRequestURL());

        //验证session是否存在
        Object session_user = httpServletRequest.getSession().getAttribute("_session_user");
        if (session_user==null){
            httpServletResponse.sendRedirect("/user/login_view");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
