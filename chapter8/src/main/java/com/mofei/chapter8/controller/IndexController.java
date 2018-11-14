package com.mofei.chapter8.controller;

import com.alibaba.fastjson.JSONObject;
import com.mofei.chapter8.util.LoggerUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mofei
 * @date 2018/11/14 20:51
 */
@RestController
@RequestMapping(value = "/index")
public class IndexController {

    /**
     * 请求登陆
     * @param request
     */
    @RequestMapping(value = "/login")
    public JSONObject String (HttpServletRequest request, String name) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg","用户名:"+name+"登陆成功");
        request.setAttribute(LoggerUtils.LOGGER_RETURN,jsonObject);
        return jsonObject;
    }

}
