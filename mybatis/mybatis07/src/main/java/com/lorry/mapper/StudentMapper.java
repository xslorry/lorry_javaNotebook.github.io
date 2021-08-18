package com.lorry.mapper;

import com.lorry.pojo.Student;
import com.lorry.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    //查询所有的学生信息，以及对应的老师信息
     public List<Student> getStudent();

    Student getstudentByID( int id);
}
