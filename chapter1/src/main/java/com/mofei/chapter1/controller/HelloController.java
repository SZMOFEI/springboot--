package com.mofei.chapter1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mofei
 * @date 2018/9/29 14:43
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String a (){
        return "hello world" ;
    }
}
