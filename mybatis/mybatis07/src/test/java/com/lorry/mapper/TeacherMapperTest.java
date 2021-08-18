package com.lorry.mapper;

import com.lorry.pojo.Student;
import com.lorry.pojo.Teacher;
import com.lorry.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class TeacherMapperTest {

    static Logger logger = Logger.getLogger(StudentMapper.class);
    @Test
    public void studentTest(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = mapper.getstudentByID(1);
            System.out.println(student);
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

    @Test
    public void TestLog(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }
}
