package com.mofei.chapter6.jpa;

import com.mofei.chapter6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author mofei
 * @date 2018/10/22 20:21
 */
public interface UserJpa extends JpaRepository<User,Long>,JpaSpecificationExecutor<User>,Serializable {
}
