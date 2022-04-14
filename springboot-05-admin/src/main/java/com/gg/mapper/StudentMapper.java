package com.gg.mapper;

import com.gg.bean.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {

    public Student getStudentById(int sid);


}
