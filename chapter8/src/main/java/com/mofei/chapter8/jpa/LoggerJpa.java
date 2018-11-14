package com.mofei.chapter8.jpa;

import com.mofei.chapter8.entity.LoggerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mofei
 * @date 2018/11/14 20:05
 */
public interface LoggerJpa extends JpaRepository<LoggerInfo,Long> {
}
