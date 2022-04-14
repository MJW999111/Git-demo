package com.gg.controller;

//文件上传测试

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Log4j2
@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String from_layouts() {
        return "form/form_layouts";
    }

    @GetMapping("/form_advanced_components")
    public String FormAdvancedComponents() {
        return "form/form_advanced_components";
    }


    @GetMapping("/form_validation")
    public String FormValidation() {
        return "form/form_validation";
    }

    @GetMapping("/form_wizard")
    public String FormWizard() {
        return "form/form_wizard";
    }

    /*
     * MultipartFile  自动封装上传过来的文件
     * */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息:email={},username={}," +
                "headerImg={},photos={}",email,username,headerImg.getSize(),photos.length);

        if (!headerImg.isEmpty()){
            //保存到文件服务器， OSS服务器
            //获取到headerImg源文件名
            String headerImgname = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\Tencent Files\\"+headerImgname));
        }

        if (photos.length>0){
            for (MultipartFile photo:photos) {
                if (!photo.isEmpty()){
                    //获取到photos源文件名
                    String photoname = photo.getOriginalFilename();
                    //上传的文件将保存到  D:\Tencent Files\   下
                    photo.transferTo(new File("D:\\Tencent Files\\"+photoname));
                }
            }
        }


        return "main";
    }

}
