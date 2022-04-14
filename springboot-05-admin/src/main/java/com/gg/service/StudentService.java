package com.gg.service;

import com.gg.bean.Student;
import com.gg.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public Student getStudentById(int sid){
        return  studentMapper.getStudentById(sid);
    }

}
