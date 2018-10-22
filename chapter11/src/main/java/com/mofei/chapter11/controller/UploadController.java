package com.mofei.chapter11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author mofei
 * @date 2018/10/22 14:01
 */
@Controller
public class UploadController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {

        return "index";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //上传的目录地址
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
        //  String uploadDir = request.getSession().getServletContext().getContextPath() + "/upload/";
        //如果目录不存在，则创建
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //上传的文件名
        String originalFilename = file.getOriginalFilename();
        File serverFile = new File(uploadDir + originalFilename);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("fileDir", uploadDir + originalFilename);
        //写入服务器
        try {
            file.transferTo(serverFile);
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("msg", "上传失败");
        }

        request.setAttribute("msg", "上传文件成功");
        return "index";
    }
}
