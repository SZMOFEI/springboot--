package com.mofei.chapter3.controller;

import com.mofei.chapter3.dao.UserJpa;
import com.mofei.chapter3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author mofei
 * @date 2018/9/29 18:39
 */
@RequestMapping("/user")
@RestController
public class JpaController {
    @Autowired
    private UserJpa userJpa;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<User> testList(){
        List<User> users = userJpa.findAll();
        return users;
    }
    @RequestMapping("/delete")
    public List<User> delete(Long id) {
        userJpa.deleteById(id);
        return testList();
    }
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public List<User> testSave(User u ){
        userJpa.save(u);
        return testList();
    }
    @RequestMapping("/update")
    public void update(User u) {
        userJpa.save(u);
    }


}
