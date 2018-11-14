package com.mofei.chapter8.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author mofei
 * @date 2018/11/14 19:56
 */
@Table(name="t_logger_infos")
public class LoggerInfo implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ali_id")
    private Long aliId;
    @Column(name = "ali_client_ip")
    private String aliClientIp;
    @Column(name = "ali_uri")
    private String aliUri;
    @Column(name = "ali_type")
    private String aliType;
    @Column(name = "ali_method")
    private String aliMethod;
    @Column(name = "ali_param_data")
    private String aliParamData;
    @Column(name = "ali_session_id")
    private String aliSessionId;
    @Column(name = "ali_time")
    private Date aliTime;
    @Column(name = "ali_returm_time")
    private String aliReturmTime;
    @Column(name = "ali_return_data")
    private String aliReturnData;
    @Column(name = "ali_http_status_code")
    private String aliHttpStatusCode;
    @Column(name = "ali_time_consuming")
    private int aliTimeConsuming;

    public Long getAliId() {
        return aliId;
    }

    public void setAliId(Long aliId) {
        this.aliId = aliId;
    }

    public String getAliClientIp() {
        return aliClientIp;
    }

    public void setAliClientIp(String aliClientIp) {
        this.aliClientIp = aliClientIp;
    }

    public String getAliUri() {
        return aliUri;
    }

    public void setAliUri(String aliUri) {
        this.aliUri = aliUri;
    }

    public String getAliType() {
        return aliType;
    }

    public void setAliType(String aliType) {
        this.aliType = aliType;
    }

    public String getAliMethod() {
        return aliMethod;
    }

    public void setAliMethod(String aliMethod) {
        this.aliMethod = aliMethod;
    }

    public String getAliParamData() {
        return aliParamData;
    }

    public void setAliParamData(String aliParamData) {
        this.aliParamData = aliParamData;
    }

    public String getAliSessionId() {
        return aliSessionId;
    }

    public void setAliSessionId(String aliSessionId) {
        this.aliSessionId = aliSessionId;
    }

    public Date getAliTime() {
        return aliTime;
    }

    public void setAliTime(Date aliTime) {
        this.aliTime = aliTime;
    }

    public String getAliReturmTime() {
        return aliReturmTime;
    }

    public void setAliReturmTime(String aliReturmTime) {
        this.aliReturmTime = aliReturmTime;
    }

    public String getAliReturnData() {
        return aliReturnData;
    }

    public void setAliReturnData(String aliReturnData) {
        this.aliReturnData = aliReturnData;
    }

    public String getAliHttpStatusCode() {
        return aliHttpStatusCode;
    }

    public void setAliHttpStatusCode(String aliHttpStatusCode) {
        this.aliHttpStatusCode = aliHttpStatusCode;
    }

    public int getAliTimeConsuming() {
        return aliTimeConsuming;
    }

    public void setAliTimeConsuming(int aliTimeConsuming) {
        this.aliTimeConsuming = aliTimeConsuming;
    }
}
