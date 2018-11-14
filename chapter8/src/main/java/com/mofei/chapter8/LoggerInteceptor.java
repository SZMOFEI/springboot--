package com.mofei.chapter8;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mofei.chapter8.entity.LoggerInfo;
import com.mofei.chapter8.jpa.LoggerJpa;
import com.mofei.chapter8.util.LoggerUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author mofei
 * @date 2018/11/14 20:06
 */
public class LoggerInteceptor implements HandlerInterceptor {
    private static final String LOGGER_SEND_TIME = "log_send_time";
    private static final String LOGGER_ENTITY = "log_entity";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LoggerInfo log = new LoggerInfo();
        log.setAliSessionId(request.getRequestedSessionId());
        log.setAliUri(request.getRequestURI());
        String paramData = JSON.toJSONString(request.getParameterMap(), SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue);
        log.setAliParamData(paramData);
        log.setAliClientIp(LoggerUtils.getCliectIp(request));
        log.setAliType(LoggerUtils.getRequestType(request));
        log.setAliTime(new Date());
        log.setAliMethod(request.getMethod());
        //设置请求开始时间
        request.setAttribute(LOGGER_SEND_TIME, System.currentTimeMillis());
        //设置请求实体到request内，方面afterCompletion方法调用
        request.setAttribute(LOGGER_ENTITY, log);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        LoggerInfo log = (LoggerInfo) request.getAttribute(LOGGER_ENTITY);
        log.setAliHttpStatusCode(response.getStatus() + "");
        long currentTime = System.currentTimeMillis();
        long time = Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());
        log.setAliTimeConsuming(Integer.valueOf((currentTime - time) + ""));
        log.setAliReturmTime(currentTime + "");

        log.setAliReturnData(JSON.toJSONString(request.getAttribute(LoggerUtils.LOGGER_RETURN),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        LoggerJpa jpa = getDAO(LoggerJpa.class, request);
        jpa.save(log);
    }

    private <T> T getDAO(Class<T> clazz, HttpServletRequest request) {
        BeanFactory beanFactory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return beanFactory.getBean(clazz);
    }
}
