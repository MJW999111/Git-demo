package com.gg.controller;

import com.gg.bean.Student;
import com.gg.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/student")
    @ResponseBody
    public Student getStudentById(@RequestParam("sid") int sid){
        return  studentService.getStudentById(sid);
    }

}
