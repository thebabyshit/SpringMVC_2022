package com.mvc.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileController {

    @RequestMapping("file")
    public String filePage(){
        return "fileUpload";
    }

    @RequestMapping("upload")
    public String fileUpload(MultipartFile photo, HttpSession session) throws IOException {
        System.out.println(photo.getName());
        System.out.println(photo.getContentType());
        System.out.println(photo.getOriginalFilename());

        //1.获取文件名
        String fileName = photo.getOriginalFilename();
        //获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();

        //2.获取服务器路径，需要先又Session
        ServletContext servletContext = session.getServletContext();
        //3.获取服务器文件目录路径
        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        if (!file.exists())
            file.mkdir();

        System.out.println(photoPath);
        //4.最终上传路径
        //
        fileName = uuid + suffix;
        String finalPath = photoPath + File.separator + fileName;
        photo.transferTo(new File(finalPath));//抛出异常
        System.out.println(finalPath);
        return "success";
    }

    @RequestMapping("download")
    public ResponseEntity<byte[]> fileDownload(HttpSession session){



        return null;
    }

}
