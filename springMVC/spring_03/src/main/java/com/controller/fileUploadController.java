package com.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class fileUploadController {

    @RequestMapping("/upload")
    public String fileUpload(HttpServletRequest request) throws Exception {
        String path = "D:/upload";
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            if (item.isFormField()){
                //普通表单项
            }else {
                //文件项
                String filename = item.getName();
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
                //完成文件上传
                item.write(new File(path,filename));
                //删除临时文件
                item.delete();
            }
        }
        System.out.println("上传文件成功。。。。。。");
        return "success";
    }


    @RequestMapping("/uploadMVC")
    public String fileUploadMVC (MultipartFile upload) throws IOException {
        String path = "D:/upload";
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //完成文件上传
        upload.transferTo(new File(path,filename));
        System.out.println("springmvc上传文件成功。。。。。。");
        return "success";
    }
}
