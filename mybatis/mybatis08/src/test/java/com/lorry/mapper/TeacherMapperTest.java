package com.lorry.mapper;

import com.lorry.pojo.Student;
import com.lorry.pojo.Teacher;
import com.lorry.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TeacherMapperTest {

    @Test
    public void TeacherTest(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher_2 = mapper.getTeacher2(1);
            Teacher teacher = mapper.getTeacher(1);
            System.out.println(teacher_2);
        }
    }

    @Test
    public void Test(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> students = mapper.getStudent();
            for (Student student : students) {
                System.out.println(student);
            }

        }
    }
}
