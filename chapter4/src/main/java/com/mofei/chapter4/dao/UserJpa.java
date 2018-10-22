package com.mofei.chapter4.dao;

import com.mofei.chapter4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author mofei
 * @date 2018/9/29 18:41
 */
public interface UserJpa extends   JpaRepository<User,Long>,JpaSpecificationExecutor<User>, Serializable {
}
