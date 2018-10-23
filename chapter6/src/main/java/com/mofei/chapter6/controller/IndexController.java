package com.mofei.chapter6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author mofei
 * @date 2018/10/23 10:19
 */
@Controller
@RequestMapping(value = "/user")
public class IndexController {
    @RequestMapping(value = "/login_view" ,method = RequestMethod.GET)
    public String login_view() {
        return "login";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
