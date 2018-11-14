package com.mofei.chapter7;

import com.mofei.chapter7.enums.MailContentTypeEnum;
import com.mofei.chapter7.util.MailSender;

import java.util.ArrayList;

/**
 * @author mofei
 * @date 2018/11/1 18:59
 */
public class Main {
    public static void main(String[] args) throws Exception {
        new MailSender().title("测试springboot发送邮件").content("简单的文本发送").contentType(MailContentTypeEnum.TEXT).targets(new ArrayList<String>(){
            {add("mofeichn@163.com");}
        }).send();
    }
}

