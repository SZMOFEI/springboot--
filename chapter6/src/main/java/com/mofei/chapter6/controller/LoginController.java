package com.mofei.chapter6.controller;

import com.mofei.chapter6.entity.User;
import com.mofei.chapter6.jpa.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author mofei
 * @date 2018/10/22 16:55
 */
@RestController
@RequestMapping(value = "/user")
public class LoginController {
    @Autowired
    private UserJpa userJpa;

    @RequestMapping(value = "/login")
    public String login(User user, HttpServletRequest request) {
        String result = "登陆成功";
        boolean flag = true;
        //你去查询一个用户回来，如果用户不存在，提示用户不存在，请重新登录
        Optional<User> user1 = userJpa.findOne(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"),user.getName()));
                return null;
            }
        });

        //1.查询用户不存在
        if (user1 == null) {
            flag= false;
            result = "用户不存在";
        }else if (!user1.get().getPassword().equals(user.getPassword())){
        //2.密码错误
            flag= false;
            result = "密码错误";
        }
        //3.登陆成功
        if (flag){
            request.setAttribute("_session_user",user1);
        }
        return result;
    }
}
