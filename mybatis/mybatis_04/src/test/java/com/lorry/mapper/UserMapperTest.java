package com.lorry.mapper;

import com.lorry.pojo.User;
import com.lorry.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserMapperTest {

    Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void getUserById(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(1);
            System.out.println(user);
        }
    }

    @Test
    public void testLog4J(){
        Logger logger = Logger.getLogger(UserMapperTest.class);
        logger.info("info:进入了testLog4J");
        logger.debug("debug:进入了testLog4J");
        logger.error("error:进入了testLog4J");
    }
    @Test
    public void getUserByLimit(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Integer> map = new HashMap<String,Integer>();
            map.put("startIndex",1);
            map.put("endIndex",4);
            List<User> userList = mapper.getUserByLimit(map);
            for (User user : userList) {
                logger.info("分页查询用户：" + user);
            }
        }
    }
    @Test
    public void getUserByRowBounds(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            RowBounds rowBounds = new RowBounds(1, 4);
            //通过java代码层面实现分页
            List<User> userList = sqlSession.selectList("com.lorry.mapper.UserMapper.getUserByRowBounds",null,rowBounds);
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }
}

